package com.pera.test.thread01;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by csq on 2015/7/30.
 */
public class DataSourceLoader implements  Runnable {
    @Override
    public void run() {
        System.out.printf("Beginning data sources loading : %s\n", new Date());

        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Data sources loading has finished: %s\n", new Date());
    }
}
