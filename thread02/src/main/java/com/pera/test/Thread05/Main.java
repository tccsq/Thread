package com.pera.test.Thread05;

import com.pera.test.thread04.Job;
import com.pera.test.thread04.PrintQueue;

/**
 * Created by csq on 2015/8/3.
 */
public class Main {
    public static void  main(String[] args){
        PriceInfo priceInfo = new PriceInfo();

        Thread[] readerThreads = new Thread[5];

        for (int i = 0; i < 5; i++) {
            readerThreads[i] = new Thread(new Reader(priceInfo),"thread"+i);
        }

        Thread wirterThread = new Thread(new Writer(priceInfo));

        for (int i = 0; i < 5; i++) {
            readerThreads[i].start();
        }

        wirterThread.start();
    }
}
