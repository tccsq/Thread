package com.pera.test.thread08;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * Created by csq on 2015/9/6.
 */
public class Decrementer implements Runnable {
    private AtomicIntegerArray vector;

    public Decrementer(AtomicIntegerArray vector) {
        this.vector = vector;
    }

    @Override
    public void run() {
        for (int i = 0; i < vector.length(); i++) {
            vector.getAndDecrement(i);
        }
    }
}
