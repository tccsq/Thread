package com.pera.test.thread04;

/**
 * Created by csq on 2015/8/10.
 */
public class Grouper implements Runnable {
    private Results results;

    public Grouper(Results results) {
        this.results = results;
    }

    @Override
    public void run() {
        int finalResult = 0;
        System.out.printf("Gouper: processing results ...\n");
        int data[] = results.getData();

        for(int number:data){
            finalResult += number;
        }

        System.out.printf("Gouper: Total results %d",finalResult);
    }
}
