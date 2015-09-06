package com.pera.test.thread05;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by csq on 2015/8/19.
 */
public class SearchNumberTask extends RecursiveTask<Integer> {
    private int numbers[];
    private int start;
    private int end;
    private int number;

    private TaskManager taskManager;
    private final static int NOT_FOUND=-1;

    public SearchNumberTask(int[] numbers, int start, int end, int number, TaskManager taskManager) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
        this.number = number;
        this.taskManager = taskManager;
    }

    @Override
    protected Integer compute() {
        System.out.println("Task: "+start+":"+end);
        int ret;
        if (end-start>10) {
            ret=launchTasks();
        } else {
            ret=lookForNumber();
        }
        return ret;
    }

    private int lookForNumber() {
        for (int i=start; i<end; i++) {
            if (numbers[i] == number) {
                System.out.printf("Task: Number %d found in position %d\n", number, i);
                taskManager.cancelTasks(this);
                return i;
            }
        }
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return NOT_FOUND;
    }

    private int launchTasks() {
        int mid=(start+end)/2;
        SearchNumberTask task1=new SearchNumberTask(numbers,start,mid,number,taskManager);
        SearchNumberTask task2=new SearchNumberTask(numbers,mid,end,number,taskManager);
        taskManager.addTask(task1);
        taskManager.addTask(task2);

        task1.fork();
        task2.fork();

        int returnValue;
        returnValue = task1.join();
        if(returnValue != -1)
            return returnValue;

        returnValue = task2.join();
        return returnValue;
    }

    public void writeCancelMessage(){
        System.out.printf("Task: Canceled task from %d to %d\n",start,end);

    }

}
