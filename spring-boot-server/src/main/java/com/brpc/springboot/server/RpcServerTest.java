package com.brpc.springboot.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring boot 采用zookeeper作为注册中心，需要提前启动zookeeper
 *
 * @author suxiongye
 * @date 2019-07-01 18:52
 */
@SpringBootApplication
public class RpcServerTest {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(RpcServerTest.class);
        application.setWebApplicationType(WebApplicationType.NONE);
        application.run(args);
        // 保持运行
        synchronized (RpcServerTest.class) {
            try {
                RpcServerTest.class.wait();
            } catch (Exception e) {

            }
        }
    }
}
