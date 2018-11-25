package com.tcp.mapper;

import com.tcp.model.Outcome;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OutcomeMapperTest {

    private String[] outcomeData;

    @Before
    public void setUp() {
        this.outcomeData = new String[] {"2054", "create", "outcome", "1497359166352", "ee4d2439-e1c5-4cb7-98ad-9879b2fd84c2",
                "ee4d2439-e1c5-4cb7-98ad-9879b2fd84c2", "Football", "1/2", "true", "false"};
    }

    @Test
    public void mapStringValues() {
        Outcome outcome = OutcomeMapper.map(outcomeData);
        assertEquals(outcomeData[4], outcome.getMarketId());
        assertEquals(outcomeData[5], outcome.getOutcomeId());
        assertEquals(outcomeData[6], outcome.getName());
        assertEquals(outcomeData[7], outcome.getPrice());
    }

    @Test
    public void mapBooleanValues() {
        Outcome outcome = OutcomeMapper.map(outcomeData);
        assertEquals(Boolean.valueOf(outcomeData[8]), outcome.isDisplayed());
        assertEquals(Boolean.valueOf(outcomeData[9]), outcome.isSuspended());
    }
}
