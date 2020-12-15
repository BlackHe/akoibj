package com.peony.rpc.nio.unmultiplexor.client;


import com.peony.utils.Sleeper;

import java.io.OutputStream;
import java.net.Socket;

public class RpcClient {

    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("localhost", 16888);

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("AccountService#loadAccount".getBytes("UTF-8"));

        Sleeper.sleep(100);
    }
}
