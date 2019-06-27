package com.su.brpc.jprotobuf.re.query;

import com.baidu.bjf.remoting.protobuf.EnumReadable;
public enum IdType implements EnumReadable {
UID(0),ENC_UID(1);
private final int value;
IdType(int value) { this.value = value;  }
public int value() { return value; }
}
