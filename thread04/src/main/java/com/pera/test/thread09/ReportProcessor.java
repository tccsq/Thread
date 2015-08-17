package com.pera.test.thread09;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by csq on 2015/8/14.
 */
public class ReportProcessor implements Runnable {
    private CompletionService<String> service;
    private boolean end;

    public ReportProcessor(CompletionService<String> service) {
        this.service = service;
        this.end = false;
    }

    @Override
    public void run() {
        while (!end){
            try {
                Future<String> result = service.poll(20, TimeUnit.SECONDS);
                if(result != null){
                    String report = result.get();
                    System.out.printf("ReportReceiver : Report Received:%s \n",report);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("ReportSender: end \n");
    }

    public void setEnd(boolean end) {
        this.end = end;
    }
}
