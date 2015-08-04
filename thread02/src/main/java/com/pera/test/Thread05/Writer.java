package com.pera.test.Thread05;

/**
 * Created by csq on 2015/8/4.
 */
public class Writer implements Runnable {
    private PriceInfo priceInfo;

    public Writer(PriceInfo priceInfo) {
        this.priceInfo = priceInfo;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.printf("writer: attempt to modify the price.\n");
            priceInfo.setPrice(Math.random() * 10, Math.random() * 8);
            System.out.printf("the price has been modified.\n");
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
