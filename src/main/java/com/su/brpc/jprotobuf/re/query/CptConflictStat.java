package com.su.brpc.jprotobuf.re.query;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.EnumReadable;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
public class CptConflictStat {
@Protobuf(fieldType=FieldType.BYTES, order=1, required=true)
public byte[] date;
@Protobuf(fieldType=FieldType.OBJECT, order=2)
public java.util.List<PoTuStat> po_tu_stat;
}
