package org.academiadecodigo.javabank.controllers.list;

import org.academiadecodigo.javabank.controllers.AbstractController;
import org.academiadecodigo.javabank.controllers.MenuAccessController;
import org.academiadecodigo.javabank.domain.Bank;
import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.domain.account.Account;
import org.academiadecodigo.javabank.domain.account.AccountType;
import org.academiadecodigo.javabank.userInterface.OperationType;
import org.academiadecodigo.javabank.userInterface.Request;

public class OpenAccountController extends AbstractController {


    private Customer customer;

    public OpenAccountController(Bank bank) {
        super(bank);
        this.customer = centralController().getCustomer();
    }

    @Override
    public void start() {
        Request request = getMenuAccessController().openAccount();
        OperationType operationType =request.getOperationType();
        switch (operationType){
            case OPENSAVINGSACCOUNT -> {
                double amount = request.getAmount();
                int accountId = customer.openAccount(AccountType.SAVINGS);
                customer.deposit(accountId,amount);
            }
            default -> customer.openAccount(AccountType.CHECKING);
        }
    }
}
