package com.phillip.denness.skybet.service;

import com.phillip.denness.skybet.model.Event;
import com.phillip.denness.skybet.model.Market;
import com.phillip.denness.skybet.model.Outcome;
import com.phillip.denness.skybet.repository.EventRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@RunWith(SpringJUnit4ClassRunner.class)
public class OutcomeServiceTest {

    @Captor
    private ArgumentCaptor<String> captor;

    @Mock
    private MarketService marketService;

    @InjectMocks
    private OutcomeService service;

    private Outcome outcome;
    private Event testEvent;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        this.outcome = new Outcome();
        outcome.setMarketId("93b89e04-8caa-4383-822b-171fb8e86a09");
        this.testEvent = new Event();
        Market market = new Market();
        market.addOutcome(outcome);
        testEvent.addMarket(market);
        Mockito.doReturn(testEvent).when(marketService).save(any(Market.class));
    }

    @Test
    public void saveShouldReturnFullEventObject() {
        Event event = service.save(outcome);
        assertTrue(event.getMarketList().get(0).getOutcomeList().contains(outcome));
        verify(marketService, times(1)).getMarket(captor.capture());
        assertEquals(outcome.getMarketId(), captor.getValue());
    }

    @Test
    public void saveShouldCallMarketServiceWithMarketId() {
        service.save(outcome);
        verify(marketService, times(1)).getMarket(captor.capture());
        assertEquals(outcome.getMarketId(), captor.getValue());
    }

    @Test
    public void saveShouldCallMarketServiceSave() {
        service.save(outcome);
        verify(marketService, times(1)).save(any(Market.class));
    }
}