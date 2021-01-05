package com.peony.rpc.bio;


import java.io.*;
import java.net.Socket;

public class RpcClient {

    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("localhost", 5001);

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("AccountService#loadAccount".getBytes("UTF-8"));

        InputStream inputStream = socket.getInputStream();
        byte[] buffer = new byte[inputStream.available()];
        inputStream.read(buffer);
        System.out.println("server response : " + new String(buffer, "UTF-8"));

    }
}
