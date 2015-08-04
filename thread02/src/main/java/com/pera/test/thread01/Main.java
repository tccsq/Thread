package com.pera.test.thread01;

/**
 * Created by csq on 2015/8/3.
 */
public class Main {
    public static void  main(String[] args){
        Account account = new Account();
        account.setBalance(1000);

        Company company = new Company(account);
        Bank bank = new Bank(account);

        Thread companyThread = new Thread(company);
        Thread bankThread = new Thread(bank);

        System.out.printf("Account : Initial balance : % f\n", account.getBalance());

        companyThread.start();
        bankThread.start();

        try {
            companyThread.join();
            bankThread.join();

            System.out.printf("Account : final balance : % f\n", account.getBalance());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }
}
