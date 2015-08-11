package com.pera.test.thread06;

import java.util.Date;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * Created by csq on 2015/8/11.
 */
public class Student implements Runnable {
    private Phaser phaser;

    public Student(Phaser phaser) {
        this.phaser = phaser;
    }

    @Override
    public void run() {
        System.out.printf("%s : Has arrived to do the exam.%s\n", Thread.currentThread().getName(), new Date());
        phaser.arriveAndAwaitAdvance();

        System.out.printf("%s : Is going to do the first exercise.%s\n", Thread.currentThread().getName(), new Date());
        doExercise();
        System.out.printf("%s : Has done the first exercise.%s\n", Thread.currentThread().getName(), new Date());
        phaser.arriveAndAwaitAdvance();

        System.out.printf("%s : Is going to do the second exercise.%s\n", Thread.currentThread().getName(), new Date());
        doExercise();
        System.out.printf("%s : Has done the second exercise.%s\n", Thread.currentThread().getName(), new Date());
        phaser.arriveAndAwaitAdvance();

        System.out.printf("%s : Is going to do the third exercise.%s\n", Thread.currentThread().getName(), new Date());
        doExercise();
        System.out.printf("%s : Has done the third exercise.%s\n", Thread.currentThread().getName(), new Date());
        phaser.arriveAndAwaitAdvance();

    }

    private void doExercise() {
        try {
            long duration = (long)(Math.random()*10);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
