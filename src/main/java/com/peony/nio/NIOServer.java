package com.peony.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Iterator;

public class NIOServer {

    private static ByteBuffer readBuffer = ByteBuffer.allocateDirect(1024);

    public static void main(String[] args) throws IOException {

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        ServerSocket serverSocket = serverSocketChannel.socket();

        serverSocket.bind(new InetSocketAddress(9000));
        System.out.println("listening port 9000");

        Selector selector = Selector.open();
        serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);


        while (selector.select() > 0){

            Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();

            while (keyIterator.hasNext()){

                SelectionKey selectionKey = keyIterator.next();
                keyIterator.remove();

                if (selectionKey.isAcceptable()){
                    System.out.printf("监听到客户端连接\n");
                    ServerSocketChannel server = (ServerSocketChannel)selectionKey.channel();
                    SocketChannel clientChannel = server.accept();
                    System.out.printf("对方地址:[%s]\n",clientChannel.getRemoteAddress());
                    if (clientChannel == null) continue;
                    clientChannel.configureBlocking(false);
                    clientChannel.register(selector,SelectionKey.OP_READ);
                    clientChannel.register(selector,SelectionKey.OP_WRITE);

                    ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
                    byteBuffer.put("hi new channel".getBytes());
                    byteBuffer.flip();

                    clientChannel.write(byteBuffer);
                }
                
                if(selectionKey.isReadable()){
                    System.out.println("监听到可读事件");
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();

                    readBuffer.clear();
                    socketChannel.read(readBuffer);
                    readBuffer.flip();

                    String receiveDate = Charset.forName("UTF-8").decode(readBuffer).toString();
                    System.out.printf("读到的数据：【%s】\n",receiveDate);

                }
            }
        }

    }
}
