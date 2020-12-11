package com.peony.rpc;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class RpcClient {

    public static void main(String[] args) throws Exception{

        Socket socket = new Socket("localhost", 5001);

        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        writer.write("AccountService#createAccount");
        writer.close();
    }
}
