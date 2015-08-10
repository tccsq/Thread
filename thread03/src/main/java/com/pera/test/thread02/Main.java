package com.pera.test.thread02;



/**
 * Created by csq on 2015/8/3.
 */
public class Main {
    public static void main(String[] args) {
        PrintQueue printQueue = new PrintQueue();

        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Job(printQueue), "thread" + i);
        }

        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }

    }
}
