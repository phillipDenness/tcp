package com.phillip.denness.skybet.service;

import com.phillip.denness.skybet.mapper.EventMapper;
import com.phillip.denness.skybet.mapper.MarketMapper;
import com.phillip.denness.skybet.mapper.OutcomeMapper;
import com.phillip.denness.skybet.model.Event;
import com.phillip.denness.skybet.model.Market;
import com.phillip.denness.skybet.model.Outcome;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.stream.CharacterStreamWritingMessageHandler;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.regex.Pattern;

import static java.text.MessageFormat.format;

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

        record = record.substring(1);
        String[] recordList = record.split(regex);

        if (isEvent(recordList)) {
            Event event = EventMapper.map(recordList);
            event = eventService.save(event);
//            log.info(event.toString());
        } else if (isMarket(recordList)) {
            Market market = MarketMapper.map(recordList);
            marketService.save(market);
//            log.info(market.toString());

        } else if (isOutcome(recordList)) {
            Outcome outcome = OutcomeMapper.map(recordList);
            outcomeService.save(outcome);
//            log.info(outcome.toString());
        } else {
            log.error("Unable to match record: " + record +" length:" + recordList.length);
            for (int i = 0; i < recordList.length; i++) {
                log.debug(recordList[i]);
            }

        }

//    msgIg=1527,
//    operation='update',
//    type='outcome',
//    timestamp=Sat Mar 08 05:59:45 GMT 50870},
//    marketId='b2e33130-45ad-46ca-9202-4dbc4cae8606',
//    outcomeId='3fed54fc-8a50-470e-a943-83ba14ebc467',
//    name='Draw',
//    price='5/6',
//    displayed=false,
//    suspended=false}

//    msgIg=391,
//    operation=create,
//    type='outcome',
//    timestamp=1543140387497},
//    marketId='7eba9c46-c7e8-45d5-9985-6fdec142f50e',
//    outcomeId='4e9ba197-79c8-4193-a69f-7e2178634b72',
//    name='\\|Huddersfield\\|1-0',
//    price='1/8',
//    displayed=0,
//    suspended=1}
//        391|
//                create
//                |outcome|
//                1543140387497|
//                7eba9c46-c7e8-45d5-9985-6fdec142f50e|
//                4e9ba197-79c8-4193-a69f-7e2178634b72|
//        \|Huddersfield\|
//        1-0|
//                1/8|
//                0|
//                1|
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