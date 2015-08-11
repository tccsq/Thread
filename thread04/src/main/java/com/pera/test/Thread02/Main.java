package com.pera.test.Thread02;


import com.pera.test.thread01.Server;
import com.pera.test.thread01.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by csq on 2015/8/3.
 */
public class Main {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        List<Future<Integer>> resultList = new ArrayList<>();

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            Integer num = random.nextInt(10);
            FactorialCalculator calculator = new FactorialCalculator(num);

            Future<Integer> result = executor.submit(calculator);

            resultList.add(result);
        }

        do{
            System.out.printf("Main: Number of completed tasks : %d \n",executor.getCompletedTaskCount());

            for (int i = 0; i < resultList.size(); i++) {
                Future<Integer> result = resultList.get(i);
                System.out.printf("Main: Task %d : %s\n",i,result.isDone());
            }

            try{
                TimeUnit.SECONDS.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }while (executor.getCompletedTaskCount() < resultList.size());

        System.out.printf("Main: Results\n");

        for (int i = 0; i < resultList.size(); i++) {
            Future<Integer> result = resultList.get(i);
            Integer number = null;

            try {
                number = result.get();

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            System.out.printf("Main: Task %d : %d\n",i,number);
        }

        executor.shutdown();

    }
}
