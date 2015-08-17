package com.pera.test.thread08;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by csq on 2015/8/3.
 */
public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        ResultTask tasks[] = new ResultTask[5];
        for (int i = 0; i < 5; i++) {
            ExecutableTask task = new ExecutableTask("task" + i);
            tasks[i] = new ResultTask(task);
            executor.submit(task);
        }

        try {
            TimeUnit.SECONDS.sleep(7);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < tasks.length; i++) {
            boolean cancel = tasks[i].cancel(true);
            System.out.println("cancel:"+cancel);
        }

        try {
            for (int i = 0; i < tasks.length; i++) {
                if (!tasks[i].isCancelled()) {

                    System.out.printf("%s\n", tasks[i].get());

                }
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }
}
