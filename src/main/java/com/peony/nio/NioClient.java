package com.peony.nio;

import com.peony.utils.Sleeper;
import io.netty.util.CharsetUtil;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.time.Instant;
import java.util.Iterator;
import java.util.Set;

public class NioClient {

    private SocketChannel socketChannel;

    public static void main(String[] args) throws Exception {
        new NioClient().start();
    }

    public void start() throws Exception{

        socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);

        socketChannel.connect(new InetSocketAddress("localhost", 8080));
        socketChannel.finishConnect();
        System.out.println("连接到服务器 :");

        ByteBuffer buffer = ByteBuffer.allocate(16);
        while (true){
            buffer.clear();
            System.out.println("请输入指令...");
            InputStream in = System.in;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
            String s = bufferedReader.readLine();
            if ("exit".equals(s)){
                break;
            }
            // 发送16个字节，如果以Long类型解码，需要解码为两个Long对象
            buffer.putLong(Long.parseLong(s));
            buffer.flip();
            socketChannel.write(buffer);

            buffer.flip();

            int read = socketChannel.read(buffer);
            System.out.println("接收到服务端的"+read+"个字节");
            buffer.flip();
            System.out.println("接收到服务端的消息："+buffer.getLong());

        }

        System.out.println("bye bye..");
        socketChannel.close();
    }
}
