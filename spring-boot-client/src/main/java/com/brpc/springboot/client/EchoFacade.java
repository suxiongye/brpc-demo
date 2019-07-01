package com.brpc.springboot.client;

import com.baidu.brpc.springcloud.api.EchoRequest;
import com.baidu.brpc.springcloud.api.EchoResponse;

import java.util.concurrent.Future;

/**
 * TODO
 *
 * @author suxiongye
 * @date 2019-07-01 19:17
 */
public interface EchoFacade {
    EchoResponse echo(EchoRequest request);
    EchoResponse echo2(EchoRequest request);
    Future<EchoResponse> echo3(EchoRequest request);
}
