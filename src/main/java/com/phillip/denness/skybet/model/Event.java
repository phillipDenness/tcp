package com.phillip.denness.skybet.model;

import java.util.Date;

public class Event {

    private Header header;
    private String eventId; // 4
    private String category; // 5
    private String subCategory; // 6
    private String name; // 7
    private Date startTime; // 8
    private boolean displayed; // 9
    private boolean suspended; // 10

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
