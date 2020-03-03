package com.peony.time.zone;

import java.time.LocalTime;

public class TimeZoneTest {

    public static void main(String[] args) {
        // 本机时区为UTC+8  10:25:19.846
        LocalTime now = LocalTime.now();
        System.out.println(now);

        // 更改本机时区为UTC
        LocalTime nowUtc = LocalTime.now();
        System.out.println(nowUtc);
    }

}
