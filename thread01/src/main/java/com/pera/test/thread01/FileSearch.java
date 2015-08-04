package com.pera.test.thread01;

import java.io.File;
import java.io.FileWriter;

/**
 * Created by csq on 2015/7/30.
 */
public class FileSearch implements Runnable {
    private String initPath;
    private String fileName;

    public FileSearch(String initPath, String fileName) {
        this.initPath = initPath;
        this.fileName = fileName;
    }

    @Override
    public void run() {
        File file = new File(initPath);
        if(file.isDirectory()){
            try{
                directoryProecss(file);
            }catch (InterruptedException e){
                System.out.printf("%s has been interrupted",Thread.currentThread().getName());
            }
        }
    }

    private void directoryProecss(File file) throws InterruptedException{
        File list[] = file.listFiles();
        if(list != null){
            for (int i = 0; i < list.length; i++) {
                if(list[i].isDirectory()){
                    directoryProecss(list[i]);
                }else {
                    fileProcess(list[i]);
                }
            }
        }

        if(Thread.interrupted()){
            throw  new InterruptedException();
        }
    }

    private void fileProcess(File file) throws InterruptedException {
        if(file.getName().equals(fileName)){
            System.out.printf("%s : %s \n", Thread.currentThread().getName(),file.getAbsolutePath());
        }
        if(Thread.interrupted()){
            throw  new InterruptedException();
        }
    }
}
