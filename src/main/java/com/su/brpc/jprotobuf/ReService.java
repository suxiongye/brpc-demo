package com.su.brpc.jprotobuf;

import com.baidu.brpc.protocol.BrpcMeta;
import com.su.brpc.jprotobuf.re.query.ReQueryRequest;
import com.su.brpc.jprotobuf.re.query.ReQueryResponse;

/**
 * TODO
 *
 * @author suxiongye
 * @date 2019-06-27 15:42
 */
public interface ReService {
    @BrpcMeta(serviceName = "ReQueryService", methodName = "re_query_realtime")
    ReQueryResponse reQuery(ReQueryRequest reQueryRequest);

}
