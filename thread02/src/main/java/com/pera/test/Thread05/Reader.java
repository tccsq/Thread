package com.pera.test.Thread05;

/**
 * Created by csq on 2015/8/4.
 */
public class Reader implements Runnable {
    private PriceInfo priceInfo;

    public Reader(PriceInfo priceInfo) {
        this.priceInfo = priceInfo;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.printf("%s :the price1 is %s \n",Thread.currentThread().getName(),priceInfo.getPrice1());
            System.out.printf("%s :the price2 is %s \n",Thread.currentThread().getName(),priceInfo.getPrice2());
        }
    }

}
