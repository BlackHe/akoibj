package com.peony;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.Test;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

public class JacksonTest {

    private byte[] bytes;
    final int _1M = 1024*1024;
    @Test
    public void test() throws InterruptedException {

        while (true){
            TimeUnit.SECONDS.sleep(2);
            bytes = new byte[_1M];
        }


    }

}
