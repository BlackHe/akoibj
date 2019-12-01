package com.peony;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.Test;

import java.io.Serializable;

public class JacksonTest {

    @Test
    public void test() throws JsonProcessingException {


        ObjectMapper objectMapper = new ObjectMapper();
        KLine kLine = new KLine(10, 20);
        String s = JSONObject.toJSONString(kLine);
        System.out.println(s);

    }


    static class KLine implements Serializable {

        double highestPrice;
        double lowestPrice;

        @Override
        public String toString() {
            return "KLine{" +
                    "highestPrice=" + highestPrice +
                    ", lowestPrice=" + lowestPrice +
                    '}';
        }

        public KLine(double highestPrice, double lowestPrice) {
            this.highestPrice = highestPrice;
            this.lowestPrice = lowestPrice;


        }
    }
}
