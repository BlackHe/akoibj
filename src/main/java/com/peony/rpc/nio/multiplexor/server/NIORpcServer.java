package com.peony.rpc.nio.multiplexor.server;


import com.peony.log.Log;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Scanner;

public class NIORpcServer {

    private static ByteBuffer readBuffer = ByteBuffer.allocate(1024);

    private static ByteBuffer writeBuffer = ByteBuffer.allocate(1024);

    private final static int PORT = 6666;

    private static Selector selector;

    /**
     * select，poll
     * 优势：应用不再遍历fd,而是多个fd,复用一个系统调用，内核自己遍历fd
     * 缺点：它自己不存储fd, 每次都要把fds重新给内核传递一遍，即重复传递fds
     *
     * 解决方案：内核自己开辟空间，存储fds   (epoll就采用了红黑树结构，存储了fds)
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        selector = Selector.open();

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        serverSocketChannel.configureBlocking(false);

        serverSocketChannel.bind(new InetSocketAddress(PORT));

        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        Log.info("server start at port [%s]", PORT + "");

        while (!Thread.currentThread().isInterrupted()) {
            // 注意，此处是阻塞的，只要没有事件，就会一直阻塞
            int select = selector.select();
            // 只要有事件，会批量发现
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                iterator.remove();
                if (!selectionKey.isValid()) {
                    continue;
                }

                if (selectionKey.isAcceptable()) {
                    accept(selectionKey);
                }
                if (selectionKey.isReadable()) {
                    read(selectionKey);
                }
                if (selectionKey.isWritable()) {
                    write(selectionKey);
                }

            }

        }

    }

    public static void accept(SelectionKey selectionKey) {

        ServerSocketChannel channel = (ServerSocketChannel) selectionKey.channel();

        try {
            SocketChannel clientChannel = channel.accept();
            Log.info("接收到客户端：%s", clientChannel.getRemoteAddress().toString());
            clientChannel.configureBlocking(false);
            clientChannel.register(selector, SelectionKey.OP_READ);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void read(SelectionKey selectionKey) {
        SocketChannel channel = (SocketChannel) selectionKey.channel();
        readBuffer.clear();
        try {
            // 注意，此处不会阻塞，因为在此客户端accept的时候，就设置了客户端非阻塞
            int read = channel.read(readBuffer);
            if (read == -1) {
                readBuffer.clear();
                channel.close();
                selectionKey.cancel();
                return;
            }
            readBuffer.flip();
            byte[] datas = new byte[readBuffer.remaining()];
            readBuffer.get(datas);
            Log.info("客户端：%s", new String(datas, "UTF-8"));
            channel.register(selector, SelectionKey.OP_WRITE);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            readBuffer.clear();
        }

    }

    public static void write(SelectionKey selectionKey) {
        SocketChannel channel = (SocketChannel) selectionKey.channel();
        writeBuffer.clear();
        Log.info("请输入：");
        Scanner scanner = new Scanner(System.in);
        String nextLine =scanner.nextLine();
        try {
            writeBuffer.put(nextLine.getBytes("UTF-8"));
            writeBuffer.flip();
            channel.write(writeBuffer);
            channel.register(selector, SelectionKey.OP_READ);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            writeBuffer.clear();
        }

    }
}
