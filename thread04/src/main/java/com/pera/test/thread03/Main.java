package com.pera.test.thread03;


import com.pera.test.Thread02.FactorialCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by csq on 2015/8/3.
 */
public class Main {
    public static void main(String[] args) {
        String username = "test";
        String pwd = "test";
        UserValidator ldaValidator = new UserValidator("LDAP");
        UserValidator dbValidator = new UserValidator("DataBase");

        TaskValidator ldaTask = new TaskValidator(ldaValidator,username,pwd);
        TaskValidator dbTask = new TaskValidator(dbValidator,username,pwd);

        List<TaskValidator> taskList = new ArrayList<>();
        taskList.add(ldaTask);
        taskList.add(dbTask);

        ExecutorService executor = Executors.newCachedThreadPool();

        String result;

        try {
            //TODO 返回结果一直是NULL
            result = executor.invokeAny(taskList);
            System.out.printf("Main : Result: %s \n",result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();

        System.out.println("Main : End of execution");
    }
}
