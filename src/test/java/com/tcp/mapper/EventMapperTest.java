package com.tcp.mapper;

import com.tcp.model.Event;
import org.junit.Before;
import org.junit.Test;

import java.time.Instant;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class EventMapperTest {

    private String[] eventData;

    @Before
    public void setUp() {
        this.eventData = new String[] {"2054", "create", "event", "1497359166352", "ee4d2439-e1c5-4cb7-98ad-9879b2fd84c2",
        "Football", "Sky Bet League Two", "\\|Accrington\\| vs \\|Cambridge\\|", "1497359216693", "0", "1"};
    }

    @Test
    public void mapStringValues() {
        Event event = EventMapper.map(eventData);
        assertEquals(eventData[4], event.getEventId());
        assertEquals(eventData[5], event.getCategory());
        assertEquals(eventData[6], event.getSubCategory());
        assertEquals(eventData[7], event.getName());
    }

    @Test
    public void mapDateValue() {
        Event event = EventMapper.map(eventData);
        Date expectedDate = Date.from( Instant.ofEpochSecond( Long.parseLong(eventData[8])) );
        assertEquals(event.getStartTime(), expectedDate);
    }

    @Test
    public void mapBooleanValues() {
        Event event = EventMapper.map(eventData);
        assertEquals(Boolean.valueOf(eventData[9]), event.isDisplayed());
        assertEquals(Boolean.valueOf(eventData[10]), event.isSuspended());
    }
}