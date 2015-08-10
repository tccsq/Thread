package com.pera.test.thread02;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by csq on 2015/8/3.
 */
public class PrintQueue {
    private boolean freePrinters[];

    private final Semaphore semaphore;
    private Lock lockPrinters;

    public PrintQueue() {
        this.semaphore = new Semaphore(3);
        this.freePrinters = new boolean[3];

        for (int i = 0; i < freePrinters.length; i++) {
            freePrinters[i] = true;
        }
        lockPrinters = new ReentrantLock();
    }

    public void printJob(Object document) {
        try {
            semaphore.acquire();
            int assignedPrinter = getPrinter();
            Long duration = (long) (Math.random() * 10000);
            System.out.println(Thread.currentThread().getName() + ":PrintQueue Printing a job in printer " + assignedPrinter + " during " + (duration / 1000) + " seconds");

            Thread.sleep(duration);
            freePrinters[assignedPrinter] = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    public int getPrinter() {
        int ret = -1;
        try {
            lockPrinters.lock();
            for (int i = 0; i < freePrinters.length; i++) {
                if(freePrinters[i]){
                    ret = i;
                    freePrinters[i] = false;
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lockPrinters.unlock();
        }

        return ret;
    }
}
