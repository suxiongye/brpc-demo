package com.su.brpc.jprotobuf.re.query;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.EnumReadable;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
public class PvResult {
@Protobuf(fieldType=FieldType.BYTES, order=1, required=true)
public byte[] date;
@Protobuf(fieldType=FieldType.UINT64, order=2, required=true)
public Long pv;
@Protobuf(fieldType=FieldType.UINT64, order=3, required=true)
public Long pv_cnfd_min;
@Protobuf(fieldType=FieldType.UINT64, order=4, required=true)
public Long pv_cnfd_max;
@Protobuf(fieldType=FieldType.UINT64, order=5, required=false)
public Long page_pv;
@Protobuf(fieldType=FieldType.UINT64, order=6, required=false)
public Long page_pv_cnfd_min;
@Protobuf(fieldType=FieldType.UINT64, order=7, required=false)
public Long page_pv_cnfd_max;
@Protobuf(fieldType=FieldType.DOUBLE, order=8, required=false)
public Double cpm;
@Protobuf(fieldType=FieldType.DOUBLE, order=9, required=false)
public Double cpm_cnfd_min;
@Protobuf(fieldType=FieldType.DOUBLE, order=10, required=false)
public Double cpm_cnfd_max;
}
