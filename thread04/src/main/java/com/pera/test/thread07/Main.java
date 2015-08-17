package com.pera.test.thread07;


import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by csq on 2015/8/3.
 */
public class Main {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        Task task = new Task("task");

        System.out.println("Main:execute the task");
        Future<String> future = executor.submit(task);

        try {
            TimeUnit.SECONDS.sleep(2);

            System.out.println("Main:canceling thre task");
            future.cancel(true);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main:the task canceled"+future.isCancelled());
        System.out.println("Main:the task done:"+future.isDone());

        executor.shutdown();

    }
}
