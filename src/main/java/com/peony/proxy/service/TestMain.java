package com.peony.proxy.service;


import java.math.BigDecimal;

public class TestMain {

    public static void main(String[] args) {
        HelloService service = (HelloService)BeanFactory.getInstance().getBean(HelloService.class);

        OrderVO orderVO = new OrderVO();
        orderVO.setAmount(new BigDecimal("88.9"));
        orderVO.setId("O01010");

        System.out.println("请求参数 "+ orderVO);
        OrderVO order = service.createOrder(orderVO);
        System.out.println("返回值 "+order);

    }
}
