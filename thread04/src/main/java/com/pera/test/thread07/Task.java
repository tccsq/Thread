package com.pera.test.thread07;

import java.util.concurrent.Callable;

/**
 * Created by csq on 2015/8/13.
 */
public class Task implements Callable<String> {
    private String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        int n = 1;
        while (n == 1){
            System.out.println("Task test ");
            Thread.sleep(100);
        }
        return "";
    }
}
