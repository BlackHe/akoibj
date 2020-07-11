package com.peony.bean;

import lombok.Data;
import org.joda.time.DateTime;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Data
@Component
public class TestBean {

    public String orderCode;
    private String createTime;

    public TestBean() {
        this.orderCode = "20181226001";
        this.createTime = DateTime.now().toString();
    }
}
