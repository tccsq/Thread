package com.pera.test.thread05;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;

/**
 * Created by csq on 2015/8/19.
 */
public class TaskManager {
    private List<ForkJoinTask<Integer>> tasks;

    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(ForkJoinTask<Integer> task) {
        tasks.add(task);
    }

    public void cancelTasks(ForkJoinTask<Integer> task) {
        for (ForkJoinTask<Integer> item : tasks){
            if(item != task){
                task.cancel(true);
                ((SearchNumberTask)task).writeCancelMessage();
            }
        }
    }
}
