package com.pera.test.thread06;


import com.pera.test.thread05.FileSearch;

import java.util.concurrent.Phaser;

/**
 * Created by csq on 2015/8/3.
 */
public class Main {
    public static void main(String[] args) {
        MyPhaser phaser = new MyPhaser();
        Student students[] = new Student[5];

        for (int i = 0; i < students.length; i++) {
            students[i] = new Student(phaser);
            phaser.register();
        }

        Thread threads[] = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(students[i],"Student"+i);
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Terminated:"+phaser.isTerminated());

    }
}
