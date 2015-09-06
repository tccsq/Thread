package com.pera.test.thread03;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by csq on 2015/8/21.
 */
public class Main {
    public static void main(String args[]) throws InterruptedException {
        PriorityBlockingQueue<Event> queue = new PriorityBlockingQueue<>();
        Thread taskThreads[] = new Thread[5];
        for (int i = 0; i < taskThreads.length; i++) {
            Task task = new Task(i, queue);
            taskThreads[i] = new Thread(task);
        }


        for (int i = 0; i < taskThreads.length; i++) {
            taskThreads[i].start();
        }

        for (int i = 0; i < taskThreads.length; i++) {
            taskThreads[i].join();
        }

        System.out.printf("Main: Queue Size: %d\n", queue.size());
        for (int i = 0; i < taskThreads.length * 1000; i++) {
            Event event = queue.poll();
            System.out.printf("Thread %s: Priority %d\n", event.
                    getThread(), event.getPrority());
        }

        System.out.printf("Main: Queue Size: %d\n", queue.size());
        System.out.printf("Main: End of the program\n");


    }
}
