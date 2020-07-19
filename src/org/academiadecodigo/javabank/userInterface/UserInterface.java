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


/*
        IntegerInputScanner askClientNr = new IntegerSetInputScanner(getAccountNrsList());
        askClientNr.setMessage("What is your customer number?");
        accountId = prompt.getUserInput(askClientNr);


        account = accountMap.get(accountId);
        accountOwner = account.getAccountOwner();
        System.out.println("This account is a " + account.getAccountType().toString().toLowerCase() +" account");


        String[] mainOptions = {"Get balance", "Make a deposit", "Make a withdrawal", "Open an account", "Exit the application"};
        MenuInputScanner mainMenu = new MenuInputScanner(mainOptions);
        mainMenu.setMessage("What would you like to do " + accountOwner.getName() + "?");

        int answerIndex = prompt.getUserInput(mainMenu);


        switch (answerIndex){

            case 1 ->{
                System.out.println("You have "+ account.getBalance());
            }

            case 2 ->{
                DoubleInputScanner howMuchDeposit = new DoubleInputScanner();
                howMuchDeposit.setMessage("How much would you like to deposit?");
                double amount = prompt.getUserInput(howMuchDeposit);
                accountManager.deposit(accountId,amount);
                System.out.println("Operation completed");
            }

            case 3 ->{
                DoubleInputScanner howMuchWithdrawal = new DoubleInputScanner();
                howMuchWithdrawal.setMessage("How much would you like to withdraw?");
                double amount = prompt.getUserInput(howMuchWithdrawal);
                accountManager.withdraw(accountId,amount);
            }

            case 4 ->{
                openAccountMenu();
            }

            case 5 ->{
                System.out.println("Exiting.....");
                System.exit(0);
            }
        }*/


    }

    private HashSet getAccountNrsList(){

        //Make an HashSet of the account nrs (AccountNrs)

        //accountMap = (HashMap)accountManager.getAccountMap();
        // Collection<Account> accountCollection = accountMap.values();
        HashSet<Integer> accountNrs = new HashSet<>();

        for (Account account : accountMap.values()){
            accountNrs.add(account.getId());
        }

        return accountNrs;
    }

    private void openAccountMenu(){
        String[] newAccountOptions = {"Checking account", "Savings account"};
        MenuInputScanner newAccountMenu = new MenuInputScanner(newAccountOptions);
        newAccountMenu.setMessage("What kind of account would you like to open?");

        AccountType accountType = prompt.getUserInput(newAccountMenu) == 1 ? AccountType.CHECKING :AccountType.SAVINGS;
        accountManager.openAccount(accountType,accountOwner);
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
