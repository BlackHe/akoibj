package com.peony.zk;

import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.CreateMode;

public class zkTest {

    public static void main(String[] args) {
        //创建会话
        ZkClient zkClient = new ZkClient("127.0.0.1:2181", 3000);

        //创建节点
        String path = "/testnode";
        String data = "hello world";
        //zkClient.createPersistent(path);
        //zkClient.createEphemeral(path);
        zkClient.create(path, data, CreateMode.PERSISTENT);

        System.out.println("是否存在mynode节点：" + zkClient.exists(path));

        //列出根下所有节点
        System.out.println("根下拥有的子节点：" + zkClient.getChildren("/"));
    }
}
