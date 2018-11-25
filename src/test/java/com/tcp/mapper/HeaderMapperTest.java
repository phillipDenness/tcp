package com.tcp.mapper;

import com.tcp.model.Header;
import org.junit.Before;
import org.junit.Test;

import java.time.Instant;
import java.util.Date;

import static org.junit.Assert.*;

public class HeaderMapperTest {
    private String[] headerData;

    @Before
    public void setUp() {
        this.headerData = new String[] {"2054", "create", "market", "1497359166352"};
    }

    @Test
    public void mapStringValues() {
        Header header = HeaderMapper.map(headerData);
        assertEquals( java.util.Optional.ofNullable(Integer.parseInt(headerData[0])).get(), header.getMsgIg());
        assertEquals(headerData[1], header.getOperation());
        assertEquals(headerData[2], header.getType());
    }

    @Test
    public void mapDateValue() {
        Header header = HeaderMapper.map(headerData);
        Date expectedDate = Date.from( Instant.ofEpochSecond( Long.parseLong(headerData[3])) );
        assertEquals(expectedDate, header.getTimestamp());
    }

}