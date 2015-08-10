package com.pera.test.thread04;


import com.pera.test.thread03.Conference;
import com.pera.test.thread03.Participant;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by csq on 2015/8/3.
 */
public class Main {
    public static void main(String[] args) {
        final int ROWS = 10000;
        final int NUMBERS = 1000;
        final int SEACH = 5;
        final int PARTICIPANS = 5;
        final int LINES_PARTICIPANS = 2000;

        MatrixMock mock = new MatrixMock(ROWS,NUMBERS,SEACH);
        Results results = new Results(ROWS);
        Grouper grouper = new Grouper(results);

        CyclicBarrier barrier = new CyclicBarrier(PARTICIPANS,grouper);

        Searcher searcher[] = new Searcher[PARTICIPANS];
        for (int i = 0; i < PARTICIPANS; i++) {
            searcher[i] = new Searcher(i*LINES_PARTICIPANS,(i*LINES_PARTICIPANS)+LINES_PARTICIPANS,mock,results,5,barrier);
            Thread t = new Thread(searcher[i]);
            t.start();
        }
        System.out.printf("********Finished*******");
    }
}
