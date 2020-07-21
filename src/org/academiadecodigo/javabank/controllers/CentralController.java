package org.academiadecodigo.javabank.controllers;

import org.academiadecodigo.javabank.controllers.controlerGadgets.Controller;
import org.academiadecodigo.javabank.controllers.controlerGadgets.ControllerFactory;
import org.academiadecodigo.javabank.controllers.controlerGadgets.ControllerType;
import org.academiadecodigo.javabank.domain.Bank;
import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.domain.account.Account;
import org.academiadecodigo.javabank.managers.AccountManager;

public class CentralController implements Controller {

    private AccountManager accountManager;
    private Bank bank;
    private MenuAccessController menuAccessController;

    //Logged in:
    private Customer customer;
   // private Account account;

    public CentralController(Bank bank, AccountManager accountManager){

        this.bank = bank;
        this.accountManager = accountManager;
        this.menuAccessController = new MenuAccessController(bank);
    }



    public void start(){

        if (customer == null){
            Controller logIn = ControllerFactory.create(ControllerType.LOGIN,bank);
            logIn.start();
          /*  Controller createAccount = ControllerFactory.create(ControllerType.OPENACCOUNT,bank);
            createAccount.start();*/
        }
        if(customer.getAccounts().size() == 0){
            System.out.println("You need an account to be a customer here!");
            Controller createAccount = ControllerFactory.create(ControllerType.OPENACCOUNT,bank);
            createAccount.start();
        }


        Controller main = ControllerFactory.create(ControllerType.MAIN,bank);
        main.start();
    }

    public Customer getCustomer(){
        return  customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

   /* public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }*/

    public MenuAccessController getMenuAccessController() {
        return menuAccessController;
    }

    public AccountManager getAccountManager() {
        return accountManager;
    }

    public void setAccountManager(AccountManager accountManager) {
        this.accountManager = accountManager;
    }
}
