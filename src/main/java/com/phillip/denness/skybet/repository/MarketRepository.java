package com.phillip.denness.skybet.repository;

import com.phillip.denness.skybet.model.Market;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketRepository extends MongoRepository<Market, String> {

  // additional custom finder methods go here
}
    