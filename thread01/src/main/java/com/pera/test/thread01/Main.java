package com.pera.test.thread01;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

/**
 * Created by csq on 2015/7/28.
 */
public class Main {

    public static void main(String args[]){
        test06();
    }


    private static void test01(){
        for (int i = 1; i <=10 ; i++) {
            Calculator cal = new Calculator(i);
            Thread thread = new Thread(cal);
            thread.start();
        }
    }

    private static void test02(){
        Thread[] threads = new Thread[10];
        Thread.State[] states = new Thread.State[10];

        for (int i = 0; i <10 ; i++) {
            threads[i] = new Thread(new Calculator(i));
            if(i%2 == 0){
                threads[i].setPriority(Thread.MAX_PRIORITY);
            }else{
                threads[i].setPriority(Thread.MIN_PRIORITY);
            }
        }

        try(
            FileWriter fw = new FileWriter(".\\log.txt");
            PrintWriter pw = new PrintWriter(fw);
        ){
            for (int i = 0; i < 10 ; i++) {
                pw.println("Main :Status of thread " + i + ":"+threads[i].getState());
                states[i] = threads[i].getState();
            }

            //开始执行10个线程
            for (int i = 0; i < 10 ; i++) {
                threads[i].start();
            }
            //十个线程执行完成后查看状态
            boolean finish = false;
            while(!finish){
                for (int i = 0; i < 10 ; i++) {
                    if(threads[i].getState() != states[i]){
                        writeThreadInfo(pw,threads[i],states[i]);
                        states[i] = threads[i].getState();
                    }
                }
                finish =true;

                for (int i = 0; i < 10 ; i++) {
                    finish = finish && (threads[i] .getState() == Thread.State.TERMINATED);
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void writeThreadInfo(PrintWriter pw, Thread thread, Thread.State state) {
        pw.printf("Main : Id %d - %s\n",thread.getId(),thread.getName());
        pw.printf("Main : Priority %d\n",thread.getPriority());
        pw.printf("Main : Old State: %s\n",state);
        pw.printf("Main : New State: %s\n",thread.getState());
        pw.printf("****************************\n");
    }

    /**
     * 线程中断
     */
    private static void test03(){
        Thread task = new PrimeGenerator();
        task.start();

        try {
            Thread.sleep(5000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        task.interrupt();
    }

    /**
     * 通过异常，控制线程中断
     */
    private static void test04(){
        FileSearch fs = new FileSearch("d:\\","startup.bat");
        Thread thread = new Thread(fs);
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }

    /**
     * 线程的休眠和恢复
     */
    private static void test05(){
        FileClock fc = new FileClock();
        Thread thread = new Thread(fc);
        thread.start();


        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }

    /**
     * 等待线程终止
     */
    private static void test06(){
        DataSourceLoader dataSourceLoader = new DataSourceLoader();
        Thread thread1 = new Thread(dataSourceLoader,"dataSourceThread");

        NetworkConnectionsLoader networkConnectionsLoader = new NetworkConnectionsLoader();
        Thread thread2 = new Thread(networkConnectionsLoader,"networkConnectThread");

        thread1.start();
        thread2.start();


        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main: ended");
    }
}
