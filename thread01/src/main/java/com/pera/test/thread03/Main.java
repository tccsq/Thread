package com.pera.test.thread03;

import java.util.concurrent.TimeUnit;

/**
 * Created by csq on 2015/7/30.
 */
public class Main {
    public static void main(String[] args) {
        test02();
    }

    private static void test01() {
        UnsafeTask task = new UnsafeTask();
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(task);
            thread.start();

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    private static void test02() {
        SafeTask task = new SafeTask();

        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(task);
            thread.start();

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
