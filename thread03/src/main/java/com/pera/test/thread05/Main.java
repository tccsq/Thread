package com.pera.test.thread05;


import com.pera.test.thread04.Grouper;
import com.pera.test.thread04.MatrixMock;
import com.pera.test.thread04.Results;
import com.pera.test.thread04.Searcher;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Phaser;

/**
 * Created by csq on 2015/8/3.
 */
public class Main {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(3);
        FileSearch system = new FileSearch("C:\\Windows","log",phaser);
        FileSearch app = new FileSearch("C:\\Program Files","log",phaser);
        FileSearch documents = new FileSearch("C:\\ProgramData","log",phaser);

        Thread systemThread = new Thread(system,"System");
        systemThread.start();

        Thread appThread = new Thread(app,"App");
        appThread.start();

        Thread documentsThread = new Thread(documents,"Documents");
        documentsThread.start();

        try {
            systemThread.join();
            appThread.join();
            documentsThread.join();

            System.out.println("Terminated:"+phaser.isTerminated());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
