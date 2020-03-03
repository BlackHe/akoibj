package com.peony;

/**
 * abstract class
 */
public abstract class AbstractCache {

    /**
     * abstract method can't have method body
     */
    abstract void edit();

    /**
     * usual method must be have method body
     */
    static void add() {
        final int a = 0;
    }
}
