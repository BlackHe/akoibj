package com.peony;


import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class MainTest2 {

    private static Thread t1 = null;
    private static Thread t2 = null;
    private static Thread t3 = null;

    public static void main(String[] args) throws InterruptedException {


        String from = "qwerqwesdfasdf";
        String[] split = from.split(",");
        System.out.println(split.length);


    }



}
