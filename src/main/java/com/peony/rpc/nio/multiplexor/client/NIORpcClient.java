package com.peony.rpc.nio.multiplexor.client;

import com.peony.log.Log;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class NIORpcClient {

    public static void main(String[] args) {
        InetSocketAddress inetSocketAddress = new InetSocketAddress("localhost", 6666);

        SocketChannel channel = null;

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        try {
            channel = SocketChannel.open();

            channel.connect(inetSocketAddress);

            Scanner scanner = new Scanner(System.in);
            while (true){
                byteBuffer.clear();
                Log.info("请输入:");
                String nextLine =scanner.nextLine();

                if ("exit".equals(nextLine)){
                    break;
                }

                byteBuffer.put(nextLine.getBytes("UTF-8"));
                byteBuffer.flip();
                channel.write(byteBuffer);
                byteBuffer.clear();

                int read = channel.read(byteBuffer);
                if (read == -1){
                    break;
                }

                byteBuffer.flip();

                byte[] datas = new byte[byteBuffer.remaining()];
                byteBuffer.get(datas);

                Log.info("服务端：[%s]",new String(datas,"UTF-8"));
                byteBuffer.clear();

            }



        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (channel !=null ){
                try {
                    channel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
