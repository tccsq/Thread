package com.pera.test.thread08;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * Created by csq on 2015/9/6.
 */
public class Main {

    public static void main(String args[]) {
        final int THREADS = 100;
        AtomicIntegerArray vector = new AtomicIntegerArray(1000);

        Incrementer incrementer = new Incrementer(vector);
        Decrementer decrementer = new Decrementer(vector);

        Thread incrementerThread[] = new Thread[THREADS];
        Thread decrementerThread[] = new Thread[THREADS];

        for (int i = 0; i < THREADS; i++) {
            incrementerThread[i] = new Thread(incrementer);
            decrementerThread[i] = new Thread(decrementer);
            incrementerThread[i].start();
            decrementerThread[i].start();
        }

        for (int i = 0; i < THREADS; i++) {
            try {
                incrementerThread[i].join();
                decrementerThread[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < vector.length(); i++) {
            if(vector.get(i) != 0){
                System.out.println("Vector ["+i+"] : "+vector.get(i));
            }
        }

        System.out.println("Main : end");
    }

}
