package com.su.brpc.jprotobuf.re.query;

import com.baidu.bjf.remoting.protobuf.EnumReadable;
public enum Status implements EnumReadable {
SUCCEED(0),RE_QUERY_ERROR(1),SEARCHDB_ERROR(2),RE_CALC_ERROR(3),DELETE_ERROR(4),PURCHASE_ERROR(5),INVALID_QUERY(6),RE_CALC_CPT_LOCK_ERROR(7),ZERO_INVENTORY_ERROR(8),INVENTORY_NOT_ENOUGH(9),FIGURE_TASK_QUEUE_FULL_ERROR(10);
private final int value;
Status(int value) { this.value = value;  }
public int value() { return value; }
}
