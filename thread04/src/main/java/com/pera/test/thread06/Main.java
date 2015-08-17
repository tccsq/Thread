package com.pera.test.thread06;




import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Created by csq on 2015/8/3.
 */
public class Main {
    public static void main(String[] args) {

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        System.out.printf("Main : Starting at %s \n",new Date());
        Task task = new Task("task");

        ScheduledFuture<?> result = executor.scheduleAtFixedRate(task,1,2,TimeUnit.SECONDS);

        for (int i = 0; i < 10; i++) {
            System.out.printf("Main : Delay : %d\n",result.getDelay(TimeUnit.MILLISECONDS));

            try {
                TimeUnit.MICROSECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



        try {
            TimeUnit.SECONDS.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //shutdown 执行后不再继续定时任务
        executor.shutdown();

        System.out.printf("Main : Finished at :%s \n", new Date());
    }

    /**
     * 以固定周期频率执行任务
     */
    public static void executeFixedRate() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(
                new EchoServer(),
                1,
                2,
                TimeUnit.SECONDS);

        executor.shutdown();
    }

}
