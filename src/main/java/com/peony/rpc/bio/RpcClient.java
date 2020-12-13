package com.peony.rpc.bio;


import java.io.*;
import java.net.Socket;

public class RpcClient {

    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("localhost", 5001);

        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        writer.write("AccountService#loadAccount");

        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        String response = bufferedReader.readLine();
        System.out.println("server response : " + response);

    }
}
