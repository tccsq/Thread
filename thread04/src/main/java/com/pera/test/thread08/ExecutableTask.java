package com.pera.test.thread08;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by csq on 2015/8/14.
 */
public class ExecutableTask implements Callable<String> {
    private String name;

    public ExecutableTask(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String call() throws Exception {
        System.out.printf("%s: Starting \n",name);
        try {
            Long duration = (long)(Math.random()*10);
            System.out.printf("%s : waiting  %d seconds for results\n",this.name,duration);
            TimeUnit.MILLISECONDS.sleep(duration);
        } catch (InterruptedException e) {
//            e.printStackTrace();
        }
        System.out.println(name+"******");
        return "Hello World,I am "+name;
    }
}
