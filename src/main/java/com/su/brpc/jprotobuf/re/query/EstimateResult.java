package com.su.brpc.jprotobuf.re.query;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.EnumReadable;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
public class EstimateResult {
@Protobuf(fieldType=FieldType.UINT64, order=1, required=false)
public Long uv;
@Protobuf(fieldType=FieldType.OBJECT, order=2)
public java.util.List<PvResult> pv_list;
@Protobuf(fieldType=FieldType.DOUBLE, order=4, required=false)
public Double avg_cpm;
@Protobuf(fieldType=FieldType.DOUBLE, order=5, required=false)
public Double avg_ctr;
@Protobuf(fieldType=FieldType.OBJECT, order=6)
public java.util.List<TargetDim> dim_list;
@Protobuf(fieldType=FieldType.OBJECT, order=7)
public java.util.List<IdCount> slot_stat;
@Protobuf(fieldType=FieldType.OBJECT, order=8)
public java.util.List<IdCount> mate_stat;
@Protobuf(fieldType=FieldType.UINT64, order=9, required=false)
public Long ori_pv_sum;
@Protobuf(fieldType=FieldType.OBJECT, order=10)
public java.util.List<IntervalStat> cpm_interval_stat;
@Protobuf(fieldType=FieldType.OBJECT, order=11)
public java.util.List<IntervalStat> ctr_interval_stat;
@Protobuf(fieldType=FieldType.OBJECT, order=12)
public java.util.List<DimStat> dim_stat_list;
@Protobuf(fieldType=FieldType.DOUBLE, order=13, required=false)
public Double origin_avg_cpm;
@Protobuf(fieldType=FieldType.UINT64, order=14, required=false)
public Long daily_avg_pv;
@Protobuf(fieldType=FieldType.UINT64, order=15, required=false)
public Long daily_avg_uv;
@Protobuf(fieldType=FieldType.DOUBLE, order=16, required=false)
public Double avg_cpc;
@Protobuf(fieldType=FieldType.STRING, order=17)
public java.util.List<String> poiid_list;
}
