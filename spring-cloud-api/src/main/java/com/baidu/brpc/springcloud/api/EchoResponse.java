package com.baidu.brpc.springcloud.api;

import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;
import lombok.Getter;
import lombok.Setter;

/**
 * TODO
 *
 * @author suxiongye
 * @date 2019-07-01 15:57
 */
@ProtobufClass
@Setter
@Getter
public class EchoResponse {
    private String message;
}
