package com.su.brpc.jprotobuf;

import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;
import lombok.Getter;
import lombok.Setter;

/**
 * Echo返回格式
 *
 * @author suxiongye
 * @date 2019-06-26 19:46
 */
@ProtobufClass
@Getter
@Setter
public class EchoResponse {
    private String message;
}
