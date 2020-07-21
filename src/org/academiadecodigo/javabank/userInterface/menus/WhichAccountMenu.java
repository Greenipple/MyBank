package org.academiadecodigo.javabank.userInterface.menus;

import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.javabank.userInterface.Request;
import org.academiadecodigo.javabank.userInterface.UserInterface;
import org.academiadecodigo.javabank.domain.account.Account;
import org.academiadecodigo.javabank.domain.account.CheckingAccount;

import java.util.HashMap;

class WhichAccountMenu implements MyMenu {

    private UserInterface userInterface;
    private HashMap<Integer, Account> accounts;



    public WhichAccountMenu(UserInterface userInterface){
        this.userInterface = userInterface;
        this.accounts = userInterface.getAccountOwner().getAccounts();
    }

    public void start(){

        if(accounts.size() == 1){
            for (Account account : accounts.values()){
                userInterface.setAccount(account);
                Request request = new Request();
                request.setAccountId(userInterface.getAccount().getId());
                userInterface.setRequest(request);
            }
            return;
        }


        String[] options = new String[accounts.size()];
        HashMap<Integer, Account> menuIndex  = new HashMap<>();
        int i = 0;
        for(Account account : accounts.values()){
            options[i] = (account instanceof CheckingAccount ? "Checking account #" : "Savings account #") +
                    account.getId() + " has " + account.getBalance() + " potatoes";
            i++;
            menuIndex.put(i,account);
        }

        MenuInputScanner chooseAccount = new MenuInputScanner(options);
        chooseAccount.setMessage("Please choose an account");

        int chosenAccountIndex = prompt.getUserInput(chooseAccount);


        userInterface.setAccount(menuIndex.get(chosenAccountIndex));


        Request request = new Request();
        request.setAccountId(userInterface.getAccount().getId());
       // request.setOperationType(OperationType.ACCOUNTLOGIN);
        userInterface.setRequest(request);




    }
}
