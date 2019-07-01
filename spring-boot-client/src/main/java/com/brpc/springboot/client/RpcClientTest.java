package com.brpc.springboot.client;

import com.baidu.brpc.springcloud.api.EchoRequest;
import com.baidu.brpc.springcloud.api.EchoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

/**
 * TODO
 *
 * @author suxiongye
 * @date 2019-07-01 19:22
 */
@SpringBootApplication
@RestController
public class RpcClientTest {
    @Autowired
    private EchoFacade echoFacade;

    public static void main(String[] args) {
        SpringApplication.run(RpcClientTest.class, args);
    }

    @RequestMapping("/echo")
    public String echo() {
        EchoRequest request = new EchoRequest();
        request.setMessage("hello");
        EchoResponse response = echoFacade.echo(request);
        System.out.println(response.getMessage());

        EchoResponse response2 = echoFacade.echo2(request);
        System.out.println(response2.getMessage());

        Future<EchoResponse> future = echoFacade.echo3(request);
        try {
            future.get();
        } catch (Exception ex) {
            // ignore
        }

        return response2.getMessage();
    }
}
