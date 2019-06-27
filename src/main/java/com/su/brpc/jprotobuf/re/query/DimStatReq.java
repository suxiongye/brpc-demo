package com.su.brpc.jprotobuf.re.query;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.EnumReadable;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
public class DimStatReq {
@Protobuf(fieldType=FieldType.BYTES, order=1, required=true)
public byte[] dim_name;
@Protobuf(fieldType=FieldType.UINT32, order=2, required=true)
public Integer max_num;
@Protobuf(fieldType=FieldType.BOOL, order=3, required=false)
public Boolean need_uv=false;
}
