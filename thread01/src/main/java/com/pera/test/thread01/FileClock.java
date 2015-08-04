package com.pera.test.thread01;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by csq on 2015/7/30.
 */
public class FileClock implements Runnable{


    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.printf("%s\n",new Date());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("the fileClock has been intrrupted");
            }
        }
    }
}
