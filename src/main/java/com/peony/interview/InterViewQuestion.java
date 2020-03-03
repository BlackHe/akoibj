package com.peony.interview;

public class InterViewQuestion {
    // main线程执行到main方法是，在其虚拟机栈 main-stack 中压入一个栈帧 frame
    public static void main(String[] args) {
        // 在栈帧的局部变量表中增加一个变量s,
        // 在常量池中开辟一块空间，存储“hello”，假设其内存地址为【0x65321】
        // 将变量s的引用地址设置为【0x65321】
        String s = "hello";
        // 比较变量s的引用地址跟常量“hello”的引用地址
        // 即【0x65321】==【0x65321】，逻辑结果为true
        if (s == "hello") {
            System.out.println("s = hello");
        } else {
            System.out.println("s != hello");
        }
    }
}
