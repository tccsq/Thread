package com.pera.test.Thread03;

import com.pera.test.thread02.Cinema;
import com.pera.test.thread02.TicketOffice1;
import com.pera.test.thread02.TicketOffice2;

/**
 * Created by csq on 2015/8/3.
 */
public class Main {
    public static void  main(String[] args){
        EventStorage eventStorage = new EventStorage();
        Producer producer = new Producer(eventStorage);
        Consumer consumer = new Consumer(eventStorage);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();

    }
}
