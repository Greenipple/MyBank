package org.academiadecodigo.javabank;

import org.academiadecodigo.javabank.domain.Bank;
import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.domain.account.AccountType;
import org.academiadecodigo.javabank.managers.AccountManager;

public class Main {


    public static void main(String[] args) {


        AccountManager accountManager = new AccountManager();
        Bank bank = new Bank(accountManager);
        UserInterface userInterface = new UserInterface(accountManager);
        Customer firstCostumer = new Customer("Zé das Strings");
        bank.addCustomer(firstCostumer);
        firstCostumer.openAccount(AccountType.CHECKING);

        while(true) {
            userInterface.startMenu();
        }

    }
}
