package com.pera.test.thread05;

import com.pera.test.thread02.*;

/**
 * Created by csq on 2015/7/31.
 */
public class Main {

    public static void main(String[] args) {
        test01();
    }

    private static void test01() {
        MyThreadGroup myThreadGroup = new MyThreadGroup("MyThreadGroup");
        Task task = new Task();
        for (int i = 0; i < 2; i++) {
            Thread thread = new Thread(myThreadGroup,task);
            thread.start();
        }

    }


}
