package com.peony.serialize;

import java.io.*;

public class SerializeUtil {

    public static void main(String[] args) throws Exception {
//        serialize();
        deSerialize();
    }

    public static void serialize() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("settlement")));
        oos.writeObject(new Settlement("aslfjkad", 10));
        oos.close();
        System.out.println("对象序列化成功");
    }

    public static void deSerialize() throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("settlement")));
        Settlement settlement = (Settlement) ois.readObject();
        System.out.println(settlement);
        System.out.println("对象反序列化成功");
    }
}
