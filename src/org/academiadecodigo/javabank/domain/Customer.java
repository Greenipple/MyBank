package org.academiadecodigo.javabank.domain;

import org.academiadecodigo.javabank.Services.serviceClasses.AccountService;
import org.academiadecodigo.javabank.domain.account.Account;
import org.academiadecodigo.javabank.domain.account.AccountType;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * The customer domain entity
 */
public class Customer {

    private int customerId;
    private String name;

    private HashSet<Account> accounts = new HashSet<>();
    private AccountService accountService;

    public Customer(){};
    public Customer(String name){
        this.name = name;
    }



    public void addAccount(Account account) {
       accounts.add(account);
    }


    /**
     * Gets the total customer balance
     *
     * @return the customer balance
     */
    public double getBalance() {

        double balance = 0;

        for (Account account : accounts) {
            balance += account.getBalance();
        }

        return balance;
    }

    public String getName() {
        return name;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getCustomerId(){
        return customerId;
    }
    public HashSet<Account> getAccounts(){
        return accounts;
    }
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }
}
