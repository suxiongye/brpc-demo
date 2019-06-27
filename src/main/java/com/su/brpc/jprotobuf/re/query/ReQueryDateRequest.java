package com.su.brpc.jprotobuf.re.query;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.EnumReadable;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
public class ReQueryDateRequest {
@Protobuf(fieldType=FieldType.UINT64, order=1, required=true)
public Long req_id;
}
