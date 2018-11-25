package com.phillip.denness.skybet.mapper;

import com.phillip.denness.skybet.model.Event;
import com.phillip.denness.skybet.model.Header;

public class EventMapper {

    public static Event map(String[] recordList) {

        Header header = HeaderMapper.map(recordList);

        Event event = new Event();
        event.setHeader(header);
        event.setEventId(recordList[4]);
        event.setCategory(recordList[5]);
        event.setSubCategory(recordList[6]);
        event.setName(recordList[7]);
        event.setStartTime(Utils.transformToDate(recordList[8]));
        event.setDisplayed(Boolean.valueOf(recordList[9]));
        event.setDisplayed(Boolean.valueOf(recordList[10]));

        return event;
    }

}
