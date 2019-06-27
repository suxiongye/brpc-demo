package com.su.brpc.jprotobuf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 接口实现
 *
 * @author suxiongye
 * @date 2019-06-26 20:09
 */
public class EchoServiceImpl implements EchoService{
    private static final Logger LOGGER = LoggerFactory.getLogger(EchoServiceImpl.class);
    @Override public EchoResponse echo(EchoRequest echoRequest) {
        String message = echoRequest.getMessage();
        EchoResponse response = new EchoResponse();
        response.setMessage(message);
        LOGGER.debug("EchoService.echo, request = {}, response = {}", echoRequest.getMessage(), response.getMessage());
        return response;
    }
}
