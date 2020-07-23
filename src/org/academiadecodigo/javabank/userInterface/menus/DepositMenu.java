package org.academiadecodigo.javabank.userInterface.menus;

import org.academiadecodigo.javabank.userInterface.OperationType;
import org.academiadecodigo.javabank.userInterface.menus.menuTypes.MenuType;
import org.academiadecodigo.bootcamp.scanners.precisiondouble.DoubleInputScanner;
import org.academiadecodigo.javabank.userInterface.UserInterface;
import org.academiadecodigo.javabank.domain.account.Account;


import java.util.HashMap;
import java.util.HashSet;

class DepositMenu implements MyMenu {

    private UserInterface userInterface;
    private HashSet<Account> accounts;


    public DepositMenu(UserInterface userInterface){
        this.userInterface = userInterface;
        this.accounts = userInterface.getLoggedCustomer().getAccounts();
    }

    @Override
    public void start() {

        MyMenu whichAccount = MenuFactory.create(MenuType.WHICHACCOUNT,userInterface);
        whichAccount.start();


        DoubleInputScanner askAmount = new DoubleInputScanner();
        askAmount.setMessage("How much would you like to deposit on account #" +
                userInterface.getRequest().getAccountId() + " ?");

        double amount = prompt.getUserInput(askAmount);

        userInterface.getRequest().setAmount(amount);
        userInterface.getRequest().setOperationType(OperationType.DEPOSIT);
    }
}
