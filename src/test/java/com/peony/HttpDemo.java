package com.peony;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.Test;


public class HttpDemo {

    @Test
    public void httpTest()throws Exception{
        String url = "https://www.xhqb.com/auth/user/register";
        System.out.println(url);
        OkHttpClient httpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = httpClient.newCall(request).execute()) {
            String string = response.body().string();
            System.out.println(string);
        }

    }
}
