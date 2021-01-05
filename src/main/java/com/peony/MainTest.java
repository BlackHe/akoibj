package com.peony;


import java.io.ObjectOutputStream;
import java.io.Serializable;

public class MainTest implements Serializable {

    private String name;

    private int age;


    static class TwoEle<L, R> implements Cloneable {

        private L left;
        private R right;

        public TwoEle(L left, R right) {
            this.left = left;
            this.right = right;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }


    public static void main(String[] args) throws Exception {
        TwoEle<String, Integer> twoEle = new TwoEle<>("age", 20);
        Node h = new Node("h");
        h.next = new Node("1", new Node("2", new Node("3", null)));
        System.out.println(isCircle(h));
    }

    public static int reverse(int x) {

        int r = 0;
        while (x != 0) {
            r = r * 10 + x % 10;
            x = x / 10;
        }
        System.out.println(r);
        return r;
    }

    public static boolean isCircle(Node head) {

        Node slow = head;
        Node quick = head;
        while (quick != null && quick.next != null && quick.next.next != null && slow.next != null) {
            slow = slow.next;
            quick = quick.next.next;
            if (slow.name.equals(quick.name)) {
                return true;
            }
        }
        return false;
    }


    static class Node {

        public Node(String name) {
            this.name = name;
        }

        Node(String name, Node next) {
            this.name = name;
            this.next = next;
        }

        String name;
        Node next;
    }

}
