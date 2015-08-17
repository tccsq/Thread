package com.pera.test.thread09;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by csq on 2015/8/14.
 */
public class ReportGenerator implements Callable<String> {
    private String sender;
    private String title;

    public ReportGenerator(String sender, String title) {
        this.sender = sender;
        this.title = title;
    }

    @Override
    public String call() throws Exception{
        System.out.printf("%s: Starting \n", title);
        try {
            Long duration = (long)(Math.random()*10);
            System.out.printf("%s_%s : ReportGenerator:Generating a report during   %d seconds \n",this.sender,this.title,duration);
            TimeUnit.MILLISECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String ret = sender+":"+title;
        return ret;
    }
}
