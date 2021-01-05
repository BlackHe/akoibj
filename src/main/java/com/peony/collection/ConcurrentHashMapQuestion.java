package com.peony.collection;

import java.util.concurrent.ConcurrentHashMap;

/**
 * ConcurrentHashMap相关问题理解
 */
public class ConcurrentHashMapQuestion {

    public static void main(String[] args) {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>(16);
        map.put("name", "black");
        // ConcurrentHashMap的key和value都不能为null,否则后抛出NPE
//        concurrentHashMap.put("name",null);
        // 采用了分段锁的机制，锁的粒度缩小到Node节点级别

        Hnode hnode = new Hnode("china",
                new Hnode("gansu",
                        new Hnode("linxia",
                                new Hnode("beiyuan",
                                        new Hnode("qianshi", null)))));
        String print = hnode.print();
        System.out.println(print);


    }

    static class Hnode {
        private String key;
        private Hnode next;

        Hnode(String key, Hnode next) {
            this.key = key;
            this.next = next;
        }

        Hnode() {
        }

        public String print() {
            Hnode hnode = this;
            String sb = "[";
            do {
                sb = sb + "|" + hnode.key;
            } while ((hnode = hnode.next) != null);
            sb = sb + "]";
            return sb;
        }
    }
}
