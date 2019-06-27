package com.su.brpc.jprotobuf.re.query;

import com.baidu.bjf.remoting.protobuf.EnumReadable;
public enum ReqType implements EnumReadable {
PREDICT(0),LOCK(1);
private final int value;
ReqType(int value) { this.value = value;  }
public int value() { return value; }
}
