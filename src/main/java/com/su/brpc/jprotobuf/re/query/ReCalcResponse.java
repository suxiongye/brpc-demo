package com.su.brpc.jprotobuf.re.query;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.EnumReadable;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
public class ReCalcResponse {
@Protobuf(fieldType=FieldType.OBJECT, order=1, required=true)
public ReQueryResponse query_res;
@Protobuf(fieldType=FieldType.ENUM, order=2, required=true)
public Status status;
@Protobuf(fieldType=FieldType.BYTES, order=3, required=false)
public byte[] message;
@Protobuf(fieldType=FieldType.OBJECT, order=4)
public java.util.List<CptConflictStat> cpt_stat;
}
