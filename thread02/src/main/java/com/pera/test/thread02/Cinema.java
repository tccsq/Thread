package com.pera.test.thread02;

import java.util.Objects;

/**
 * Created by csq on 2015/8/3.
 */
public class Cinema {
    private long vacanciesCinema1;
    private long vacanciesCinema2;

    private final Object controlCinema1,controlCinema2;

    public Cinema() {
        controlCinema1 = new Object();
        controlCinema2 = new Object();

        vacanciesCinema1 = 20;
        vacanciesCinema2 = 20;
    }

    public boolean sellTickets1(int num){
        synchronized (controlCinema1){
            if(num < vacanciesCinema1){
                vacanciesCinema1 -= num;
                return true;
            }else {
                return false;
            }
        }
    }

    public boolean sellTickets2(int num){
        synchronized (controlCinema2){
            if(num < vacanciesCinema2){
                vacanciesCinema2 -= num;
                return true;
            }else {
                return false;
            }
        }
    }

    public boolean returnTickets1 (int num){
        synchronized (controlCinema1){
            vacanciesCinema1 += num;
            return true;
        }
    }

    public boolean returnTickets2 (int num){
        synchronized (controlCinema2){
            vacanciesCinema2 += num;
            return true;
        }
    }


    public long getVacanciesCinema1() {
        return vacanciesCinema1;
    }

    public long getVacanciesCinema2() {
        return vacanciesCinema2;
    }
}

