package com.pera.test.thread01;

import java.util.List;
import java.util.concurrent.ForkJoinPool;

/**
 * Created by csq on 2015/8/18.
 */
public class Main {

    public static void main(String args[]){
        ProductListGenerator generator = new ProductListGenerator();
        List<Product> products = generator.generate(1000_0);
        Task task = new Task(products,0,products.size(),0.20);

        ForkJoinPool pool = new ForkJoinPool();
        pool.execute(task);

        do{
            System.out.printf("Main : Thread Count : %d \n",pool.getActiveThreadCount());
            System.out.printf("Main : Thread Steal : %d\n",pool.getStealCount());
            System.out.printf("Main : Parallelism: : %d\n",pool.getParallelism());
        }while (!task.isDone());

        pool.shutdown();

        if(task.isCompletedNormally()){
            System.out.println("Main : The prcess has completed normally");
        }

        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            if(product.getPrice() != 12){
                System.out.printf("Product %s : %f\n",product.getName(),product.getPrice());
            }
        }


        System.out.println("End of the program");

    }
}
