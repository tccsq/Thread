package com.pera.test.thread03;

import java.util.concurrent.TimeUnit;

/**
 * Created by csq on 2015/8/10.
 */
public class Participant implements Runnable {
    private Conference conference;
    private String name;

    public Participant(Conference conference, String name) {
        this.conference = conference;
        this.name = name;
    }

    @Override
    public void run() {
        long duration = (long)(Math.random()*10);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        conference.arrive(name);
    }
}
