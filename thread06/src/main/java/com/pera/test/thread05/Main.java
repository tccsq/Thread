package com.pera.test.thread05;

/**
 * Created by csq on 2015/8/21.
 */
public class Main {
    public static void main(String args[]) throws InterruptedException {
        Thread threads[] = new Thread[3];

        for (int i = 0; i < threads.length; i++) {
            TaskLocalRandom task = new TaskLocalRandom();
            threads[i] = new Thread(task);
            threads[i].start();
        }
    }
}


