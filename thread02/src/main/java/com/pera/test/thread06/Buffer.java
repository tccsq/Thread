package com.pera.test.thread06;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by csq on 2015/8/7.
 */
public class Buffer {
    private LinkedList<String> buffer;//存放共享数据
    private int maxSize;//buffer的长度
    private ReentrantLock lock;//对buffer的代码块进行控制
    private Condition lines;//
    private Condition space;
    private boolean pendingLines; //表明缓冲区是否还有数据


    public Buffer(int maxSize) {
        this.maxSize = maxSize;
        buffer = new LinkedList<>();
        lock = new ReentrantLock();
        lines = lock.newCondition();
        space = lock.newCondition();
        pendingLines = true;
    }

    public void insert(String line) {
        lock.lock();
        try {
            while (buffer.size() == maxSize) {
                space.await();
            }

            buffer.offer(line);
            System.out.printf("%s : Inserted Line: %d\n", Thread.currentThread().getName(), buffer.size());
            lines.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public String get(){
        String line = null;
        lock.lock();
        try{
            while (buffer.size() == 0 && hasPendingLines()){
                lines.await();
            }

            if(hasPendingLines()){
                line = buffer.poll();
                System.out.printf("%s: Line readed :%d\n",Thread.currentThread().getName(),buffer.size());
                space.signalAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return line;
    }

    public boolean hasPendingLines() {
        return pendingLines || buffer.size() >0;
    }

    public void setPendingLines(boolean pendingLines) {
        this.pendingLines = pendingLines;
    }
}
