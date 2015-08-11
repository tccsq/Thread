package com.pera.test.thread01;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by csq on 2015/8/11.
 */
public class Server {
    private ThreadPoolExecutor executor;

    public Server() {
        //this.executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        this.executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
    }

    public void executeTask(Task task){
        System.out.printf("Server: A new task has arrived\n");
        executor.execute(task);
        System.out.printf("Server: Task count: %d \n", executor.getTaskCount());
        System.out.printf("Server: Pool size: %d \n", executor.getPoolSize());
        System.out.printf("Server: Active count: %d \n",executor.getActiveCount());
        System.out.printf("Server: Compeleted task : %d \n",executor.getCompletedTaskCount());
    }

    public void endServer(){
        executor.shutdown();
    }
}
