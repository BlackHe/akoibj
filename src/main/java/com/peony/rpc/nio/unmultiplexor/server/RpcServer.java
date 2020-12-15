package com.peony.rpc.nio.unmultiplexor.server;

import com.peony.charset.CharsetUtils;
import com.peony.log.Log;
import com.peony.utils.SleepUtils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.LinkedList;

public class RpcServer {

    public static void main(String[] args) throws IOException {

        LinkedList<SocketChannel> clientChannels = new LinkedList<>();

        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(4096);

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(16888));
        serverSocketChannel.configureBlocking(false);

        while (true){
            SleepUtils.sleep(1);
            SocketChannel clientChannel = serverSocketChannel.accept();
            if (clientChannel == null){
                System.out.println("accept non block,immediately return");
                continue;
            }
            clientChannel.configureBlocking(false);
            clientChannels.add(clientChannel);

            clientChannels.forEach(i -> {
                Log.info("new client connect: %s",i.socket().getPort()+"");
                try {
                    int count = i.read(byteBuffer);
                    if (count == -1){
                        return;
                    }
                    byteBuffer.flip();
                    byte[] bytes = new byte[byteBuffer.remaining()];
                    byteBuffer.get(bytes);
                    Log.info("client: %s",new String(bytes, CharsetUtils.UTF_8));
                    byteBuffer.clear();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
