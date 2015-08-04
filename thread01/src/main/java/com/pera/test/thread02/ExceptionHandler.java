package com.pera.test.thread02;

/**
 * Created by csq on 2015/7/30.
 */
public class ExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.printf("An exception has been captured \n");
        System.out.printf("Thread : %d \n",t.getId());
        System.out.printf("Exception :%s : %s\n",e.getClass().getName(),e.getMessage());
        System.out.printf("Stack Trace:\n");
        e.printStackTrace(System.out);
        System.out.printf("Thread status : %d \n", t.getState());
    }
}
