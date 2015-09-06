package com.pera.test.thread02;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * Created by csq on 2015/8/18.
 */
public class Main {

    public static void main(String args[]) {
        Document documentMock = new Document();
        String[][] document = documentMock.generateDocument(100,1000,"the");

        DocumentTask task = new DocumentTask(document,0,100,"the");
        ForkJoinPool pool = new ForkJoinPool();
        pool.execute(task);

        do{
            System.out.printf("Main : Parallelism: %d\n",pool.getParallelism());
            System.out.printf("Main : Active Thread : %d \n",pool.getActiveThreadCount());
            System.out.printf("Main : Task Count : %d \n",pool.getQueuedTaskCount());
            System.out.printf("Main : Thread Steal : %d\n",pool.getStealCount());

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }while (!task.isDone());

        pool.shutdown();

        try {
            pool.awaitTermination(1,TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        try {
            System.out.printf("Main:The word appears %d times in the document \n",task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
