package com.pera.test.thread03;

import java.util.concurrent.Callable;

/**
 * Created by csq on 2015/8/12.
 */
public class TaskValidator implements Callable<String> {
    private UserValidator validator;
    private String name;
    private String pwd;

    public TaskValidator(UserValidator validator, String name, String pwd) {
        this.validator = validator;
        this.name = name;
        this.pwd = pwd;
    }

    @Override
    public String call() throws Exception {
        if(!validator.validate(name,pwd)){
            System.out.printf("%s : The user has been  not found\n",validator.getName());
            throw  new Exception("Error validating user");
        }

        System.out.printf("%s : The user has been found\n",validator.getName());
        return null;
    }
}
