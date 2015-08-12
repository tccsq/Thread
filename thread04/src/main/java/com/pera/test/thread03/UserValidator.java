package com.pera.test.thread03;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by csq on 2015/8/12.
 */
public class UserValidator {
    private String name;

    public UserValidator(String name) {
        this.name = name;
    }

    public boolean validate(String name,String pwd){
        Random random = new Random();
        try {
            Long duration = (long)(Math.random()*10);
            System.out.printf("Validator %s : Validating a user during %d seconds\n",this.name,duration);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            return  false;
        }
        return random.nextBoolean();
    }

    public String getName() {
        return name;
    }
}
