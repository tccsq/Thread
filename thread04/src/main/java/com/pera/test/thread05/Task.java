package com.pera.test.thread05;

import java.util.Date;
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
        System.out.printf("%s: Starting at %s \n",name,new Date());

        return "HELLO WORLD";
    }
}
