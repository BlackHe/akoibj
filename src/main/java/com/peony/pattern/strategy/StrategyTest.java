package com.peony.pattern.strategy;

public class StrategyTest {

    public static void main(String[] args) {
        String operation = "add";
        Conetxt conetxt = new Conetxt();
        int i = conetxt.doOperation(1, 6, operation);
        System.out.println(i);

    }
}
