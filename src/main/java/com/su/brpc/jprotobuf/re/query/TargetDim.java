package com.su.brpc.jprotobuf.re.query;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.EnumReadable;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
public class TargetDim {
@Protobuf(fieldType=FieldType.BYTES, order=1, required=true)
public byte[] name;
@Protobuf(fieldType=FieldType.ENUM, order=2, required=true)
public ValType type;
@Protobuf(fieldType=FieldType.BYTES, order=3)
public java.util.List<byte[]> str_vals;
@Protobuf(fieldType=FieldType.INT64, order=4)
public java.util.List<Long> int_vals;
@Protobuf(fieldType=FieldType.ENUM, order=5, required=false)
public OpType op_type=OpType.OR;
@Protobuf(fieldType=FieldType.UINT64, order=6)
public java.util.List<Long> uint_vals;
}
