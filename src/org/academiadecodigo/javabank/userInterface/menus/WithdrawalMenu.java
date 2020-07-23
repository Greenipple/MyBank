package org.academiadecodigo.javabank.userInterface.menus;

import org.academiadecodigo.javabank.userInterface.OperationType;
import org.academiadecodigo.javabank.userInterface.menus.menuTypes.MenuType;
import org.academiadecodigo.bootcamp.scanners.precisiondouble.DoubleInputScanner;
import org.academiadecodigo.javabank.userInterface.UserInterface;


class WithdrawalMenu implements MyMenu {

    private UserInterface userInterface;


    public WithdrawalMenu(UserInterface userInterface){
        this.userInterface = userInterface;
    }

    @Override
    public void start() {


        MyMenu whichAccount = MenuFactory.create(MenuType.WHICHACCOUNT,userInterface);
        whichAccount.start();


        DoubleInputScanner howMuch = new DoubleInputScanner();
        howMuch.setMessage("How much would you like to withdraw from account #" + userInterface.getRequest().getAccountId());

        double amount = prompt.getUserInput(howMuch);

        userInterface.getRequest().setOperationType(OperationType.WITHDRAWAL);
        userInterface.getRequest().setAmount(amount);
    }
}
