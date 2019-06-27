package com.su.brpc.jprotobuf.re.query;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.EnumReadable;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
public class DimStat {
@Protobuf(fieldType=FieldType.BYTES, order=1, required=false)
public byte[] dim_name;
@Protobuf(fieldType=FieldType.ENUM, order=2, required=false)
public ValType type;
@Protobuf(fieldType=FieldType.OBJECT, order=3)
public java.util.List<IdCount> stat;
}
