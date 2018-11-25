package com.phillip.denness.skybet.service;

import com.phillip.denness.skybet.model.Event;
import com.phillip.denness.skybet.repository.EventRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class EventServiceTest {

    @Mock
    private EventRepository repository;

    @InjectMocks
    private EventService service;

    private Event testEvent;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        Event returnedEvent = new Event();
        Mockito.doReturn(returnedEvent).when(repository).save(any(Event.class));
        when(repository.findById(any())).thenReturn(Optional.of(returnedEvent));
    }

    @Test
    public void saveCallsRepository() {
        this.testEvent = new Event();

        service.save(testEvent);
        verify(repository, times(1)).save(any());
    }

    @Test
    public void getEventShouldReturnOptionalEventIfFound() {
        Optional<Event> optionalEvent = service.getEvent("2d4efc2b-a6d5-4a6b-b2ff-f7e40cf7d53b");
        verify(repository, times(1)).findById(any());
    }

    @Test
    public void getEventShouldReturnEmptyOptionalEventIfNotFound() {
        Optional<Event> optionalEvent = service.getEvent(null);
        assertFalse(optionalEvent.isPresent());
    }

    @Test
    public void getMarketShouldCallRepository() {
        Optional<List<Event>> optionalEvents = service.getMarket("2d4efc2b-a6d5-4a6b-b2ff-f7e40cf7d53b");
        verify(repository, times(1)).findByMarketListMarketId(any());
    }

    @Test
    public void getMarketShouldReturnEmptyEventIfNotFound() {
        Optional<List<Event>> optionalEvents = service.getMarket(null);
        assertFalse(optionalEvents.isPresent());
    }
}