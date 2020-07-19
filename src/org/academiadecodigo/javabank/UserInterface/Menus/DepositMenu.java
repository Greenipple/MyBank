package org.academiadecodigo.javabank.UserInterface.Menus;

import org.academiadecodigo.javabank.UserInterface.MenuFactory;
import org.academiadecodigo.javabank.UserInterface.Menus.MenuTypes.MenuType;
import org.academiadecodigo.bootcamp.scanners.precisiondouble.DoubleInputScanner;
import org.academiadecodigo.javabank.UserInterface.UserInterface;
import org.academiadecodigo.javabank.domain.account.Account;
import org.academiadecodigo.javabank.managers.AccountManager;

import java.util.HashMap;

public class DepositMenu implements MyMenu {

    private UserInterface userInterface;
    private HashMap<Integer, Account> accounts;
    private AccountManager accountManager;

    public DepositMenu(UserInterface userInterface){
        this.userInterface = userInterface;
        this.accounts = userInterface.getAccountOwner().getAccounts();
        this.accountManager = userInterface.getAccountManager();
    }

    @Override
    public void start() {

        MyMenu whichAccount = MenuFactory.create(MenuType.WHICHACCOUNT,userInterface);
        whichAccount.start();
        int id = userInterface.getAccount().getId();

        DoubleInputScanner askAmount = new DoubleInputScanner();
        askAmount.setMessage("How much would you like to deposit on account #" +
                userInterface.getAccount().getId() + " ?");

        double amount = prompt.getUserInput(askAmount);
        accountManager.deposit(id,amount);

    }
}