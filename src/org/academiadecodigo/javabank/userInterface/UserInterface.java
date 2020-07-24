package org.academiadecodigo.javabank.userInterface;

import org.academiadecodigo.javabank.controllers.list.MenuAccessController;
import org.academiadecodigo.javabank.userInterface.menus.MenuFactory;
import org.academiadecodigo.javabank.userInterface.menus.menuTypes.MenuType;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.javabank.userInterface.menus.MyMenu;
import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.domain.account.Account;


import java.util.*;

public class UserInterface {

    private MenuAccessController menuAccessController;
    private Prompt prompt;


    //properties of the logged in account:
   // private int accountId;
   // private Account account;
    //private Customer accountOwner;

    //Requests to send:
    private Request request;


    public UserInterface(MenuAccessController menuAccessController){
        this.menuAccessController = menuAccessController;
        this.prompt = new Prompt(System.in,System.out);
    }


    public Request logIn(){
        MyMenu welcome = MenuFactory.create(MenuType.WELCOME, this);
        welcome.start();
        return request;
    }
    public Customer getLoggedCustomer(){
        return menuAccessController.getAuthenticateService().getLoggedInCustomer();
    }

    public Request openAccount(){
        MyMenu openAccount = MenuFactory.create(MenuType.OPENACCOUNT,this);
        openAccount.start();
        return request;
    }

    public Request openMainMenu(){
        MyMenu main = MenuFactory.create(MenuType.MAIN,this);
        main.start();
        return request;
    }


    public List<Customer> getCustomerList(){
        return menuAccessController.getCustomerList();
    }


   /* public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }*/


    public void setRequest(Request request) {
        this.request = request;
    }

    public Request getRequest() {
        return request;
    }
}
