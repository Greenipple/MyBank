package org.academiadecodigo.javabank.controllers.list;

import org.academiadecodigo.javabank.controllers.AbstractController;
import org.academiadecodigo.javabank.domain.Bank;
import org.academiadecodigo.javabank.domain.account.Account;
import org.academiadecodigo.javabank.domain.account.AccountType;
import org.academiadecodigo.javabank.userInterface.OperationType;
import org.academiadecodigo.javabank.userInterface.Request;

public class MainMenuController extends AbstractController {



    public MainMenuController(Bank bank) {

        super(bank);
    }

    @Override
    public void start() {

        Request request = getMenuAccessController().mainMenuInputs();
        OperationType operationType = request.getOperationType();

        switch(operationType){
            case DEPOSIT -> {
                int accountId = request.getAccountId();
                double amount = request.getAmount();
               // System.out.println(accountId+","+ amount);
                centralController().getAccountManager().deposit(accountId,amount);
            }

            case WITHDRAWAL -> {
                int accountId = request.getAccountId();
                double amount = request.getAmount();
                centralController().getAccountManager().withdraw(accountId,amount);
            }

            case OPENCHECKINGACCOUNT -> {

                centralController().getCustomer().openAccount(AccountType.CHECKING);
            }

            case OPENSAVINGSACCOUNT -> {
                double amount = request.getAmount();
                int accountId = centralController().getCustomer().openAccount(AccountType.SAVINGS);
                centralController().getAccountManager().deposit(accountId,amount);
            }

            case LOGOFF -> {
                centralController().setCustomer(null);
            }
        }




    }
}
