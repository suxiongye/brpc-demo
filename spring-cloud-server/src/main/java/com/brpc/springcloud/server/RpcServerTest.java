package com.brpc.springcloud.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * TODO
 *
 * @author suxiongye
 * @date 2019-07-01 16:33
 */
@SpringBootApplication
@EnableDiscoveryClient
public class RpcServerTest {
    public static void main(String[] args) {
        SpringApplication springBootApplication = new SpringApplication(RpcServerTest.class);
        springBootApplication.run(args);

        // 保持服务运行
        synchronized (RpcServerTest.class) {
            try {
                RpcServerTest.class.wait();
            } catch (Throwable e) {

            }
        }
    }
}
