package com.pera.test.thread02;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by csq on 2015/7/30.
 */
public class Main {

    public static void main(String[] args) {
        test02();
    }

    private static void test01(){
        Deque<Event> deque = new ArrayDeque<>();
        WriterTask writerTask = new WriterTask(deque);

        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(writerTask);
            thread.start();
        }
        CleanerTask ct = new CleanerTask(deque);
        ct.start();
    }

    private static void test02(){
        Task task = new Task();
        Thread thread = new Thread(task);
        thread.setUncaughtExceptionHandler(new ExceptionHandler());
        thread.start();
    }
}
