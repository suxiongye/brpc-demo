package com.su.brpc.jprotobuf;

import com.baidu.brpc.protocol.BrpcMeta;

/**
 * 交互方法接口
 *
 * @author suxiongye
 * @date 2019-06-26 20:07
 */
public interface EchoService {
    @BrpcMeta(serviceName = "EchoService", methodName = "Echo")
    EchoResponse echo(EchoRequest echoRequest);
}
