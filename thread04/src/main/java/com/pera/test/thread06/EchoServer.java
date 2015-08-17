package com.pera.test.thread06;

/**
 * Created by csq on 2015/8/13.
 */
public class EchoServer implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("This is a echo server. The current time is " +
                System.currentTimeMillis() + ".");
    }
}