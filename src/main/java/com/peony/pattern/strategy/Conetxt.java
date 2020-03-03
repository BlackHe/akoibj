package com.peony.pattern.strategy;

public class Conetxt {

    private Strategy strategy;

    public int doOperation(int a, int b, String operation) {
        this.strategy = StrategyFactory.getStrategy(operation);
        if (strategy == null) {
            throw new RuntimeException("the operation not found");
        }
        return strategy.doOperation(a, b);
    }
}
