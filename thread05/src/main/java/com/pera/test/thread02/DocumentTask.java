package com.pera.test.thread02;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RecursiveTask;

/**
 * Created by csq on 2015/8/18.
 */
public class DocumentTask extends RecursiveTask<Integer> {
    private String document[][];
    private int start;
    private int end;
    private String word;

    public DocumentTask(String[][] document, int start, int end, String word) {
        this.document = document;
        this.start = start;
        this.end = end;
        this.word = word;
    }

    @Override
    protected Integer compute() {
        int result = 0;
        if(end - start < 10){
            result = processLines(document,start,end,word);
        }else{
            int middle =(start+end)/2;
            DocumentTask task1 = new DocumentTask(document,start,middle+1,word);
            DocumentTask task2 = new DocumentTask(document,middle+1,end,word);
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

    private int processLines(String[][] document, int start, int end, String word) {
        List<LineTask> tasks = new ArrayList<LineTask>();
        for (int i = start; i < end ; i++) {
            LineTask task = new LineTask(document[i],0,document[i].length,word);
            tasks.add(task);
        }

        invokeAll(tasks);
        
        int result = 0;
        for (int i = 0; i < tasks.size(); i++) {
            LineTask task = tasks.get(i);
            try {
                result = result + task.get();
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
}
