package com.peony;

import com.peony.cleancode.EnumQuestion;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.Test;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.TreeMap;


public class HttpDemo {

    @Test
    public void httpTest()throws Exception{
        TreeMap<String, String> sortMap = new TreeMap<>();
        sortMap.put("1timestamp",System.currentTimeMillis()+"");
        sortMap.put("5nonce","abc");
        sortMap.put("2nonce","abc");
        System.out.println(sortMap);
        final Mac hmacSHA256 = Mac.getInstance("HmacSHA256");
        String key = "";
        String data = "";
        final SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");
        hmacSHA256.init(secretKeySpec);
        final byte[] bytes = hmacSHA256.doFinal(data.getBytes("UTF-8"));
        final StringBuilder sb = new StringBuilder();
        for (byte b : bytes){
            sb.append(Integer.toHexString((b & 0xFF) | 0X100)).substring(1,3);
        }
        EnumQuestion.ONE.rate();
        return;

    }
}
