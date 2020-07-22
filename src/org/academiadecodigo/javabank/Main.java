package org.academiadecodigo.javabank;

import org.academiadecodigo.javabank.serviceInterfaceClasses.AccountService;
import org.academiadecodigo.javabank.serviceInterfaceClasses.AuthenticateService;
import org.academiadecodigo.javabank.serviceInterfaceClasses.CustomerService;
import org.academiadecodigo.javabank.userInterface.UserInterface;
import org.academiadecodigo.javabank.domain.Bank;
import org.academiadecodigo.javabank.managers.AccountManager;

public class Main {


    public static void main(String[] args) {


        AccountManager accountManager = new AccountManager();
        Bank bank = new Bank(accountManager);

        AccountService accountService = new AccountService();
        CustomerService customerService = new CustomerService();
        AuthenticateService authenticateService = new AuthenticateService(customerService);

        customerService.setAuthenticateService(authenticateService);
        accountService.setAuthenticateService(authenticateService);


        /*Customer firstCostumer = new Customer("Zé das Strings");
        firstCostumer.openAccount(AccountType.CHECKING);
        bank.addCustomer(new Customer("Maria Gustava dos Prazeres & Morais"));*/

        while(true) {
            bank.getCentralController().start();
        }

    }
}
