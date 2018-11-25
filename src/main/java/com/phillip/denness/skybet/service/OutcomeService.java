package com.phillip.denness.skybet.service;

import com.phillip.denness.skybet.model.Market;
import com.phillip.denness.skybet.model.Outcome;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OutcomeService {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private MarketService marketService;

    public Outcome save(Outcome outcome) {
        log.info(outcome.toString());
        Optional<Market> optionalMarket = marketService.getMarket(outcome.getMarketId());
        Market market = null;

        if (optionalMarket.isPresent()) {
            market = optionalMarket.get();
        } else {
            market = new Market();
            market.setMarketId(outcome.getMarketId());
            log.error("No market found for: " + outcome.getMarketId() + " - Created market placeholder. App support ticket...");
        }

        market.addOutcome(outcome);
        marketService.save(market);
        return outcome;
    }
}
