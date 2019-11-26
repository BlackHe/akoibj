package com.peony.design.template;

public class UT {

    public static void main(String[] args) {
        BaseController controller = new OrderController();
        controller.doDispatcher(null);
    }
}
