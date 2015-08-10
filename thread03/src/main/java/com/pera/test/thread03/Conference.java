package com.pera.test.thread03;

import java.util.concurrent.CountDownLatch;

/**
 * Created by csq on 2015/8/10.
 */
public class Conference implements Runnable {
    private final CountDownLatch controller;

    public Conference(int num) {
        this.controller = new CountDownLatch(num);
    }

    public void arrive(String name){
        System.out.printf("%s has arrived \n",name);
        controller.countDown();

        System.out.printf("VideoConference : waiting for %d \n",controller.getCount());

    }

    @Override
    public void run() {
        System.out.printf("VideoConference : Initealization :%d \n",controller.getCount());
        try {
            controller.await();
            System.out.printf("VideoConference : All participants have come \n");
            System.out.printf("VideoConference : Let us start \n");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
