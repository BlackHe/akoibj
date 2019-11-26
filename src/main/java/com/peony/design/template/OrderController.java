package com.peony.design.template;

public class OrderController extends AbstractController {

    @Override
    public Object process(Object obj) {
        System.out.println("业务层处理中");
        return null;

    }

    @Override
    public void processBefore() {
        System.out.println("业务层处理前置");
    }

    @Override
    public void processAfter() {
        System.out.println("业务层处理后置");
    }
}
