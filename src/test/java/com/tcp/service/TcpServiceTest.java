package com.tcp.service;

import com.tcp.model.Event;
import com.tcp.model.Market;
import com.tcp.model.Outcome;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringJUnit4ClassRunner.class)
public class TcpServiceTest {

    @Mock
    private MarketService marketService;

    @Mock
    private EventService eventService;

    @Mock
    private OutcomeService outcomeService;

    @InjectMocks
    private TcpService service;

    private String eventRecord;
    private String marketRecord;
    private String outcomeRecord;

    private Outcome outcome;
    private Event event;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.eventRecord = "|2054|create|event|1497359166352|ee4d2439-e1c5-4cb7-98ad-9879b2fd84c2|Football|Sky Bet League Two|\\|Accrington\\| vs \\|Cambridge\\||1497359216693|0|1|";
        this.marketRecord = "|2054|create|market|1497359166352|ee4d2439-e1c5-4cb7-98ad-9879b2fd84c2|Football|1497359216693|0|1|";
        this.outcomeRecord = "|2054|create|market|1497359166352|ee4d2439-e1c5-4cb7-98ad-9879b2fd84c2|ee4d2439-e1c5-4cb7-98ad-9879b2fd84c2|Football|1497359216693|0|1|";

        this.outcome = new Outcome();
        outcome.setMarketId("93b89e04-8caa-4383-822b-171fb8e86a09");
        this.event = new Event();
        Market market = new Market();
        market.addOutcome(outcome);
        event.addMarket(market);
        Mockito.doReturn(event).when(eventService).save(any(Event.class));
        Mockito.doReturn(event).when(marketService).save(any(Market.class));
    }

    @Test
    public void saveShouldDetermineTypeOfRecordIfEvent() {
        service.save(eventRecord);
        verify(eventService, times(1)).save(any());
    }

    @Test
    public void saveShouldDetermineTypeOfRecordIfMarket() {
        service.save(marketRecord);
        verify(marketService, times(1)).save(any());
    }

    @Test
    public void saveShouldDetermineTypeOfRecordIfOutcome() {
        service.save(outcomeRecord);
        verify(outcomeService, times(1)).save(any());
    }
}