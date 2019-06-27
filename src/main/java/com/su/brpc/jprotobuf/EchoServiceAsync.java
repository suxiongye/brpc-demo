package com.su.brpc.jprotobuf;

import com.baidu.brpc.client.RpcCallback;

import java.util.concurrent.Future;

/**
 * 异步Service
 *
 * @author suxiongye
 * @date 2019-06-27 14:13
 */
public interface EchoServiceAsync extends EchoService {
    Future<EchoResponse> echo(EchoRequest request, RpcCallback<EchoResponse> callback);
}
