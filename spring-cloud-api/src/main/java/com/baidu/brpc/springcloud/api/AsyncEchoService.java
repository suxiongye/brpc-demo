package com.baidu.brpc.springcloud.api;

import com.baidu.brpc.client.RpcCallback;
import com.baidu.brpc.protocol.BrpcMeta;

import java.util.concurrent.Future;

/**
 * 异步服务接口
 *
 * @author suxiongye
 * @date 2019-07-01 15:59
 */
public interface AsyncEchoService extends EchoService{
    @BrpcMeta(serviceName = "EchoService", methodName = "Echo")
    Future<EchoResponse> echo(EchoRequest request, RpcCallback<EchoResponse> callback);
}
