package com.tcp.repository;

import com.tcp.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends MongoRepository<Event, String> {

    Optional<List<Event>> findByMarketListMarketId(String marketId);

    // additional custom finder methods go here
}
    