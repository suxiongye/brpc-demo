package com.su.brpc.jprotobuf;

import com.baidu.brpc.client.BrpcProxy;
import com.baidu.brpc.client.RpcCallback;
import com.baidu.brpc.client.RpcClient;
import com.baidu.brpc.client.RpcClientOptions;
import com.baidu.brpc.client.loadbalance.LoadBalanceStrategy;
import com.baidu.brpc.exceptions.RpcException;
import com.baidu.brpc.interceptor.Interceptor;
import com.baidu.brpc.protocol.Options;
import com.su.brpc.interceptor.CustomInterceptor;
import com.su.brpc.jprotobuf.re.query.ReQueryRequest;
import com.su.brpc.jprotobuf.re.query.ReQueryResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

/**
 * 客户端测试
 *
 * @author suxiongye
 * @date 2019-06-26 20:24
 */
public class RpcClientTest {
    public static void main(String[] args) {
        RpcClientOptions clientOptions = new RpcClientOptions();

        // 协议类型
        clientOptions.setProtocolType(Options.ProtocolType.PROTOCOL_BAIDU_STD_VALUE);
        // 超时设置
        clientOptions.setWriteTimeoutMillis(10000);
        clientOptions.setReadTimeoutMillis(10000);
        clientOptions.setMaxTotalConnections(1000);
        clientOptions.setMinIdleConnections(10);
        clientOptions.setLoadBalanceType(LoadBalanceStrategy.LOAD_BALANCE_FAIR);
        clientOptions.setCompressType(Options.CompressType.COMPRESS_TYPE_NONE);

        String serviceUrl = "list://127.0.0.1:8002";
        if (args.length == 1) {
            serviceUrl = args[0];
        }

        List<Interceptor> interceptors = new ArrayList<>();
        interceptors.add(new CustomInterceptor());
        RpcClient rpcClient = new RpcClient(serviceUrl, clientOptions, interceptors);
        // 发送请求
        EchoRequest echoRequest = new EchoRequest();
        echoRequest.setMessage("Hello world!");

        // 同步传输
        EchoService echoService = BrpcProxy.getProxy(rpcClient, EchoService.class);
        try {
            EchoResponse response = echoService.echo(echoRequest);
            System.out.printf("Syn call service = EchoService.echo success, request = %s, response = %s\n",
                    echoRequest.getMessage(), response.getMessage());
        } catch (RpcException ex) {
            System.out.println("Sync call faild, ex = " + ex.getMessage());
        }
        rpcClient.stop();

        // 测试异步
        RpcCallback callback = new RpcCallback<EchoResponse>() {
            // 回调成功
            @Override public void success(EchoResponse echoResponse) {
                if (null != echoResponse) {
                    System.out.printf("Sync call service = EchoService.echo success, response=%s\n",
                            echoResponse.getMessage());
                }
            }

            // 回调失败
            @Override public void fail(Throwable throwable) {
                System.out.printf("Sync call service = EchoService.echo fail, %s\n",
                        throwable.getMessage());
            }
        };

        // 重新设定rpcClient，否则会抛异常
        rpcClient =  new RpcClient(serviceUrl, clientOptions, interceptors);
        EchoServiceAsync echoServiceAsync = BrpcProxy.getProxy(rpcClient, EchoServiceAsync.class);
        try {
            Future<EchoResponse> responseFuture = echoServiceAsync.echo(echoRequest, callback);
            try {
                // 等待回调
                if (responseFuture != null) {
                    responseFuture.get();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } catch (RpcException ex) {
            System.out.println("RPC send failed, ex=" + ex.getMessage());
        }

        rpcClient.stop();
    }
}
