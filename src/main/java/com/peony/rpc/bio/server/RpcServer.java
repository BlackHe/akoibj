package com.peony.rpc.bio.server;

import java.net.ServerSocket;
import java.net.Socket;

public class RpcServer {

    public static void main(String[] args) throws Exception{

        ServerSocket serverSocket = new ServerSocket(5001);

        while (true){

            //此处会阻塞
            Socket client = serverSocket.accept();
            //每个连接，需要一个单独的线程去处理：每连接每线程
            new ClientRequestHandler(client).start();

        }
    }
}
