package com.pera.test.thread02;

import java.util.Date;
import java.util.Deque;

/**
 * Created by csq on 2015/7/30.
 */
public class CleanerTask extends Thread {
    private Deque<Event> deque;

    public CleanerTask(Deque<Event> deque) {
        this.deque = deque;
        setDaemon(true);
    }

    @Override
    public void run() {
        while (true){
            Date date = new Date();
            clean(date);
        }
    }

    private void clean(Date date) {
        long difference;
        boolean delete;

        if(deque.size() == 0)
            return;

        delete = false;

        do{
            Event e = deque.getLast();
            difference = date.getTime() - e.getTime().getTime();
            if(difference > 10000){
                System.out.printf("Cleaner ; %s \n",e.getEvent());
                deque.removeLast();
                delete = true;
            }
        }while (difference > 10000);

        if(delete){
            System.out.printf("Cleaner ; size of the queue %d \n",deque.size());
        }

    }
}
