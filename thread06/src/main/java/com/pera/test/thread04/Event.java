package com.pera.test.thread04;

import java.util.Date;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by csq on 2015/9/2.
 */
public class Event implements Delayed {
    private Date startDate;

    public Date getStartDate() {
        return startDate;
    }

    public Event(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        Date now = new Date();
        long diff = startDate.getTime() - now.getTime();
        return unit.convert(diff,TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        long result = this.getDelay(TimeUnit.NANOSECONDS) - o.getDelay(TimeUnit.NANOSECONDS);
        if(result < 0)
            return -1;
        else if(result > 0)
            return 1;
        else
            return 0;
    }
}
