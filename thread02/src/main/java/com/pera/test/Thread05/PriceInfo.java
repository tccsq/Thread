package com.pera.test.Thread05;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by csq on 2015/8/4.
 */
public class PriceInfo {
    private double price1;
    private double price2;
    private ReadWriteLock lock;

    public PriceInfo() {
        this.price1 = 1.0;
        this.price2 = 2.0;
        lock = new ReentrantReadWriteLock();
    }


    public double getPrice1() {
        lock.readLock().lock();
        double value = price1;
        lock.readLock().unlock();
        return value;
    }

    public double getPrice2() {
        lock.readLock().lock();
        double value = price2;
        lock.readLock().unlock();
        return value;
    }

    public void setPrice(double price1,double price2){
        lock.writeLock().lock();
        this.price1 = price1;
        this.price2 = price2;
        lock.writeLock().unlock();
    }

}

