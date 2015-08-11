package com.pera.test.thread07;

import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * Created by csq on 2015/8/11.
 */
public class Consumer implements Runnable {
    private List<String> buffer;
    private final Exchanger<List<String>> exchanger;

    public Consumer(List<String> buffer, Exchanger<List<String>> exchanger) {
        this.buffer = buffer;
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        int cycle =1;
        for (int i = 0; i < 10; i++) {
            System.out.printf("Consumer : Cycle %d \n",cycle);
            try {
                buffer = exchanger.exchange(buffer);
                System.out.println("Consumer : "+ buffer.size());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int j = 0; j < 10; j++) {
                String msg = buffer.get(0);
                System.out.printf("Consumer :%s \n",msg);
                buffer.remove(0);
            }

            cycle++;

        }
    }
}
