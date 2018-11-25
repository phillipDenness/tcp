package com.phillip.denness.skybet.model;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

public class Market {

    private Header header;
    private String eventId; // 4

    @Id
    private String marketId; // 5
    private String name; // 6
    private boolean displayed; // 7
    private boolean suspended; // 8
    private List<Outcome> outcomeList;

    public List<Outcome> getOutcomeList() {
        return outcomeList;
    }

    public void setOutcomeList(List<Outcome> outcomeList) {
        this.outcomeList = outcomeList;
    }

    public void addOutcome(Outcome outcome) {
        if (this.outcomeList == null) {
            setOutcomeList(new ArrayList<>());
        }
        this.outcomeList.add(outcome);
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getMarketId() {
        return marketId;
    }

    public void setMarketId(String marketId) {
        this.marketId = marketId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDisplayed() {
        return displayed;
    }

    public void setDisplayed(boolean displayed) {
        this.displayed = displayed;
    }

    public boolean isSuspended() {
        return suspended;
    }

    public void setSuspended(boolean suspended) {
        this.suspended = suspended;
    }

    @Override
    public String toString() {
        return "Market{" +
                "header=" + header +
                ", eventId='" + eventId + '\'' +
                ", marketId='" + marketId + '\'' +
                ", name='" + name + '\'' +
                ", displayed=" + displayed +
                ", suspended=" + suspended +
                '}';
    }
}
