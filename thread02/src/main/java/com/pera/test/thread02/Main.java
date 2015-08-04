package com.pera.test.thread02;

import com.pera.test.thread01.Account;
import com.pera.test.thread01.Bank;
import com.pera.test.thread01.Company;

/**
 * Created by csq on 2015/8/3.
 */
public class Main {
    public static void  main(String[] args){
        Cinema cinema = new Cinema();
        TicketOffice1 ticketOffice1 = new TicketOffice1(cinema);
        TicketOffice2 ticketOffice2 = new TicketOffice2(cinema);

        Thread thread1 = new Thread(ticketOffice1);
        Thread thread2 = new Thread(ticketOffice2);

        thread1.start();
        thread2.start();

        try{
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Room1 Vacancies: %d \n",cinema.getVacanciesCinema1());
        System.out.printf("Room2 Vacancies: %d \n",cinema.getVacanciesCinema2());
    }
}
