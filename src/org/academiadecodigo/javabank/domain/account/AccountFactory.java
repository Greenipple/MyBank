package org.academiadecodigo.javabank.domain.account;

import org.academiadecodigo.javabank.domain.Customer;

public class AccountFactory {
    public static Account create(AccountType type, int accountNr, Customer accountOwner){
       switch (type){
           case SAVINGS -> {
               return  new SavingsAccount(accountNr,accountOwner);
           }
           default -> {
               return new CheckingAccount(accountNr,accountOwner);
           }
       }
    }
}
