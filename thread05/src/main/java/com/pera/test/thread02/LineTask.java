package com.pera.test.thread02;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.RecursiveTask;

/**
 * Created by csq on 2015/8/18.
 */
public class LineTask  extends RecursiveTask<Integer>{
    private String line[];
    private int start;
    private int end;
    private String word;

    public LineTask(String[] line, int start, int end, String word) {
        this.line = line;
        this.start = start;
        this.end = end;
        this.word = word;
    }

    @Override
    protected Integer compute() {
        Integer result = null;
        if(start - end < 100){
            result = count(line,start,end,word);
            
        }else {
            int mid = (start + end)/2;
            LineTask task1 = new LineTask(line,start,mid+1,word);
            LineTask task2 = new LineTask(line,mid+1,end,word);
            invokeAll(task1,task2);
            try {
                result = groupResults(task1.get(),task2.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        }


        return result;
    }

    private int groupResults(int number1,int number2){
        int result;
        result = number1 + number2;
        return result;
    }

    private Integer count(String[] line, int start, int end, String word) {
        int counter = 0;
        for (int i = start; i < end; i++) {
            if(line[i].equals(word))
                counter ++ ;
        }

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return counter;
    }
}
