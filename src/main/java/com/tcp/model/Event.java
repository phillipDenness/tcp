package com.tcp.model;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Event {

    private Header header;

    @Id
    private String eventId; // 4
    private String category; // 5
    private String subCategory; // 6
    private String name; // 7
    private Date startTime; // 8
    private boolean displayed; // 9
    private boolean suspended; // 10
    private List<Market> marketList;

    public List<Market> getMarketList() {
        return marketList;
    }

    public void setMarketList(List<Market> marketList) {
        this.marketList = marketList;
    }

    public void addMarket(Market market) {
        if (this.marketList == null) {
            setMarketList(new ArrayList<>());
        }
        this.marketList.add(market);
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
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
        return "Event{" +
                "header=" + header +
                ", eventId='" + eventId + '\'' +
                ", category='" + category + '\'' +
                ", subCategory='" + subCategory + '\'' +
                ", name='" + name + '\'' +
                ", startTime=" + startTime +
                ", displayed=" + displayed +
                ", suspended=" + suspended +
                '}';
    }
}
