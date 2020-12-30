package com.peony.aop;

import com.peony.utils.Sleeper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Component
public class SimpleCalculator implements Calculator {

    @Override
    public int add(int... args) {
        int result = 0;
        for (int arg : args) {
            result += arg;
        }
        Sleeper.sleep(1L);
        return result;
    }

    @Override
    public int subtraction(int a, int b) {
        Sleeper.sleep(2L);
        return a - b;
    }
}
