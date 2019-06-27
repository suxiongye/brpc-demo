package com.su.brpc.jprotobuf.re.query;

import com.baidu.bjf.remoting.protobuf.EnumReadable;
public enum ValType implements EnumReadable {
INT(0),STR(1),INT_LIST(2),STR_LIST(3),UINT(4),STR_LIST_WITH_DAY_RANGE(5);
private final int value;
ValType(int value) { this.value = value;  }
public int value() { return value; }
}
