package com.peony.rpc.bio.server;

import com.peony.log.Log;

import java.io.*;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ClientRequestHandler{

    final static int N_CPUS = Runtime.getRuntime().availableProcessors();


    static ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
            N_CPUS+1,
            N_CPUS+1,
            0,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(6)
    );

    public static void acceptRequest(Socket socket){

        poolExecutor.execute(new RequestHandlerWorker(socket));

    }

    static class RequestHandlerWorker implements Runnable{

        Socket socket;

        public RequestHandlerWorker(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            handleRequest(socket);
        }


        private void handleRequest(Socket socket){
            try {

                Log.info("接受到客户端 [%s:%s]",socket.getInetAddress().getHostAddress(),socket.getPort()+"");
                InputStream inputStream = socket.getInputStream();


                int available = inputStream.available();

                byte[] buffer = new byte[available];

                inputStream.read(buffer);

                String line = new String(buffer,"UTF-8");

                System.out.println(line);

                String[] split = line.split("#");

                Class<?> clazz = Class.forName("com.peony.rpc.bio." + split[0]);

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
                byte[] bytes = ((String) result).getBytes("UTF-8");
                outputStream.write(bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }



}
