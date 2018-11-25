package com.phillip.denness.skybet.service;

import com.phillip.denness.skybet.model.Event;
import com.phillip.denness.skybet.model.Market;
import com.phillip.denness.skybet.repository.MarketRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MarketService {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private MarketRepository repository;

    @Autowired
    private EventService eventService;

    public Market save(Market market) {
        Optional<Event> optionalEvent = eventService.getEvent(market.getEventId());
        Event event = null;
        if (optionalEvent.isPresent()) {
            event = optionalEvent.get();
        } else {
            event = new Event();
            event.setEventId(market.getEventId());
            log.error("No event found for: " + market.getEventId() + " - Created event placeholder. App support ticket...");
        }
        event.addMarket(market);
        eventService.save(event);
        return market;
    }

    public Optional<Market> getMarket(String id) {
        Optional<List<Event>> optionalEvent = eventService.getMarket(id);
        if (optionalEvent.isPresent()) {
            if (!optionalEvent.get().isEmpty()) {
                return optionalEvent.get().get(0).getMarketList()
                        .stream()
                        .filter(market -> market.getMarketId().equals(id))
                        .findFirst();
            }
        }
        return Optional.empty();
    }
}