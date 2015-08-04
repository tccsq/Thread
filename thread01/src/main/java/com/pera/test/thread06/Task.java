package com.pera.test.thread06;

import java.util.concurrent.TimeUnit;

/**
 * Created by csq on 2015/8/3.
 */
public class Task implements Runnable {

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
