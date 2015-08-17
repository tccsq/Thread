package com.pera.test.thread09;


import java.util.concurrent.*;

/**
 * Created by csq on 2015/8/3.
 */
public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        CompletionService<String> service = new ExecutorCompletionService<String>(executor);

        ReportRequest faceReportRequest = new ReportRequest("face",service);
        ReportRequest onlineReportRequest = new ReportRequest("Online",service);

        Thread faceThread = new Thread(faceReportRequest);
        Thread onlineThread = new Thread(onlineReportRequest);

        ReportProcessor reportProcessor = new ReportProcessor(service);
        Thread senderThread = new Thread(reportProcessor);

        System.out.println("Main : Starting the Thread ");

        faceThread.start();
        onlineThread.start();
        senderThread.start();


        try {
            System.out.println("Main: Waiting for the report generators");
            faceThread.join();
            onlineThread.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("Main: Shutting down the executor");

        executor.shutdown();

        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        reportProcessor.setEnd(true);
        System.out.println("Main: ends");

    }
}
