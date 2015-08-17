package com.pera.test.thread04;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by csq on 2015/8/13.
 */
public class Task implements Callable<Result> {
    private String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public Result call() throws Exception {
        System.out.printf("%s: Starting \n",name);
        try {
            Long duration = (long)(Math.random()*10);
            System.out.printf("%s : waiting  %d seconds for results\n",this.name,duration);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int value = 0;
        for (int i = 0; i < 5; i++) {
            value +=(int)(Math.random()*100);
        }

        System.out.printf("%s : Ends \n",this.name);
        return new Result(name,value);
    }
}
