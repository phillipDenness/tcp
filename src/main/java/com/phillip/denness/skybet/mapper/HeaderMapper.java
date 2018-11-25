package com.phillip.denness.skybet.mapper;

import com.phillip.denness.skybet.model.Header;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class HeaderMapper {


    public static Header map(String[] recordList) {

        Logger log = LoggerFactory.getLogger(HeaderMapper.class);

        Header header = new Header();
        header.setMsgIg(Integer.parseInt(recordList[0]));
        header.setOperation(recordList[1]);
        header.setType(recordList[2]);

        Date date = null;
        try {
            date = Utils.transformToDate(recordList[3]);
        }catch (NumberFormatException e) {
            log.error("Unable to transform to date");
        }

        header.setTimestamp(date);

        return header;
    }
}
