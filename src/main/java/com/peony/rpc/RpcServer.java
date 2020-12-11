package com.peony.rpc;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

public class RpcServer {

    public static void main(String[] args) throws Exception{

        ServerSocket serverSocket = new ServerSocket(5001);

        Socket client = serverSocket.accept();

        InputStream inputStream = client.getInputStream();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String line = bufferedReader.readLine();

        System.out.println(line);

        String[] split = line.split("#");

        Class<?> clazz = Class.forName("com.peony.rpc." + split[0]);

        Method targetMethod = clazz.getDeclaredMethod(split[1]);

        Object result = targetMethod.invoke(clazz.getConstructor().newInstance());

        System.out.println(result);

        bufferedReader.close();

        serverSocket.close();
    }
}
