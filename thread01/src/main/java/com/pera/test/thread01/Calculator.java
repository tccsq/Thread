package com.pera.test.thread01;

/**
 * Created by csq on 2015/7/28.
 * 线程创建
 */
public class Calculator implements Runnable{
    private int number;

    public Calculator(int number){
        this.number = number;
    }

    public void run() {
        for (int i = 1; i <= 10 ; i++) {
            System.out.printf("%s : %d * %d = %d\n",Thread.currentThread().getName(),number,i,i*number);
        }
    }


}
