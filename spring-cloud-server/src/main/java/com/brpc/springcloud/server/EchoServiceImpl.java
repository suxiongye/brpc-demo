package com.brpc.springcloud.server;

import com.baidu.brpc.spring.annotation.RpcExporter;
import com.baidu.brpc.springcloud.api.EchoRequest;
import com.baidu.brpc.springcloud.api.EchoResponse;
import com.baidu.brpc.springcloud.api.EchoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TODO
 *
 * @author suxiongye
 * @date 2019-07-01 16:03
 */
@RpcExporter
public class EchoServiceImpl implements EchoService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EchoServiceImpl.class);

    @Override public EchoResponse echo(EchoRequest request) {
        String message = request.getMessage();
        EchoResponse response = new EchoResponse();
        response.setMessage(message);
        LOGGER.debug("EchoService.echo , reqeust = {}, response= {}", request.getMessage(), response.getMessage());
        return response;
    }
}
