package com.peony.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Report {

    @Autowired
    private Order order;

    public void setOrder() {
        order.setReport(new Report());
    }
}
