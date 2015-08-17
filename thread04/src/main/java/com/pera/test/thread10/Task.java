package com.pera.test.thread10;

import java.util.concurrent.TimeUnit;

/**
 * Created by csq on 2015/8/14.
 */
public class Task implements Runnable {
    private String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Task : " + name + "Starting ");
        try {
            Long duration = (long) (Math.random() * 10);
            System.out.printf("Task_%s : ReportGenerator:Generating a report during   %d seconds \n", this.name,duration);
            TimeUnit.MILLISECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Task : " + name + "Ending ");
    }

    @Override
    public String toString() {
        return name;
    }
}
