package com.phillip.denness.skybet.model;

import java.util.Date;

public class Header {

    private Integer msgIg; // 0
    private String operation; // 1
    private String type; // 2
    private Date timestamp; // 3

    public Integer getMsgIg() {
        return msgIg;
    }

    public void setMsgIg(Integer msgIg) {
        this.msgIg = msgIg;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Header{" +
                "msgIg=" + msgIg +
                ", operation='" + operation + '\'' +
                ", type='" + type + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
