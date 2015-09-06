package com.pera.test.thread06;

/**
 * Created by csq on 2015/9/2.
 */
public class Company implements Runnable {
    private Account account;

    public Company(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i=0; i<10; i++){
            account.addAmount(1000);
        }
    }
}
