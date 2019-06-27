package com.su.brpc.jprotobuf.re.query;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.EnumReadable;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
public class GeoCircleTargetDim {
@Protobuf(fieldType=FieldType.BYTES, order=1, required=true)
public byte[] name;
@Protobuf(fieldType=FieldType.OBJECT, order=2, required=true)
public GeoPoint center;
@Protobuf(fieldType=FieldType.DOUBLE, order=3, required=true)
public Double distance;
}
