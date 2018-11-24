package com.phillip.denness.skybet.mapper;

import java.time.Instant;
import java.util.Date;

public class Utils {
    public static Date transformToDate(String dateLong) {
        return Date.from( Instant.ofEpochSecond( Long.parseLong(dateLong)) );
    }
}
