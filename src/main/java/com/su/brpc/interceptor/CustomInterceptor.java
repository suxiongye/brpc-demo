package com.su.brpc.interceptor;

import com.baidu.brpc.interceptor.AbstractInterceptor;
import com.baidu.brpc.interceptor.InterceptorChain;
import com.baidu.brpc.protocol.Request;
import com.baidu.brpc.protocol.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 请求拦截器
 *
 * @author suxiongye
 * @date 2019-06-26 20:31
 */
public class CustomInterceptor extends AbstractInterceptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomInterceptor.class);

    /**
     * 处理请求前
     * @param request rpc请求
     * @return 处理请求后
     */
    @Override public boolean handleRequest(Request request) {
        LOGGER.info("Request intercepted, logId = {}, service = {}, method = {}", request.getLogId(),
                request.getTarget().getClass().getSimpleName(), request.getTargetMethod().getName());
        return true;
    }

    /**
     * 该过滤器处理请求
     * @param request 请求
     * @param response 返回
     * @param chain 责任链
     * @throws Exception 异常
     */
    @Override public void aroundProcess(Request request, Response response, InterceptorChain chain) throws Exception {
        LOGGER.info("Around intercepted, before proceed, logId = {}, service = {}, method = {}", request.getLogId(),
                request.getTarget().getClass().getSimpleName(), request.getTargetMethod().getName());
        // 触发过滤器（责任链模式）
        chain.intercept(request, response);
        LOGGER.info("Around intercepted, after proceed, logId = {}, service = {}, method = {}", request.getLogId(),
                request.getTarget().getClass().getSimpleName(), request.getTargetMethod().getName());
    }

    /**
     * 处理返回前
     * @param response 返回结果
     */
    @Override public void handleResponse(Response response) {
        if (null != response) {
            LOGGER.info("Response intercepted, after proceed, logId = {}, result = {}",
                    response.getLogId(),
                    response.getResult());
        }
    }
}
