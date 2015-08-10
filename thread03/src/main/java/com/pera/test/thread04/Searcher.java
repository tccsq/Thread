package com.pera.test.thread04;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by csq on 2015/8/10.
 */
public class Searcher implements Runnable {
    private int firstRow;
    private int lastRow;
    private MatrixMock mock;
    private Results results;
    private int number;
    private final CyclicBarrier barrier;

    public Searcher( int firstRow,int lastRow, MatrixMock mock, Results results, int number,CyclicBarrier barrier) {
        this.barrier = barrier;
        this.number = number;
        this.results = results;
        this.mock = mock;
        this.lastRow = lastRow;
        this.firstRow = firstRow;
    }

    @Override
    public void run() {
        int counter;
        System.out.printf("%s : Processing lines from %d to %d.\n", Thread.currentThread().getName(), firstRow, lastRow);

        for (int i = 0; i < lastRow; i++) {
            int row[] = mock.getRow(i);

            counter = 0;
            for (int j = 0; j < row.length; j++) {
                if(row[j] == number)
                    counter++;
            }
            results.setData(i,counter);
        }

        System.out.printf("%s :Line Processed.\n", Thread.currentThread().getName());

        try {
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }


    }
}
