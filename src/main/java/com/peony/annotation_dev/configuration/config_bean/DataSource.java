package com.peony.annotation_dev.configuration.config_bean;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
public class DataSource {

    @Value("${mysql.url}")
    private String url;
}
