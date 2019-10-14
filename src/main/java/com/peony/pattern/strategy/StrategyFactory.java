package com.peony.pattern.strategy;

import java.util.HashMap;
import java.util.Map;

public class StrategyFactory {

    private final static Map<String,Strategy> map = new HashMap<String,Strategy>();

    static {
        map.put("add",new OperationAdd());
        map.put("substract",new OperationSubstract());
        map.put("mutiply",new OperationMutiply());
    }

    private StrategyFactory() {

    }


    public static Strategy getStrategy(String operation){
        return map.get(operation);
    }


}
