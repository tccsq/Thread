package com.pera.test.thread05;

import java.util.Random;

/**
 * Created by csq on 2015/8/19.
 */
public class ArrayGenerator {

    public int[] generateArray(int size) {
        int array[] = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(10);
        }
        return array;
    }

}
