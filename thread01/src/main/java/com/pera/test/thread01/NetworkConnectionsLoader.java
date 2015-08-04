package com.pera.test.thread01;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by csq on 2015/7/30.
 */
public class NetworkConnectionsLoader implements  Runnable {
    @Override
    public void run() {
        System.out.printf("Beginning net Connectting : %s\n", new Date());

        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("net Connectting has finished: %s\n", new Date());
    }
}
