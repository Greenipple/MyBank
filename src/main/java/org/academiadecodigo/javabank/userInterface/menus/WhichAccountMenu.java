package org.academiadecodigo.javabank.userInterface.menus;

import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.javabank.userInterface.Request;
import org.academiadecodigo.javabank.userInterface.UserInterface;
import org.academiadecodigo.javabank.domain.account.Account;
import org.academiadecodigo.javabank.domain.account.CheckingAccount;

import java.util.HashMap;
import java.util.HashSet;

class WhichAccountMenu implements MyMenu {

    private UserInterface userInterface;
    private HashSet<Account> accounts;



    public WhichAccountMenu(UserInterface userInterface){
        this.userInterface = userInterface;
        this.accounts = userInterface.getLoggedCustomer().getAccounts();
    }

    public void start(){

        if(accounts.size() == 1){
            for (Account account : accounts){

                Request request = new Request();
                request.setAccountId(account.getId());

                userInterface.setRequest(request);
            }
            return;
        }

        String[] options = new String[accounts.size()];
        HashMap<Integer, Account> menuIndex  = new HashMap<>();
        int i = 0;
        for(Account account : accounts){
            options[i] = (account instanceof CheckingAccount ? "Checking account #" : "Savings account #") +
                    account.getId() + " has " + account.getBalance() + " potatoes";
            i++;
            menuIndex.put(i,account);

        }

        MenuInputScanner chooseAccount = new MenuInputScanner(options);
        chooseAccount.setMessage("Please choose an account");

        int chosenAccountIndex = prompt.getUserInput(chooseAccount);


       // userInterface.setAccount(menuIndex.get(chosenAccountIndex));


        Request request = new Request();
        request.setAccountId(menuIndex.get(chosenAccountIndex).getId());

        userInterface.setRequest(request);

    }
}
