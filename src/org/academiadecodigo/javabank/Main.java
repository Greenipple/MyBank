package org.academiadecodigo.javabank;

import UserInterface.UserInterface;
import org.academiadecodigo.javabank.domain.Bank;
import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.domain.account.AccountType;
import org.academiadecodigo.javabank.managers.AccountManager;

public class Main {


    public static void main(String[] args) {


        AccountManager accountManager = new AccountManager();
        Bank bank = new Bank(accountManager);
        UserInterface userInterface = new UserInterface(accountManager, bank);
        /*Customer firstCostumer = new Customer("Zé das Strings");
        firstCostumer.openAccount(AccountType.CHECKING);
        bank.addCustomer(new Customer("Maria Gustava dos Prazeres & Morais"));*/

        while(true) {
            userInterface.startMenu();
        }

    }
}
