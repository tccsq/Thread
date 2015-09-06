package com.pera.test.thread01;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by csq on 2015/8/21.
 */
public class Main {
    public static void main(String args[]) {
        ConcurrentLinkedDeque<String> list = new ConcurrentLinkedDeque<>();
        Thread threads[] = new Thread[100];

        for (int i = 0; i < threads.length; i++) {
            AddTask task = new AddTask(list);
            threads[i] = new Thread(task);
            threads[i].start();
        }

        System.out.printf("Main: %d AddTask threads have been launched\n",threads.length);

        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("Main: Size of the List: %d\n", list.size());

        for (int i = 0; i < threads.length; i++) {
            PollTask task = new PollTask(list);
            threads[i] = new Thread(task);
            threads[i].start();
        }

        System.out.printf("Main: %d PollTask threads have been launched\n",threads.length);
        //阻塞式集合？要等待线程执行完成才能调用size方法
        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("Main: Size of the List: %d\n", list.size());
    }
}
