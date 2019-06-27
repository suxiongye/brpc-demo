package com.su.brpc.jprotobuf;

import com.baidu.brpc.server.RpcServer;
import com.baidu.brpc.server.RpcServerOptions;

/**
 * 服务端
 *
 * @author suxiongye
 * @date 2019-06-26 20:11
 */
public class RpcServerTest {
    public static void main(String[] args) throws InterruptedException {
        int port = 8002;
        // 如果有端口则设置端口
        if (args.length == 1) {
            port = Integer.valueOf(args[0]);
        }
        RpcServerOptions options = new RpcServerOptions();
        options.setReceiveBufferSize(64 * 1024 * 1024);
        options.setSendBufferSize(64 * 1024 * 1024);
        RpcServer rpcServer = new RpcServer(port, options);
        // 注册服务
        rpcServer.registerService(new EchoServiceImpl());
        rpcServer.start();
        // 确保服务running
        synchronized (RpcServerTest.class) {
            try {
                RpcServerTest.class.wait();
            } catch (Throwable e) {

            }
        }
    }
}
