package com.peony.java8.datetime;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class DatetimeUtils {

    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate now = LocalDate.now();
        Period period = Period.between(now, LocalDate.of(2019, 1, 1));
        System.out.println(now.plusDays(10).format(dtf));
        String nowStr = now.format(dtf);
        String format = dtf.format(now);
        System.out.println(format);
        System.out.println(nowStr);
    }
}
