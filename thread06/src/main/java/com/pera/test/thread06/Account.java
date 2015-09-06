package com.pera.test.thread06;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by csq on 2015/9/2.
 */
public class Account {
    private AtomicLong banlance;


    public Account() {
        this.banlance = new AtomicLong();
    }

    public Long getBanlance() {
        return banlance.get();
    }

    public void setBanlance(long banlance) {
        this.banlance .set(banlance);
    }

    public void addAmount(long amount){
        this.banlance.getAndAdd(amount);
    }

    public void subtractAmount(long amount){
        this.banlance.getAndAdd(-amount);
    }

}
