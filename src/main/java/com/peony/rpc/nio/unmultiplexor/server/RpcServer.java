package com.peony.rpc.nio.unmultiplexor.server;

import com.peony.charset.CharsetUtils;
import com.peony.log.Log;
import com.peony.utils.Sleeper;

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
            Sleeper.sleep(1);
            SocketChannel clientChannel = serverSocketChannel.accept();
            if (clientChannel == null){
                System.out.println("accept non block,immediately return");
            }else {
                clientChannel.configureBlocking(false);
                clientChannels.add(clientChannel);
            }


            clientChannels.forEach(i -> {
                Log.info("new client connect: %s",i.socket().getPort()+"");
                try {
                    /**NIO的问题*/
                    // 非阻塞是实现了，
                    // 但是，每次处理客户端读写，都要调用 read，如果有10w个客户端连接，那就要调10w次read，而read是个系统调用。
                    // read因为要读取网卡数据，需要切换到内核态才能调用，要从用户态切换到内核态，用户线程会产生中断，即软中断,80中断
                    // 问题的本质，还是在于上层应用无法被动感知到客户端连接有了IO事件，而是要主动去【轮询】系统底层
                    // 假设10w个连接，只有一个客户端发来数据，那其余999999次系统调用是无意义的
                    /**解决方案*/
                    // 1.如果内核支持批量的客户端fd查询是否有IO事件，如果有，再把有IO事件的这些fd返回，上层应用只查询有IO事件的这些fd。可以解决用户态循环遍历系统调用的问题 。这也就是多路复用的原理了
                    // 即一个系统调用中，放了很多个fd，很多条路，复用了一个系统调用，这就是【【【【多路复用】】】】
                    // 2.如果内核回调上层应用，或发布异步IO事件，上层应用被动感知到IO事件，也可以解决用户态循环遍历系统调用的问题
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
