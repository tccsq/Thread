package com.pera.test.thread05;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * Created by csq on 2015/8/11.
 */
public class FileSearch implements Runnable {
    private String initPath;
    private String end;
    private List<String> results;
    private Phaser phaser;

    public FileSearch(String initPath, String end, Phaser phaser) {
        this.initPath = initPath;
        this.end = end;
        results = new ArrayList<>();
        this.phaser = phaser;
    }

    @Override
    public void run() {
        phaser.arriveAndAwaitAdvance();
        System.out.printf("%s : Starting.\n",Thread.currentThread().getName());
        File file = new File(initPath);
        if(file.isDirectory())
            procssDirectory(file);

        if(!checkResults())
            return;

        filterFiles();

        if(!checkResults())
            return;

        showInfo();
        phaser.arriveAndDeregister();
        System.out.printf("%s: work completed \n",Thread.currentThread().getName());
    }

    private void procssDirectory(File file){
        File list[] = file.listFiles();
        if(list != null) {
            for (int i = 0; i < list.length; i++) {
                if (list[i].isDirectory()) {
                    procssDirectory(list[i]);
                } else {
                    processFile(list[i]);
                }
            }
        }
    }

    private void processFile(File file) {
        if(file.getName().endsWith(end))
            results.add(file.getAbsolutePath());
    }

    private void filterFiles(){
        List<String> newResults = new ArrayList<>();
        long actualDate = new Date().getTime();

        for (int i = 0; i < results.size(); i++) {
            File file = new File(results.get(i));
            long fileDate = file.lastModified();

            if(actualDate - fileDate < TimeUnit.SECONDS.convert(1,TimeUnit.DAYS)){
                newResults.add(results.get(i));
            }
        }

        results = newResults;
    }

    private boolean checkResults(){
        if(results.isEmpty()){
            System.out.printf("%s : Phase %d: 0 results\n",Thread.currentThread().getName(),phaser.getPhase());
            System.out.printf("%s : Phase %d: 0 End \n",Thread.currentThread().getName(),phaser.getPhase());
            //通知phaser对象当前线程已经完成当前阶段，并且不再参与接下来的阶段操作
            phaser.arriveAndDeregister();
            return false;
        }else {
            System.out.printf("%s : Phase %d: %d results\n",Thread.currentThread().getName(),phaser.getPhase(),results.size());
            //通知phaser对象当前线程已经完成当前阶段，需要被阻塞到其他线程都完成当前阶段
            phaser.arriveAndAwaitAdvance();
            return true;
        }
    }

    private void showInfo(){
        for (int i = 0; i < results.size(); i++) {
            File file = new File(results.get(i));
            System.out.printf("%s : %s \n",Thread.currentThread().getName(),file.getAbsolutePath());
        }
        phaser.arriveAndAwaitAdvance();
    }
}
