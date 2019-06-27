package com.su.brpc.jprotobuf.re.query;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.EnumReadable;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
public class GeoPoint {
@Protobuf(fieldType=FieldType.DOUBLE, order=1, required=true)
public Double lat;
@Protobuf(fieldType=FieldType.DOUBLE, order=2, required=true)
public Double lon;
}
