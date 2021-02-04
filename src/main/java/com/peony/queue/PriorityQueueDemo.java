package com.peony.queue;

import java.util.PriorityQueue;

public class PriorityQueueDemo {


    static PriorityQueue pq = new PriorityQueue();

    public static void main(String[] args) {
        pq.add("5");
        pq.add("4");
        pq.add("8");
        pq.add("9");
        Object poll = pq.poll();
        System.out.println(poll);

    }
}
