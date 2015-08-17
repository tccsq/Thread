package com.pera.test.thread06;

import java.util.Date;

/**
 * Created by csq on 2015/8/13.
 */
public class Task implements Runnable {
    private String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("************************************");
        System.out.println("************************************");
        System.out.printf("%s: Starting at %s \n",name,new Date());
    }


}
