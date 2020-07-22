package org.academiadecodigo.javabank.serviceInterface;

import org.academiadecodigo.javabank.domain.account.Account;

public interface AccountService {

    void add(Account account);
    void deposit(int id, double amount);
    void withdraw(int id, double amount);
    void transfer(int srcId, int dstId, double amount);
}
