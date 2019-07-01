package com.brpc.springcloud.client;

import com.baidu.brpc.client.RpcClient;
import com.baidu.brpc.springcloud.api.EchoRequest;
import com.baidu.brpc.springcloud.api.EchoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

/**
 * TODO
 *
 * @author suxiongye
 * @date 2019-07-01 17:33
 */
@SpringBootApplication
@RestController
@EnableEurekaClient
public class RpcClientTest {
    @Autowired
    private EchoFacade echoFacade;

    public static void main(String[] args) {
        SpringApplication.run(RpcClientTest.class, args);
    }

    @RequestMapping("/echo")
    private String echo() {
        EchoRequest request = new EchoRequest();
        request.setMessage("hiiiii");
        EchoResponse echoResponse = echoFacade.echo(request);
        System.out.println(echoResponse.getMessage());

        echoResponse = echoFacade.echo2(request);
        System.out.println(echoResponse);

        Future<EchoResponse> future = echoFacade.echo3(request);
        try {
            future.get();
            System.out.println("Async success");
        }catch (Exception ex) {
        }
        return echoResponse.getMessage();
    }
}
