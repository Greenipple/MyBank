package org.academiadecodigo.javabank.UserInterface.Menus;

import org.academiadecodigo.javabank.UserInterface.MenuFactory;
import org.academiadecodigo.javabank.UserInterface.Menus.MenuTypes.MenuType;
import org.academiadecodigo.bootcamp.scanners.precisiondouble.DoubleInputScanner;
import org.academiadecodigo.javabank.UserInterface.Menus.MyMenu;
import org.academiadecodigo.javabank.UserInterface.UserInterface;
import org.academiadecodigo.javabank.managers.AccountManager;

public class WithdrawalMenu implements MyMenu {

    private UserInterface userInterface;
    private AccountManager accountManager;

    public WithdrawalMenu(UserInterface userInterface){
        this.userInterface = userInterface;
        this.accountManager = userInterface.getAccountManager();
    }

    @Override
    public void start() {


        MyMenu whichAccount = MenuFactory.create(MenuType.WHICHACCOUNT,userInterface);
        whichAccount.start();
        int id = userInterface.getAccount().getId();

        DoubleInputScanner howMuch = new DoubleInputScanner();
        howMuch.setMessage("How much would you like to withdraw from account #" + userInterface.getAccount().getId());

        double amount = prompt.getUserInput(howMuch);
        System.out.println((accountManager.withdraw(id,amount) == true) ?
                "Operation complete!" : "Not enough money on that account!") ;

    }
}
