package org.academiadecodigo.javabank.Services.serviceClasses;

import org.academiadecodigo.javabank.domain.account.Account;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class AccountService implements org.academiadecodigo.javabank.Services.serviceInterface.AccountServiceInterface {


    private static int numberAccounts = 0;
    private Map<Integer, Account> accountMap;
    private AuthenticateService authenticateService;


    public AccountService(){
        this.accountMap = new HashMap<>();
    }

    private Integer getNextId() {
        return accountMap.isEmpty() ? 1 : Collections.max(accountMap.keySet()) + 1;
    }

    @Override
    public void add(Account account) {

        account.setId(getNextId());
        accountMap.put(account.getId(), account);
    }

    @Override
    public void deposit(int id, double amount) {
        accountMap.get(id).credit(amount);
    }

    @Override
    public void withdraw(int id, double amount) {
        Account account = accountMap.get(id);

        if (!account.canWithdraw(amount)) {
            return;
        }

        accountMap.get(id).debit(amount);
    }

    @Override
    public void transfer(int srcId, int dstId, double amount) {
        Account srcAccount = accountMap.get(srcId);
        Account dstAccount = accountMap.get(dstId);

        // make sure transaction can be performed
        if (srcAccount.canDebit(amount) && dstAccount.canCredit(amount)) {
            srcAccount.debit(amount);
            dstAccount.credit(amount);
        }
    }

    public void setAuthenticateService(AuthenticateService authenticateService) {
        this.authenticateService = authenticateService;
    }
}
