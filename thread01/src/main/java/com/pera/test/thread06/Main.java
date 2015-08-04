package com.pera.test.thread06;

import com.pera.test.thread02.*;

/**
 * Created by csq on 2015/7/31.
 */
public class Main {

    public static void main(String[] args) {
        test01();
    }

    private static void test01() {
        MyThreadFactory factory = new MyThreadFactory("my_thread_factory");
        Task task = new Task();
        Thread thread ;
        System.out.println("Starting the thread..");
        for (int i = 0; i < 10; i++) {
            thread = factory.newThread(task);
            thread.start();
        }

        System.out.println("factory states:");
        System.out.printf("%s \n",factory.getStats());
    }


}
