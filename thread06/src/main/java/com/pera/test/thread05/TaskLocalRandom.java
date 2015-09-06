package com.pera.test.thread05;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by csq on 2015/9/2.
 */
public class TaskLocalRandom implements Runnable {

    public TaskLocalRandom() {
        ThreadLocalRandom.current();
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        for (int i = 0; i < 10; i++) {
            System.out.printf("%s : %d \n",name,ThreadLocalRandom.current().nextInt(10));
        }
    }
}
