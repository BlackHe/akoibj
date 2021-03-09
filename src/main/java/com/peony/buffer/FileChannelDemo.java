package com.peony.buffer;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelDemo {

    public static void main(String[] args) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("D:\\666.txt","rw");
            RandomAccessFile writeFile = new RandomAccessFile("D:\\777.txt","rw");
            FileChannel channel = randomAccessFile.getChannel();
            FileChannel writechannel = writeFile.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);

            int readed = channel.read(byteBuffer);

            while (readed != -1){
                byteBuffer.flip();
                writechannel.write(byteBuffer);
                byteBuffer.clear();
                readed = channel.read(byteBuffer);
            }
            randomAccessFile.close();
            writeFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
