package com.pera.test.thread10;


import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by csq on 2015/8/3.
 */
public class Main {
    public static void main(String[] args) {
        RejectedTaskController controller = new RejectedTaskController();
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();

        executor.setRejectedExecutionHandler(controller);

        System.out.println("Main : Starting ");

        for (int i = 0; i < 3; i++) {
            Task task = new Task("Task" +i);
            executor.submit(task);
        }

        System.out.println("Main: Shutting down the executor");
        executor.shutdown();


        System.out.println("Main : Sending another Task");
        Task task = new Task("RejectedTask");

        executor.submit(task);
        System.out.println("Main : end ");

    }
}
