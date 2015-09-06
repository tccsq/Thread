package com.pera.test.thread03;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * Created by csq on 2015/8/18.
 */
public class Main {

    public static void main(String args[]) {
        ForkJoinPool pool = new ForkJoinPool();
        FolderProcessor system = new FolderProcessor("C:\\Windows","log");
        FolderProcessor app = new FolderProcessor("C:\\Program Files","log");
        FolderProcessor documents = new FolderProcessor("C:\\ProgramData","log");

        pool.execute(system);
        pool.execute(app);
        pool.execute(documents);

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

        }while ((!system.isDone()) || (!app.isDone()) || (!documents.isDone()));

        pool.shutdown();

        List<String> results;

        results = system.join();
        System.out.printf("System : %d files found\n", results.size());
        results = app.join();
        System.out.printf("App : %d files found\n",results.size());
        results = documents.join();
        System.out.printf("Document : %d files found\n",results.size());

    }
}
