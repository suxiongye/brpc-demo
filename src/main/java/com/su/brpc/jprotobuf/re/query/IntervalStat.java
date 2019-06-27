package com.su.brpc.jprotobuf.re.query;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.EnumReadable;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
public class IntervalStat {
@Protobuf(fieldType=FieldType.DOUBLE, order=1, required=true)
public Double lower;
@Protobuf(fieldType=FieldType.DOUBLE, order=2, required=true)
public Double upper;
@Protobuf(fieldType=FieldType.DOUBLE, order=3, required=true)
public Double percent;
@Protobuf(fieldType=FieldType.UINT64, order=4, required=false)
public Long pv;
@Protobuf(fieldType=FieldType.UINT64, order=5, required=false)
public Long clk;
@Protobuf(fieldType=FieldType.DOUBLE, order=6, required=false)
public Double ctr;
@Protobuf(fieldType=FieldType.DOUBLE, order=7, required=false)
public Double gain;
@Protobuf(fieldType=FieldType.DOUBLE, order=8, required=false)
public Double cpm;
}
