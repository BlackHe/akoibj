package com.peony.aop;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class SimpleCalculator implements Calculator {
    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int subtraction(int a, int b) {
        return a - b;
    }
}
