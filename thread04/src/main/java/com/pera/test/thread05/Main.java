package com.pera.test.thread05;



import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Created by csq on 2015/8/3.
 */
public class Main {
    public static void main(String[] args) {
        test01();
    }

    public static  void test01(){
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        System.out.printf("Main : Starting at %s \n",new Date());

        for (int i = 0; i < 5; i++) {
            Task task = new Task("task"+i);
            executor.schedule(task,i+1,TimeUnit.SECONDS);
        }

        executor.shutdown();
        try {
            executor.awaitTermination(1,TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static  void test02(){

    }
}
