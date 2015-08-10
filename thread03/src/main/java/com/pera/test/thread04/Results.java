package com.pera.test.thread04;

/**
 * Created by csq on 2015/8/10.
 */
public class Results  {
    private int[] data;

    public Results(int size) {
        this.data = new int[size];
    }

    public void setData(int pos,int val){
        data[pos] = val;
    }

    public int[] getData() {
        return data;
    }

}
