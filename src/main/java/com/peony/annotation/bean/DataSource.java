package com.peony.annotation.bean;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class DataSource {

    @Value("${mysql.url}")
    private String url;
}
