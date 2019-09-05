package com.peony.concurrencyinpractice;

/**
 * 延迟初始化中的竞态条件
 */
public class LazyInitRace {
    private static LazyInitRace lazyInitRace;

    private LazyInitRace(){

    };

    public static LazyInitRace getInstance(){
        // 此处的null判断，会出现竞态条件，会由于不恰当的执行时序而出现两个实例
        if (lazyInitRace == null){
            lazyInitRace = new LazyInitRace();
        }
        return lazyInitRace;
    }



}
