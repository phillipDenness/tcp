package com.tcp.service;

import com.tcp.model.Event;
import com.tcp.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository repository;

    public Event save(Event event) {
        return repository.save(event);
    }

    public Optional<Event> getEvent(String id) {
        if (id == null) {
            return Optional.empty();
        }
        return repository.findById(id);
    }

    public Optional<List<Event>> getMarket(String marketId) {
        if (marketId == null) {
            return Optional.empty();
        }
        return repository.findByMarketListMarketId(marketId);
    }
}
