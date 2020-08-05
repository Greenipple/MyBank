package org.academiadecodigo.javabank.domain.account;

import org.academiadecodigo.javabank.domain.Customer;

public class AccountFactory {
    public Account create(AccountType type){
       switch (type){
           case SAVINGS -> {
               return  new SavingsAccount();
           }
           default -> {
               return new CheckingAccount();
           }
       }
    }
}
