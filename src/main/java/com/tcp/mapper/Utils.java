package com.tcp.mapper;

import java.time.Instant;
import java.util.Date;

public class Utils {
    public static Date transformToDate(String dateLong) throws NumberFormatException{
        return Date.from( Instant.ofEpochSecond( Long.parseLong(dateLong)) );
    }
}
