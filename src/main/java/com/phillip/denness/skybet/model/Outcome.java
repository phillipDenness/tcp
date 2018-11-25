package com.phillip.denness.skybet.model;

import org.springframework.data.annotation.Id;

public class Outcome {

    private Header header;
    private String marketId; // 4

    @Id
    private String outcomeId; // 5
    private String name; // 6
    private String price; // 7
    private boolean displayed; // 8
    private boolean suspended; // 9

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public String getMarketId() {
        return marketId;
    }

    public void setMarketId(String marketId) {
        this.marketId = marketId;
    }

    public String getOutcomeId() {
        return outcomeId;
    }

    public void setOutcomeId(String outcomeId) {
        this.outcomeId = outcomeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
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
        return "Outcome{" +
                "header=" + header +
                ", marketId='" + marketId + '\'' +
                ", outcomeId='" + outcomeId + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", displayed=" + displayed +
                ", suspended=" + suspended +
                '}';
    }
}
