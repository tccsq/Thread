package com.pera.test.thread06;

/**
 * Created by csq on 2015/9/6.
 */
public class Main {

    public static void main(String args[]) {
        Account account = new Account();
        account.setBanlance(1000);

        Company company = new Company(account);
        Bank bank = new Bank(account);

        Thread companyThread = new Thread(company);
        Thread bankThread = new Thread(bank);

        System.out.printf("Account: Initial Balance : %d\n",account.getBanlance());

        companyThread.start();
        bankThread.start();

        try {
            companyThread.join();
            bankThread.join();

            System.out.printf("Account : final Balance : %d \n",account.getBanlance());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
