package com.peony.java8.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class DatetimeUtils {

    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDate.now(ZoneId.of("UTC")).atTime(0, 0, 0);
        System.out.println(localDateTime);
        long l = localDateTime.toInstant(ZoneOffset.UTC).toEpochMilli();
        System.out.println(l);
//        Period period = Period.between(now, LocalDate.of(2019, 1, 1));
//        System.out.println(now.plusDays(10).format(dtf));
//        String nowStr = now.format(dtf);
//        String format = dtf.format(now);
//        System.out.println(format);
//        System.out.println(nowStr);
        System.out.println(1 * 24 * 60 * 60 * 1000);
    }
}
