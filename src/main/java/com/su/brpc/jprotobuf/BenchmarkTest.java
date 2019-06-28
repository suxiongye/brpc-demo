package com.su.brpc.jprotobuf;

import com.baidu.brpc.client.BrpcProxy;
import com.baidu.brpc.client.RpcCallback;
import com.baidu.brpc.client.RpcClient;
import com.baidu.brpc.client.RpcClientOptions;
import com.baidu.brpc.client.channel.ChannelType;
import com.baidu.brpc.client.loadbalance.LoadBalanceStrategy;
import com.baidu.brpc.protocol.Options;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;

/**
 * 基准测试（性能测试）
 *
 * @author suxiongye
 * @date 2019-06-27 19:40
 */
@Slf4j
public class BenchmarkTest {
    private static volatile boolean stop = false;

    public static void main(String[] args) {
        String serviceUrl;
        int threadNum;
        // 设置默认参数
        if (args.length != 2) {
            System.out.println("Usage : BenchmarkTest 127.0.0.1:8002 threadNUm");
            serviceUrl = "list://127.0.0.1:8002";
            threadNum = 2;
        } else {
            serviceUrl = args[0];
            threadNum = Integer.parseInt(args[1]);
        }
        // 配置常用参数
        RpcClientOptions rpcClientOptions = new RpcClientOptions();
        rpcClientOptions.setProtocolType(Options.ProtocolType.PROTOCOL_BAIDU_STD_VALUE);
        rpcClientOptions.setLoadBalanceType(LoadBalanceStrategy.LOAD_BALANCE_FAIR);
        rpcClientOptions.setMaxTotalConnections(1000000);
        rpcClientOptions.setMinIdleConnections(10);
        rpcClientOptions.setConnectTimeoutMillis(1000);
        rpcClientOptions.setWriteTimeoutMillis(1000);
        rpcClientOptions.setReadTimeoutMillis(5000);
        rpcClientOptions.setTcpNoDelay(false);
        rpcClientOptions.setChannelType(ChannelType.SINGLE_CONNECTION);

        RpcClient rpcClient = new RpcClient(serviceUrl, rpcClientOptions, null);
        EchoServiceAsync echoServiceAsync = BrpcProxy.getProxy(rpcClient, EchoServiceAsync.class);

        // 从文件读取数据流
        byte[] messageBytes = null;
        InputStream inputStream = Thread.currentThread().getClass().getResourceAsStream("/message_1k.txt");
        try {
            int length = inputStream.available();
            messageBytes = new byte[length];
            inputStream.read(messageBytes);
            log.info("message size = " + messageBytes.length);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        // 多线程并发请求
        SendInfo[] sendInfos = new SendInfo[threadNum];
        Thread[] threads = new Thread[threadNum];
        // 多线程并发访问
        for (int i = 0; i < threadNum; i++) {
            sendInfos[i] = new SendInfo();
            threads[i] = new Thread(new ThreadTask(rpcClient, echoServiceAsync, messageBytes, sendInfos[i]), "work"
                    + "-thread-" + i);
            threads[i].start();
        }

        // 统计功能
        long lastSuccessRequestNum = 0;
        long lastFailRequestNum = 0;
        long lastElapsedNs = 0;
        int second = 0;
        long skippedQps = 0;
        while (!stop) {
            long beginTime = System.nanoTime();
            try {
                // 计时器每秒统计一次
                Thread.sleep(1000);
                ++second;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            long successNum = 0;
            long failNum = 0;
            long elapseNs = 0;
            long averageElapsedNs = 0;

            // 统计各个线程成功、失败数目及总耗时
            for (SendInfo sendInfo : sendInfos) {
                successNum += sendInfo.successRequestNum;
                failNum += sendInfo.failRequestNum;
                elapseNs += sendInfo.elapsedNs;
            }

            // 排除上一次统计的数据
            if (successNum - lastSuccessRequestNum > 0) {
                averageElapsedNs = (elapseNs - lastElapsedNs) / (successNum - lastSuccessRequestNum);
            }
            long endTime = System.nanoTime();
            String msg = String.format("success = %s, fail = %s, average=%s ns",
                    (successNum - lastSuccessRequestNum) * 1000 * 1000 * 1000 / (endTime - beginTime),
                    (failNum - lastFailRequestNum) * 1000 * 1000 * 1000 / (endTime - beginTime), averageElapsedNs);
            lastSuccessRequestNum = successNum;
            lastFailRequestNum = failNum;
            lastElapsedNs = elapseNs;

            // 从第30秒开始计算平均qps
            if (second > 30) {
                long avgQps = (lastSuccessRequestNum - skippedQps) / (second - 30);
                msg = msg + ", avgQps = " + avgQps;
            } else {
                skippedQps = lastSuccessRequestNum;
            }

            log.info(msg);
        }
    }

    // 统计信息
    public static class SendInfo {
        public long successRequestNum = 0;
        public long failRequestNum = 0;
        public long elapsedNs = 0;
    }

    // 回调处理函数
    public static class EchoCallback implements RpcCallback<EchoResponse> {
        private long startTime;
        private SendInfo sendInfo;

        public EchoCallback(long startTime, SendInfo sendInfo) {
            this.startTime = startTime;
            this.sendInfo = sendInfo;
        }

        @Override public void success(EchoResponse response) {
            if (null != response) {
                sendInfo.successRequestNum++;
                // 计算时间
                long elapseTimeNs = System.nanoTime() - startTime;
                sendInfo.elapsedNs += elapseTimeNs;
                log.debug("asyn call success, elapseTimeNs = {}", elapseTimeNs);
            } else {
                sendInfo.failRequestNum++;
                log.debug("async call failed");
            }
        }

        @Override public void fail(Throwable e) {
            sendInfo.failRequestNum++;
            log.debug("async call failed, {}", e.getMessage());
        }
    }

    // 线程任务
    public static class ThreadTask implements Runnable {
        EchoServiceAsync echoServiceAsync;
        private RpcClient rpcClient;
        private byte[] messageBytes;
        private SendInfo sendInfo;

        public ThreadTask(RpcClient rpcClient, EchoServiceAsync echoServiceAsync, byte[] messageBytes,
                          SendInfo sendInfo) {
            this.rpcClient = rpcClient;
            this.echoServiceAsync = echoServiceAsync;
            this.messageBytes = messageBytes;
            this.sendInfo = sendInfo;
        }

        @Override public void run() {
            // 发送请求
            EchoRequest request = new EchoRequest();
            request.setMessage(new String(messageBytes));
            while (!stop) {
                try {
                    echoServiceAsync.echo(request, new EchoCallback(System.nanoTime(), sendInfo));
                } catch (Exception ex) {
                    log.info("Send Exception : " + ex.getMessage());
                    sendInfo.failRequestNum++;
                }
            }
        }
    }
}

