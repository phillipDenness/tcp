package com.phillip.denness.skybet.mapper;

import com.phillip.denness.skybet.model.Header;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class HeaderMapper {

    public static Header map(String[] recordList) {

        Header header = new Header();
        header.setMsgIg(Integer.parseInt(recordList[0]));
        header.setOperation(recordList[1]);
        header.setType(recordList[2]);

        Date date = Utils.transformToDate(recordList[3]);

        header.setTimestamp(date);

        return header;
    }
}
