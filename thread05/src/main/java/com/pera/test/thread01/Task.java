package com.pera.test.thread01;

import java.util.List;
import java.util.concurrent.RecursiveAction;

/**
 * Created by csq on 2015/8/17.
 */
public class Task extends RecursiveAction {
    private static final long serialVersionUID = 5232453952276485070L;
    private List<Product> products;
    private int first;
    private int last;
    private double increment;

    public Task(List<Product> products, int first, int last, double increment) {
        this.products = products;
        this.first = first;
        this.last = last;
        this.increment = increment;
    }

    @Override
    protected void compute() {
        if(last - first < 10){
            updatePrices();
        }else {
            int middle =(first+last)/2;
            System.out.printf("Task : Pending tasks:%d\n",getQueuedTaskCount());
            Task task1 = new Task(products,first,middle+1,increment);
            Task task2 = new Task(products,middle+1,last,increment);
            invokeAll(task1,task2);
        }
    }

    private void updatePrices() {
        for (int i = first; i < last; i++) {
            Product product = products.get(i);
            product.setPrice(product.getPrice()*(1+increment));
        }
    }
}
