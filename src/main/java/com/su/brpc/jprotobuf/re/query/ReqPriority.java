package com.su.brpc.jprotobuf.re.query;

import com.baidu.bjf.remoting.protobuf.EnumReadable;
public enum ReqPriority implements EnumReadable {
VERYHIGH(0),HIGH(1),NORMAL(2);
private final int value;
ReqPriority(int value) { this.value = value;  }
public int value() { return value; }
}
