package com.phillip.denness.skybet.service;

import com.phillip.denness.skybet.model.Event;
import com.phillip.denness.skybet.repository.EventRepository;
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
        return repository.findByMarketListMarketId(marketId);
    }
}
