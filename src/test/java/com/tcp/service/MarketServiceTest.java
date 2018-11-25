package com.tcp.service;

import com.tcp.model.Event;
import com.tcp.model.Market;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringJUnit4ClassRunner.class)
public class MarketServiceTest {

    @Captor
    private ArgumentCaptor<String> captor;

    @Mock
    private EventService eventService;

    @InjectMocks
    private MarketService service;

    private Market market;
    private Event testEvent;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        this.market = new Market();
        market.setEventId("93b89e04-8caa-4383-822b-171fb8e86a09");
        market.setMarketId("bde7737e-3cef-49e7-b828-065d8eaa086b");

        this.testEvent = new Event();
        testEvent.setEventId(market.getEventId());
        testEvent.addMarket(market);
        List<Event> eventList = new ArrayList();
        eventList.add(testEvent);

        Mockito.doReturn(Optional.of(eventList)).when(eventService).getMarket(any(String.class));
        Mockito.doReturn(Optional.of(testEvent)).when(eventService).getEvent(any(String.class));
        Mockito.doReturn(testEvent).when(eventService).save(any(Event.class));
    }


    @Test
    public void saveShouldCallEventServiceGetEventWithEventId() {
        service.save(market);
        verify(eventService, times(1)).getEvent(captor.capture());
        assertEquals(market.getEventId(), captor.getValue());
    }

    @Test
    public void saveShouldAddMarketToEventIfFound() {
        Mockito.doReturn(Optional.empty()).when(eventService).getEvent(any(String.class));
        Event event = service.save(market);
        verify(eventService, times(1)).getEvent(captor.capture());
        assertEquals(market.getEventId(), captor.getValue());
    }

    @Test
    public void getMarketCallsEventServiceToGetEventDocumentWithMarket() {
        service.getMarket(market.getMarketId());
        verify(eventService, times(1)).getMarket(captor.capture());
        assertEquals(market.getMarketId(), captor.getValue());
    }
}