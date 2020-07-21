package org.academiadecodigo.javabank.userInterface.menus;


import org.academiadecodigo.javabank.userInterface.OperationType;
import org.academiadecodigo.javabank.userInterface.Request;
import org.academiadecodigo.javabank.userInterface.UserInterface;
import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.domain.account.Account;
import org.academiadecodigo.javabank.domain.account.CheckingAccount;

import java.util.HashMap;

class BalanceMenu implements MyMenu {

    private UserInterface userInterface;
    private Customer customer;
    private HashMap<Integer,Account> accounts;


    public BalanceMenu(UserInterface userInterface){
        this.userInterface = userInterface;
        this.customer = userInterface.getAccountOwner();
        this.accounts = userInterface.getAccountOwner().getAccounts();

    }

    public void start(){

        System.out.println("You have " + accounts.size() + (accounts.size() !=1 ? " accounts" : " account"));

        for (Account account : accounts.values()){
            System.out.println((account instanceof CheckingAccount ? "Checking" : "Savings") + " account #"
                    + account.getId() + " has " + account.getBalance() + " potatoes");
        }

        System.out.println("Total balance: " + customer.getBalance() + " potatoes");
        Request request = new Request();
        request.setOperationType(OperationType.BALANCE);
        userInterface.setRequest(request);
    }
}
