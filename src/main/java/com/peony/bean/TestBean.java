package com.peony.bean;

import lombok.Data;
import org.joda.time.DateTime;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Data
@Component
public class TestBean {

    private String orderCode;
    private String createTime;

    public TestBean() {
        this.orderCode = "20181226001";
        this.createTime = DateTime.now().toString();
    }
}
