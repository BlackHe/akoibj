package com.peony.multiplexio;

import com.peony.log.Log;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class MultiplexingIOServerBySingleThread {

    private ServerSocketChannel serverSocketChannel;

    // 准备多路复用器， 底层实现在不用的平台略有不同，linux[epoll,poll,select] windows[iocp] unix[kqueue]
    private static Selector selector;

    private int port;


    public MultiplexingIOServerBySingleThread() {
        this.port = 9090;
    }

    private void init(){
        try {
            this.serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.bind(new InetSocketAddress(port));
            selector = Selector.open();
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            Log.info("服务器启动了，端口为：【%s】",port+"");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        MultiplexingIOServerBySingleThread server = new MultiplexingIOServerBySingleThread();
        server.init();
        //只是向内核询问IO状态
        while (true){
            if (selector.select() > 0){
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()){
                    SelectionKey selectionKey = iterator.next();
                    iterator.remove();
                    if (selectionKey.isAcceptable()){
                        server.handleAccept(selectionKey);
                    }else if (selectionKey.isReadable()){
                        server.handleRead(selectionKey);
                    }
                }
            }
        }


    }

    private void handleAccept(SelectionKey selectionKey){
        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
        try {
            SocketChannel clientSocketChannel = serverSocketChannel.accept();
            Log.info("客户端接入：【%s】",clientSocketChannel.socket().getPort()+"");
            clientSocketChannel.configureBlocking(false);
            ByteBuffer buffer = ByteBuffer.allocate(2048);
            clientSocketChannel.register(selector,SelectionKey.OP_READ,buffer);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * ByteBuffer的操作四步骤
     * 1.写入数据到buffer
     * 2.buffer.flip()
     * 3.从buffer中读取数据
     * 4.buffer.clear() 清空缓冲区 buffer.compact() 清空已经读取了的部分区域
     *
     * @param selectionKey
     * @throws IOException
     */
    private void handleRead(SelectionKey selectionKey) throws IOException{
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        ByteBuffer buffer = (ByteBuffer) selectionKey.attachment();
        // 把buffer清理一下，准备把channel中的数据，读入到buffer中
        buffer.clear();

        int readed = socketChannel.read(buffer);
        while (readed > 0){
            buffer.flip();
            socketChannel.write(buffer);
            buffer.clear();
            readed = socketChannel.read(buffer);
        }

        if (readed == -1){
            Log.info("客户端已关闭：【%s】",socketChannel.socket().getPort()+"");
            socketChannel.close();
        }


    }


}
