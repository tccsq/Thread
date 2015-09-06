package com.pera.test.thread03;

/**
 * Created by csq on 2015/8/21.
 */
public class Event implements Comparable<Event> {
    private int thread;
    private int prority;

    public Event(int thread, int prority) {
        this.thread = thread;
        this.prority = prority;
    }

    public int getThread() {
        return thread;
    }

    public int getPrority() {
        return prority;
    }

    @Override
    public int compareTo(Event o) {
        if (this.prority > o.getPrority())
            return -1;

        else if (this.prority < o.getPrority())
            return 1;
        else
            return 0;
    }
}
