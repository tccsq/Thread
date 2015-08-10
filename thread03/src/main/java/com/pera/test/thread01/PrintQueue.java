package com.pera.test.thread01;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by csq on 2015/8/3.
 */
public class PrintQueue {
    private final Semaphore semaphore;

    public PrintQueue() {
        this.semaphore = new Semaphore(1);
    }

    public void printJob(Object document){
        try{
            semaphore.acquire();
            Long duration = (long)(Math.random()*10000);
            System.out.println(Thread.currentThread().getName()+":PrintQueue Printing a job during "+(duration/1000)+" seconds");

            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
    }
}
