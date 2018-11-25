package com.tcp.service;

import com.tcp.mapper.EventMapper;
import com.tcp.mapper.MarketMapper;
import com.tcp.mapper.OutcomeMapper;
import com.tcp.model.Event;
import com.tcp.model.Market;
import com.tcp.model.Outcome;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class TcpService {
    Logger log = LoggerFactory.getLogger(getClass());

    private MarketService marketService;
    private EventService eventService;
    private OutcomeService outcomeService;

    private String regex;

    @Autowired
    public TcpService(EventService eventService,
                      MarketService marketService,
                      OutcomeService outcomeService) {
        this.eventService = eventService;
        this.marketService = marketService;
        this.outcomeService = outcomeService;

        this.regex = "(?<!\\\\)" + Pattern.quote("|");
    }

    public void save(String record) {
        String[] recordList = splitRecord(record);

        if (isEvent(recordList)) {
            Event event = EventMapper.map(recordList);
            event = eventService.save(event);
            log.info(event.toString());
        } else if (isMarket(recordList)) {
            Market market = MarketMapper.map(recordList);
            Event event = marketService.save(market);
            log.info(event.toString());

        } else if (isOutcome(recordList)) {
            Outcome outcome = OutcomeMapper.map(recordList);
            outcomeService.save(outcome);
            log.info(outcome.toString());
        } else {
            log.error("Unable to match record: " + record +" length:" + recordList.length);
            for (int i = 0; i < recordList.length; i++) {
                log.debug(recordList[i]);
            }

        }
    }

    private String[] splitRecord(String record) {
        record = record.substring(1);
        return record.split(regex);

    }

    private boolean isMarket(String[] recordList) {
        return recordList.length == 9;
    }

    private boolean isOutcome(String[] recordList) {
        return recordList.length == 10;
    }

    private boolean isEvent(String[] recordList) {
        return recordList.length == 11;
    }
}