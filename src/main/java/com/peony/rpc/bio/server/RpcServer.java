package com.peony.rpc.bio.server;

import java.net.ServerSocket;
import java.net.Socket;

public class RpcServer {

    public static void main(String[] args) throws Exception{

        ServerSocket serverSocket = new ServerSocket(5001);

        while (true){

            //此处会阻塞
            Socket client = serverSocket.accept();
            // 每个连接，需要一个单独的线程去处理：每连接每线程
            // C10K问题，怎么处理10万个请求，显然，BIO解决不了这个问题
            // 即使是使用了线程是，也还是会有问题，因为客户端socket的读操作是阻塞的，
            // 会占用线程池中有限的线程资源和任务队列资源
            ClientRequestHandler.acceptRequest(client);

        }
    }
}
