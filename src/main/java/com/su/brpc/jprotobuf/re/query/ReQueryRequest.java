package com.su.brpc.jprotobuf.re.query;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.EnumReadable;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
public class ReQueryRequest {
@Protobuf(fieldType=FieldType.UINT64, order=1, required=false)
public Long req_id;
@Protobuf(fieldType=FieldType.ENUM, order=2, required=true)
public ReqPriority priority;
@Protobuf(fieldType=FieldType.ENUM, order=3, required=true)
public ReqSrc src;
@Protobuf(fieldType=FieldType.BYTES, order=4)
public java.util.List<byte[]> dates;
@Protobuf(fieldType=FieldType.OBJECT, order=5)
public java.util.List<TargetDim> dim_and;
@Protobuf(fieldType=FieldType.OBJECT, order=6)
public java.util.List<TargetDim> dim_or;
@Protobuf(fieldType=FieldType.OBJECT, order=7)
public java.util.List<TargetDim> dim_not;
@Protobuf(fieldType=FieldType.BOOL, order=8, required=false)
public Boolean need_sample=false;
@Protobuf(fieldType=FieldType.UINT32, order=9, required=false)
public Integer sample_num;
@Protobuf(fieldType=FieldType.BYTES, order=10)
public java.util.List<byte[]> sample_dims;
@Protobuf(fieldType=FieldType.BOOL, order=11, required=false)
public Boolean need_cpm_stat=false;
@Protobuf(fieldType=FieldType.UINT32, order=12, required=false)
public Integer cpm_interval;
@Protobuf(fieldType=FieldType.BOOL, order=13, required=false)
public Boolean need_slot_stat=false;
@Protobuf(fieldType=FieldType.BOOL, order=14, required=false)
public Boolean need_mate_stat=false;
@Protobuf(fieldType=FieldType.BOOL, order=15, required=false)
public Boolean need_avg_ctr=false;
@Protobuf(fieldType=FieldType.BOOL, order=16, required=false)
public Boolean need_avg_cpm=false;
@Protobuf(fieldType=FieldType.BOOL, order=17, required=false)
public Boolean need_sum_pv=false;
@Protobuf(fieldType=FieldType.BOOL, order=18, required=false)
public Boolean need_sum_uv=false;
@Protobuf(fieldType=FieldType.UINT64, order=19, required=false)
public Long resource_id;
@Protobuf(fieldType=FieldType.BOOL, order=20, required=false)
public Boolean need_slotsize_filter=true;
@Protobuf(fieldType=FieldType.BOOL, order=21, required=false)
public Boolean need_ctr_interval_stat=false;
@Protobuf(fieldType=FieldType.UINT32, order=22, required=false)
public Integer ctr_interval_step;
@Protobuf(fieldType=FieldType.OBJECT, order=23)
public java.util.List<DimStatReq> stat_dims;
@Protobuf(fieldType=FieldType.BOOL, order=24, required=false)
public Boolean need_sum_page_pv=false;
@Protobuf(fieldType=FieldType.ENUM, order=25, required=false)
public OrderType order_type=OrderType.CPM;
@Protobuf(fieldType=FieldType.BOOL, order=26, required=false)
public Boolean need_avg_cpm_adjust=true;
@Protobuf(fieldType=FieldType.BOOL, order=27, required=false)
public Boolean need_avg_cpc=false;
@Protobuf(fieldType=FieldType.OBJECT, order=28, required=false)
public GeoCircleTargetDim geo_circle_dim;
@Protobuf(fieldType=FieldType.OBJECT, order=29, required=false)
public GeoBoxTargetDim geo_box_dim;
@Protobuf(fieldType=FieldType.OBJECT, order=30)
public java.util.List<GeoCircleTargetDim> geo_circle_list;
@Protobuf(fieldType=FieldType.BYTES, order=31, required=false)
public byte[] crowd_path;
@Protobuf(fieldType=FieldType.BOOL, order=32, required=false)
public Boolean is_uuid=false;
@Protobuf(fieldType=FieldType.ENUM, order=33, required=false)
public IdType id_type;
@Protobuf(fieldType=FieldType.UINT64, order=34, required=false)
public Long crowd_id;
}
