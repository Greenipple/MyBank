package org.academiadecodigo.javabank;

import org.academiadecodigo.javabank.userInterface.UserInterface;
import org.academiadecodigo.javabank.domain.Bank;
import org.academiadecodigo.javabank.managers.AccountManager;

public class Main {


    public static void main(String[] args) {


        AccountManager accountManager = new AccountManager();
        Bank bank = new Bank(accountManager);

        /*Customer firstCostumer = new Customer("Zé das Strings");
        firstCostumer.openAccount(AccountType.CHECKING);
        bank.addCustomer(new Customer("Maria Gustava dos Prazeres & Morais"));*/

        while(true) {
            bank.getCentralController().start();
        }

    }
}
