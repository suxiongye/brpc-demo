package com.su.brpc.jprotobuf.re.query;

import com.baidu.bjf.remoting.protobuf.EnumReadable;
public enum ReqSide implements EnumReadable {
NEW_DSP(0),IM(1);
private final int value;
ReqSide(int value) { this.value = value;  }
public int value() { return value; }
}
