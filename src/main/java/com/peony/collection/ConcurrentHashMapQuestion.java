package com.peony.collection;

import java.util.concurrent.ConcurrentHashMap;

/**
 * ConcurrentHashMap相关问题理解
 */
public class ConcurrentHashMapQuestion {

    public static void main(String[] args) {
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>(16);
        // ConcurrentHashMap的key和value都不能为null,否则后抛出NPE
        concurrentHashMap.put("name",null);
        // 采用了分段锁的机制，锁的粒度缩小到Node节点级别

    }
}
