package com.su.brpc.jprotobuf.re.query;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.EnumReadable;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
public class PoTuStat {
@Protobuf(fieldType=FieldType.UINT64, order=1, required=true)
public Long po_id;
@Protobuf(fieldType=FieldType.INT64, order=2, required=true)
public Long tu;
@Protobuf(fieldType=FieldType.BYTES, order=3, required=true)
public byte[] appsid;
@Protobuf(fieldType=FieldType.UINT64, order=4, required=true)
public Long pv;
}
