package com.su.brpc.jprotobuf.re.query;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.EnumReadable;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
public class ReCalcRequest {
@Protobuf(fieldType=FieldType.OBJECT, order=1, required=true)
public ReQueryRequest query_req;
@Protobuf(fieldType=FieldType.ENUM, order=2, required=true)
public ReqType req_type;
@Protobuf(fieldType=FieldType.INT64, order=3, required=false)
public Long purchase;
@Protobuf(fieldType=FieldType.ENUM, order=4, required=false)
public OrderType order_type;
@Protobuf(fieldType=FieldType.ENUM, order=5, required=false)
public ReqSide req_source;
@Protobuf(fieldType=FieldType.UINT64, order=6, required=false)
public Long dspid;
}
