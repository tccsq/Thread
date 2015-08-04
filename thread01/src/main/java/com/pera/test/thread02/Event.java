package com.pera.test.thread02;

import java.util.Date;

/**
 * Created by csq on 2015/7/30.
 */
public class Event {
    private Date time;
    private String event;

    public Event(Date time, String event) {
        this.time = time;
        this.event = event;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
