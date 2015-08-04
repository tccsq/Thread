package com.pera.test.thread03;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by csq on 2015/7/30.
 */
public class UnsafeTask implements Runnable {
    private Date startDate;
    @Override
    public void run() {
        startDate = new Date();
        System.out.printf("Starting Thread : %s :%s\n", Thread.currentThread().getId(),startDate);

        try {
            TimeUnit.SECONDS.sleep((int)Math.rint(Math.random()*10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Thread finished : %s :%s\n", Thread.currentThread().getId(),startDate);

    }
}
