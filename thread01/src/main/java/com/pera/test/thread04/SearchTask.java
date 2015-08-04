package com.pera.test.thread04;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by csq on 2015/7/31.
 */
public class SearchTask implements Runnable {
    private Result result;

    public SearchTask(Result result){
        this.result = result;
    }


    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.printf("Thread %s : Start\n",name);
        try {
            doTask();
            result.setName(name);
        }catch (InterruptedException e){
            System.out.printf("Thread %s : Interrupted\n",name);
            return;
        }
        System.out.printf("Thread %s : End\n",name);
    }

    private void doTask() throws  InterruptedException{
        Random random = new Random(new Date().getTime());
        int value = (int)(random.nextDouble()*100);
        TimeUnit.SECONDS.sleep(value);
        System.out.printf("Thread %s : %d\n",Thread.currentThread().getName(),value);
    }
}
