package com.pera.test.thread04;

/**
 * Created by csq on 2015/8/13.
 */
public class Result {
    private String name;
    private int value;

    public Result(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
