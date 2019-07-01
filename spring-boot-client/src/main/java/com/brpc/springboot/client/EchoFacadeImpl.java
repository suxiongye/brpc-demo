package com.brpc.springboot.client;

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
 * @date 2019-07-01 19:19
 */
@Service
@Getter
@Setter
public class EchoFacadeImpl implements EchoFacade{
    @RpcProxy
    private EchoService echoService;
    @RpcProxy
    private EchoService echoService2;
    @RpcProxy
    private AsyncEchoService asyncEchoService;

    @Override public EchoResponse echo(EchoRequest request) {
        System.out.println(echoService.hashCode());
        return echoService.echo(request);
    }

    @Override public EchoResponse echo2(EchoRequest request) {
        System.out.println(echoService2.hashCode());
        return echoService.echo(request);
    }

    @Override public Future<EchoResponse> echo3(EchoRequest request) {
        System.out.println(asyncEchoService.hashCode());
        Future<EchoResponse> future = asyncEchoService.echo(request, new RpcCallback<EchoResponse>() {
            @Override public void success(EchoResponse echoResponse) {
                System.out.println(echoResponse.getMessage());
            }

            @Override public void fail(Throwable throwable) {
                throwable.printStackTrace();
            }
        });
        return future;
    }
}
