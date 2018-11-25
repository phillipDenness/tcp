package com.tcp.mapper;

import com.tcp.model.Market;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MarketMapperTest {

    private String[] marketData;

    @Before
    public void setUp() {
        this.marketData = new String[] {"2054", "create", "market", "1497359166352", "ee4d2439-e1c5-4cb7-98ad-9879b2fd84c2",
                "ee4d2439-e1c5-4cb7-98ad-9879b2fd84c2", "Football", "0", "1"};
    }

    @Test
    public void mapStringValues() {
        Market market = MarketMapper.map(marketData);
        assertEquals(marketData[4], market.getEventId());
        assertEquals(marketData[5], market.getMarketId());
        assertEquals(marketData[6], market.getName());
    }

    @Test
    public void mapBooleanValues() {
        Market market = MarketMapper.map(marketData);
        assertEquals(Boolean.valueOf(marketData[7]), market.isDisplayed());
        assertEquals(Boolean.valueOf(marketData[8]), market.isSuspended());
    }
}