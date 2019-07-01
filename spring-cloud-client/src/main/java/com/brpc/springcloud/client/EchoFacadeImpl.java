package com.brpc.springcloud.client;

import com.baidu.brpc.client.RpcCallback;
import com.baidu.brpc.spring.annotation.RpcProxy;
import com.baidu.brpc.springcloud.api.AsyncEchoService;
import com.baidu.brpc.springcloud.api.EchoRequest;
import com.baidu.brpc.springcloud.api.EchoResponse;
import com.baidu.brpc.springcloud.api.EchoService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * TODO
 *
 * @author suxiongye
 * @date 2019-07-01 17:30
 */
@Service
@Getter
@Setter
public class EchoFacadeImpl implements EchoFacade {
    @RpcProxy(name = "brpc-example-server")
    private EchoService echoService;
    @RpcProxy(name = "brpc-example-server")
    private EchoService echoService2;
    @RpcProxy(name = "brpc-example-server")
    private AsyncEchoService asyncEchoService;

    @Override public EchoResponse echo(EchoRequest request) {
        System.out.println(echoService.hashCode());
        return echoService.echo(request);
    }

    @Override public EchoResponse echo2(EchoRequest request) {
        System.out.println(echoService2.hashCode());
        return echoService.echo(request);
    }

    @Override public Future<EchoResponse> echo3(EchoRequest echoRequest) {
        System.out.println(asyncEchoService.echo(echoRequest));
        Future<EchoResponse> future = asyncEchoService.echo(echoRequest, new RpcCallback<EchoResponse>() {
            @Override public void success(EchoResponse response) {
                System.out.println(response.getMessage());
            }

            @Override public void fail(Throwable e) {
                e.printStackTrace();
            }
        });
        return future;
    }
}
