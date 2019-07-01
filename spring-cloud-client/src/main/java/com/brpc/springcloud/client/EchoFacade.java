package com.brpc.springcloud.client;

import com.baidu.brpc.springcloud.api.EchoRequest;
import com.baidu.brpc.springcloud.api.EchoResponse;
import org.apache.tools.ant.taskdefs.Echo;

import java.util.concurrent.Future;

/**
 * Echo 接口门面类
 *
 * @author suxiongye
 * @date 2019-07-01 17:09
 */
public interface EchoFacade {
    EchoResponse echo(EchoRequest request);
    EchoResponse echo2(EchoRequest request);
    Future<EchoResponse> echo3(EchoRequest echoRequest);
}
