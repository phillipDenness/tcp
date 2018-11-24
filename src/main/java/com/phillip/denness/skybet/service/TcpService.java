package com.phillip.denness.skybet.service;

import com.phillip.denness.skybet.mapper.EventMapper;
import com.phillip.denness.skybet.mapper.MarketMapper;
import com.phillip.denness.skybet.mapper.OutcomeMapper;
import com.phillip.denness.skybet.model.Event;
import com.phillip.denness.skybet.model.Market;
import com.phillip.denness.skybet.model.Outcome;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.stream.CharacterStreamWritingMessageHandler;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

import static java.text.MessageFormat.format;

@Service
public class TcpService {

    Logger log = LoggerFactory.getLogger(getClass());

    public void save(String record) {

        record = record.substring(1);
        String[] recordList = record.split("\\|");

        if (isEvent(recordList)) {
            Event event = EventMapper.map(recordList);
            log.info(event.toString());
        } else if (isMarket(recordList)) {
            Market market = MarketMapper.map(recordList);
            log.info(market.toString());

        } else if (isOutcome(recordList)) {
            Outcome outcome = OutcomeMapper.map(recordList);
            log.info(outcome.toString());
        }

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