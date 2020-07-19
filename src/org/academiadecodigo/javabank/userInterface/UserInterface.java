package org.academiadecodigo.javabank.userInterface;

import org.academiadecodigo.javabank.userInterface.menus.MenuFactory;
import org.academiadecodigo.javabank.userInterface.menus.menuTypes.MenuType;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.javabank.userInterface.menus.MyMenu;
import org.academiadecodigo.javabank.domain.Bank;
import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.domain.account.Account;
import org.academiadecodigo.javabank.domain.account.AccountType;
import org.academiadecodigo.javabank.managers.AccountManager;

import java.util.*;

public class UserInterface {

    private Prompt prompt;
    private AccountManager accountManager;
    private  HashMap<Integer,Account> accountMap;
    private Bank bank;

    //properties of the logged in account:
    private int accountId;
    private Account account;
    private Customer accountOwner;


    public UserInterface(AccountManager accountManager,Bank bank){
        this.prompt = new Prompt(System.in,System.out);
        this.accountManager = accountManager;
        this.accountMap = (HashMap)accountManager.getAccountMap();
        this.bank = bank;
    }


    public void startMenu(){

        System.out.println("Welcome to JavaR Dola Bank!");

        if(accountOwner == null) {
            MyMenu welcome = MenuFactory.create(MenuType.WELCOME, this);
            welcome.start();
        }

        if(accountOwner.getAccounts().size() == 0){
            System.out.println("You need an account to be a customer here!");
            MyMenu newAccount = MenuFactory.create(MenuType.OPENACCOUNT,this);
            newAccount.start();
        }

       MyMenu main = MenuFactory.create(MenuType.MAIN,this);
       main.start();

    }


    public Bank getBank() {
        return bank;
    }

    public void setAccountOwner(Customer accountOwner){
        this.accountOwner = accountOwner;
    }
    public Customer getAccountOwner(){
        return accountOwner;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public AccountManager getAccountManager() {
        return accountManager;
    }
}
