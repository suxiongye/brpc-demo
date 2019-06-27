package com.su.brpc.jprotobuf.re.query;

import com.baidu.bjf.remoting.protobuf.EnumReadable;
public enum OrderType implements EnumReadable {
CPM(1),CPT(2);
private final int value;
OrderType(int value) { this.value = value;  }
public int value() { return value; }
}
