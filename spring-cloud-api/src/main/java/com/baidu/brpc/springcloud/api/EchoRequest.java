package com.baidu.brpc.springcloud.api;

import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;
import lombok.Getter;
import lombok.Setter;

/**
 * 请求类
 *
 * @author suxiongye
 * @date 2019-07-01 15:56
 */
@ProtobufClass
@Getter
@Setter
public class EchoRequest {
    private String message;
}
