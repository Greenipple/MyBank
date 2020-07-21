package org.academiadecodigo.javabank.controllers;

import org.academiadecodigo.javabank.domain.Bank;
import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.domain.account.Account;
import org.academiadecodigo.javabank.userInterface.Request;
import org.academiadecodigo.javabank.userInterface.UserInterface;
import org.academiadecodigo.javabank.userInterface.menus.MenuFactory;
import org.academiadecodigo.javabank.userInterface.menus.MyMenu;
import org.academiadecodigo.javabank.userInterface.menus.WelcomeMenu;
import org.academiadecodigo.javabank.userInterface.menus.menuTypes.MenuType;

public class MenuAccessController {

    private Bank bank;
    private UserInterface userInterface;


    public MenuAccessController(Bank bank){
        this.bank = bank;
        this.userInterface = new UserInterface(bank);
    }

    public Customer logIn(){

        return userInterface.logIn();
    }

    public Request openAccount(){
        Request request = userInterface.openAccount();
        return request;
    }

    public Request mainMenuInputs(){
        Request request = userInterface.openMainMenu();
        return request;
    }
}
