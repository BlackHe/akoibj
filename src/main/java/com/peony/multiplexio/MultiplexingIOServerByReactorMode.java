package com.peony.multiplexio;

import com.peony.log.Log;
import com.peony.utils.Sleeper;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class MultiplexingIOServerByReactorMode {

    ServerSocketChannel serverSocketChannel;
    int port = 9090;
    Selector selector1;
    Selector selector2;
    Selector selector3;


    private void init() {
        try {
            this.serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.bind(new InetSocketAddress(port));
            // 开启三个 多路复用器
            selector1 = Selector.open();
            selector2 = Selector.open();
            selector3 = Selector.open();

            // 将serverSocketChannel注册到第一个多路复用器上
            serverSocketChannel.register(selector1, SelectionKey.OP_ACCEPT);

            NioThread boss = new NioThread(selector1, 2);
            NioThread work1 = new NioThread(selector2);
            NioThread work2 = new NioThread(selector3);

            boss.start();
            Sleeper.sleep(1);
            work1.start();
            work2.start();
            Log.info("服务器启动成功【%s】", port + "");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {

        MultiplexingIOServerByReactorMode server = new MultiplexingIOServerByReactorMode();
        server.init();
        Sleeper.sleep(100000);
    }


    static class NioThread extends Thread {

        // boss,和worker每个线程都有自己负责的多路复用器
        Selector selector;
        // werker数量
        int selectors = 2;
        // workerId
        int id = 0;
        // 是否boss
        boolean boss = false;

        // 全局的队列
        static BlockingQueue<SocketChannel>[] queues;
        // 全局的自增键
        static AtomicInteger routeCount = new AtomicInteger();

        // boss
        public NioThread(Selector selector, int nselectors) {
            this.selector = selector;
            selectors = nselectors;
            queues = new LinkedBlockingQueue[nselectors];
            for (int i = 0; i < nselectors; i++) {
                queues[i] = new LinkedBlockingQueue<>();
            }
            boss = true;
            Log.info("Boss启动");
        }

        // worker
        public NioThread(Selector selector) {
            this.selector = selector;
            // 给worker分配一个id号
            id = routeCount.incrementAndGet() % selectors;
            Log.info("Worker-[%s]启动", id + "");
        }

        @Override
        public void run() {
            while (true) {
                try {
                    while (selector.select(200) > 0) {
                        Set<SelectionKey> selectionKeys = selector.selectedKeys();
                        Iterator<SelectionKey> iterator = selectionKeys.iterator();
                        while (iterator.hasNext()) {
                            SelectionKey selectionKey = iterator.next();
                            iterator.remove();
                            if (selectionKey.isAcceptable()) {
                                acceptHandle(selectionKey);
                            }
                            if (selectionKey.isReadable()) {
                                readHandle(selectionKey);
                            }
                        }
                    }

                    // worker线程处理自己队列里的任务
                    if (!boss && !queues[id].isEmpty()) {
                        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(2048);
                        SocketChannel client = queues[id].take();
                        client.register(selector, SelectionKey.OP_READ, byteBuffer);
                        Log.info("新客户端【%s】分配到work-%s", client.socket().getPort() + "", id + "");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }

        private void acceptHandle(SelectionKey selectionKey) {
            try {
                ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
                SocketChannel client = serverSocketChannel.accept();
                client.configureBlocking(false);
                //reactor模式的靓点： 客户端socketChannel不再注册到原来的多路复用器上，而是注册到worker线程的多路复用器上
                int index = routeCount.incrementAndGet() % selectors;
                queues[index].offer(client);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void readHandle(SelectionKey selectionKey) {

        }
    }

}
