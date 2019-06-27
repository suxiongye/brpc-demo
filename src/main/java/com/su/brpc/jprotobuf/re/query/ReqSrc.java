package com.su.brpc.jprotobuf.re.query;

import com.baidu.bjf.remoting.protobuf.EnumReadable;
public enum ReqSrc implements EnumReadable {
ONLINE(0),OFFLINE(1);
private final int value;
ReqSrc(int value) { this.value = value;  }
public int value() { return value; }
}
