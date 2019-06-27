package com.su.brpc.jprotobuf.re.query;

import com.baidu.bjf.remoting.protobuf.EnumReadable;
public enum OpType implements EnumReadable {
OR(0),AND(1);
private final int value;
OpType(int value) { this.value = value;  }
public int value() { return value; }
}
