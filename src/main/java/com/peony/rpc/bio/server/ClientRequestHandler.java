package com.peony.rpc.bio.server;

import java.io.*;
import java.lang.reflect.Method;
import java.net.Socket;

public class ClientRequestHandler extends Thread implements Runnable{

    private Socket socket;

    public ClientRequestHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        handleRequest();
    }

    public void handleRequest(){
        try {
            InputStream inputStream = socket.getInputStream();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line = bufferedReader.readLine();

            System.out.println(line);

            String[] split = line.split("#");

            Class<?> clazz = Class.forName("com.peony.rpc." + split[0]);

            Method targetMethod = clazz.getDeclaredMethod(split[1]);

            Object result = targetMethod.invoke(clazz.getConstructor().newInstance());

            System.out.println(result);

            handleResult(result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void handleResult(Object result){

        try {

            OutputStream outputStream = socket.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            bufferedWriter.write((String)result);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
