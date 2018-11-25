package com.phillip.denness.skybet.mapper;

import com.phillip.denness.skybet.model.Header;
import com.phillip.denness.skybet.model.Outcome;

public class OutcomeMapper {

    public static Outcome map(String[] recordList) {

//        for (int i = 0; i < recordList.length; i++) {
//            System.out.println(recordList[i]);
//        }
        Header header = HeaderMapper.map(recordList);

        Outcome outcome = new Outcome();
        outcome.setHeader(header);
        outcome.setMarketId(recordList[4]);
        outcome.setOutcomeId(recordList[5]);
        outcome.setName(recordList[6]);
        outcome.setPrice(recordList[7]);

        try{
            int myInt = Integer.valueOf(recordList[8]);
            outcome.setDisplayed(myInt == 1);
        } catch (NumberFormatException e) {
            outcome.setDisplayed(Boolean.valueOf(recordList[8]));
        }

        try{
            int myInt = Integer.valueOf(recordList[9]);
            outcome.setSuspended(myInt == 1);
        } catch (NumberFormatException e) {
            outcome.setSuspended(Boolean.valueOf(recordList[9]));
        }

        return outcome;
    }
}
