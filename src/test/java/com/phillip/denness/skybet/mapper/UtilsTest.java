package com.phillip.denness.skybet.mapper;

import org.junit.Test;

import java.time.Instant;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class UtilsTest {

    @Test
    public void testReturnsCorrectDate() {
        String input = "1497359166352";
        Date expectedDate = Date.from( Instant.ofEpochSecond( Long.parseLong(input)) );
        Date date = Utils.transformToDate(input);
        assertEquals(expectedDate, date);
    }

    @Test(expected = NumberFormatException.class)
    public void testThrowsNumberFormatExceptionIfStringIsIncorrect() {
        String input = "about";
        Date date = Utils.transformToDate(input);
    }
}
