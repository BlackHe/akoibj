package com.peony.design;

/**
 * 集合类顶层接口
 * 集合类的抽象
 * 抽象出集合的通用的属性和行为
 * 如果出现特殊的集合，实现该顶层接口或起派生接口，改变父类行为
 */
public interface Collection<T> {

    int size = 0;

    <T> T add(T t);

    <T> T set(T origin, T current);

    <T> T remove(T target);
}
