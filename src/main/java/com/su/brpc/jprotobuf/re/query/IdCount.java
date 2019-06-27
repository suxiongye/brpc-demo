package com.su.brpc.jprotobuf.re.query;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.EnumReadable;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
public class IdCount {
@Protobuf(fieldType=FieldType.UINT64, order=1, required=true)
public Long id;
@Protobuf(fieldType=FieldType.DOUBLE, order=2, required=true)
public Double percent;
@Protobuf(fieldType=FieldType.BYTES, order=3, required=false)
public byte[] desc;
@Protobuf(fieldType=FieldType.BYTES, order=4, required=false)
public byte[] str_id;
@Protobuf(fieldType=FieldType.UINT64, order=5, required=true)
public Long base_val;
@Protobuf(fieldType=FieldType.UINT64, order=6, required=false)
public Long pv;
@Protobuf(fieldType=FieldType.UINT64, order=7, required=false)
public Long clk;
@Protobuf(fieldType=FieldType.UINT64, order=8, required=false)
public Long gain;
@Protobuf(fieldType=FieldType.UINT64, order=9, required=false)
public Long uv;
@Protobuf(fieldType=FieldType.OBJECT, order=10, required=false)
public GeoPoint poi;
}
