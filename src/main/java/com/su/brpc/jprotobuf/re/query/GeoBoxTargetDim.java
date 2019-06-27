package com.su.brpc.jprotobuf.re.query;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.EnumReadable;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
public class GeoBoxTargetDim {
@Protobuf(fieldType=FieldType.BYTES, order=1, required=true)
public byte[] name;
@Protobuf(fieldType=FieldType.OBJECT, order=2, required=true)
public GeoPoint top_left;
@Protobuf(fieldType=FieldType.OBJECT, order=3, required=true)
public GeoPoint bottom_right;
}
