package org.academiadecodigo.javabank.Services.serviceInterface;

import org.academiadecodigo.javabank.domain.account.Account;

public interface AccountServiceInterface {

    void add(Account account);
    void deposit(int id, double amount);
    void withdraw(int id, double amount);
    void transfer(int srcId, int dstId, double amount);
}
