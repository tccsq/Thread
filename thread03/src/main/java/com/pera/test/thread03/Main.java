package com.pera.test.thread03;


import com.pera.test.thread02.Job;
import com.pera.test.thread02.PrintQueue;

/**
 * Created by csq on 2015/8/3.
 */
public class Main {
    public static void main(String[] args) {
        Conference conference = new Conference(10);
        Thread conferenceThread = new Thread(conference);
        conferenceThread.start();

        for (int i = 0; i < 10; i++) {
            Participant p = new Participant(conference,"Participant"+i);
            Thread t = new Thread(p);
            t.start();
        }
    }
}
