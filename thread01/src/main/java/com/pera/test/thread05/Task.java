package com.pera.test.thread05;

import java.util.Random;

/**
 * Created by csq on 2015/8/3.
 */
public class Task implements Runnable {
    @Override
    public void run() {
        int result;
        Random random = new Random(Thread.currentThread().getId());

        while (true){
            result = 1000/((int) random.nextDouble()*1000);
            System.out.printf("%s : %d \n",Thread.currentThread().getId(),result);

            if(Thread.currentThread().isInterrupted()){
                System.out.printf("%d Interrupted",Thread.currentThread().getId());
                return;
            }
        }
    }
}
