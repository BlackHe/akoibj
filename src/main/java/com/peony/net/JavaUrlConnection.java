package com.peony.net;


import sun.net.www.protocol.http.HttpURLConnection;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class JavaUrlConnection {

    public static void main(String[] args) throws Exception {

        URL url = new URL("http://localhost:8001/product/get/2323");

        HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();

        urlConnection.setDoInput(true);

        urlConnection.setDoOutput(true);

        urlConnection.setRequestMethod("GET");

        urlConnection.connect();

        InputStream in = urlConnection.getInputStream();

        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        String line = null;

        while ((line = reader.readLine()) != null){
            System.out.println(line);
        }

    }
}
