package com.baidu.brpc.springcloud.api;

import com.baidu.brpc.protocol.BrpcMeta;

/**
 * 同步服务接口
 *
 * @author suxiongye
 * @date 2019-07-01 15:58
 */
public interface EchoService {
    @BrpcMeta(serviceName = "EchoService", methodName = "Echo")
    EchoResponse echo(EchoRequest request);
}
