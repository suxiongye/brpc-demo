package com.su.brpc.jprotobuf.re.query;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.EnumReadable;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
public class ReQueryDateResponse {
@Protobuf(fieldType=FieldType.UINT64, order=1, required=true)
public Long req_id;
@Protobuf(fieldType=FieldType.ENUM, order=2, required=true)
public Status status;
@Protobuf(fieldType=FieldType.BYTES, order=3, required=false)
public byte[] message;
@Protobuf(fieldType=FieldType.BYTES, order=4, required=true)
public byte[] start_date;
@Protobuf(fieldType=FieldType.BYTES, order=5, required=true)
public byte[] end_date;
}
