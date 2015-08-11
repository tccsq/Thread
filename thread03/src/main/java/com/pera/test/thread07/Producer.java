package com.pera.test.thread07;

import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * Created by csq on 2015/8/11.
 */
public class Producer implements Runnable {
    private List<String> buffer;
    private final Exchanger<List<String>> exchanger;

    public Producer(List<String> buffer, Exchanger<List<String>> exchanger) {
        this.buffer = buffer;
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        int cycle =1;
        for (int i = 0; i < 10; i++) {
            System.out.printf("Producer : Cycle %d \n",cycle);
            for (int j = 0; j < 10; j++) {
                String msg = "Event "+((i*10)+j);
                System.out.printf("Producer :%s \n",msg);
                buffer.add(msg);
            }

            try {
                buffer = exchanger.exchange(buffer);
                System.out.println("Producer : "+ buffer.size());
                cycle++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
