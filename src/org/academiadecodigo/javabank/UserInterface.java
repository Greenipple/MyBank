package org.academiadecodigo.javabank;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerSetInputScanner;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.bootcamp.scanners.precisiondouble.DoubleInputScanner;
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
    private int accountId;
    private Account account;
    private Customer accountOwner;
    private Bank bank;


    public UserInterface(AccountManager accountManager){
        this.prompt = new Prompt(System.in,System.out);
        this.accountManager = accountManager;
        this.accountMap = (HashMap)accountManager.getAccountMap();
    }


    public void startMenu(){
        System.out.println("Welcome to JavaBank!");


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
        }


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

}
