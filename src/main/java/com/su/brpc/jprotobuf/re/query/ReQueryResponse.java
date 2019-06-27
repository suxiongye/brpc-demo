package com.su.brpc.jprotobuf.re.query;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.EnumReadable;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
public class ReQueryResponse {
@Protobuf(fieldType=FieldType.UINT64, order=1, required=true)
public Long req_id;
@Protobuf(fieldType=FieldType.ENUM, order=2, required=true)
public Status status;
@Protobuf(fieldType=FieldType.BYTES, order=3, required=false)
public byte[] message;
@Protobuf(fieldType=FieldType.OBJECT, order=4, required=false)
public EstimateResult result;
@Protobuf(fieldType=FieldType.BOOL, order=5, required=false)
public Boolean need_deduct;
@Protobuf(fieldType=FieldType.UINT64, order=6, required=false)
public Long queue_cap;
}
