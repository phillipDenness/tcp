package com.tcp.mapper;

import com.tcp.model.Header;
import com.tcp.model.Market;

public class MarketMapper {

    public static Market map(String[] recordList) {

//        for (int i = 0; i < recordList.length; i++) {
//            System.out.println(recordList[i]);
//        }
        Header header = HeaderMapper.map(recordList);

        Market market = new Market();
        market.setHeader(header);
        market.setEventId(recordList[4]);
        market.setMarketId(recordList[5]);
        market.setName(recordList[6]);
        market.setDisplayed(Boolean.valueOf(recordList[7]));
        market.setDisplayed(Boolean.valueOf(recordList[8]));

        return market;
    }
}
