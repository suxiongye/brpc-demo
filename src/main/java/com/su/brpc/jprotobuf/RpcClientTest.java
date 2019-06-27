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
import io.netty.channel.Channel;

import java.util.ArrayList;
import java.util.List;

/**
 * 客户端测试
 *
 * @author suxiongye
 * @date 2019-06-26 20:24
 */
public class RpcClientTest {
    public static void main(String[] args) {
        RpcClientOptions clientOptions = new RpcClientOptions();
        /**
         * 协议类型，brpc支持的协议包括
         */
        clientOptions.setProtocolType(Options.ProtocolType.PROTOCOL_BAIDU_STD_VALUE);
        clientOptions.setWriteTimeoutMillis(10000);
        clientOptions.setReadTimeoutMillis(10000);
        clientOptions.setMaxTotalConnections(1000);
        clientOptions.setMinIdleConnections(10);
        clientOptions.setLoadBalanceType(LoadBalanceStrategy.LOAD_BALANCE_FAIR);
        clientOptions.setCompressType(Options.CompressType.COMPRESS_TYPE_NONE);

        String serviceUrl = "bns://im-server.NOVA.all:rt";
        if (args.length == 1) {
            serviceUrl = args[0];
        }

        List<Interceptor> interceptors = new ArrayList<>();
        interceptors.add(new CustomInterceptor());
        RpcClient rpcClient = new RpcClient(serviceUrl, clientOptions, interceptors);
        // 发送请求
        EchoRequest echoRequest = new EchoRequest();
        echoRequest.setMessage("Hello world!");

        ReService reService = BrpcProxy.getProxy(rpcClient, ReService.class);
        try {
            ReQueryResponse reQueryResponse = reService.reQuery(new ReQueryRequest());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }


        // 同步传输
        EchoService echoService = BrpcProxy.getProxy(rpcClient, EchoService.class);
        try {
            EchoResponse response = echoService.echo(echoRequest);
            System.out.printf("Syn call service = EchoService.echo success, request = %s, response = %s\n",
                    echoRequest.getMessage(), response.getMessage());
        } catch (RpcException ex) {
            System.out.println("Sync call faild, ex = " +  ex.getMessage());
        }
        rpcClient.stop();

        // 测试异步
        RpcCallback callback = new RpcCallback<EchoResponse>() {
            @Override public void success(EchoResponse echoResponse) {

            }

            @Override public void fail(Throwable throwable) {

            }
        };
        rpcClient.stop();
    }
}
