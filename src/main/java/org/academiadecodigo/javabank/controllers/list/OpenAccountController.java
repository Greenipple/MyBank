package org.academiadecodigo.javabank.controllers.list;

import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.domain.account.Account;
import org.academiadecodigo.javabank.domain.account.AccountFactory;
import org.academiadecodigo.javabank.domain.account.AccountType;
import org.academiadecodigo.javabank.userInterface.OperationType;
import org.academiadecodigo.javabank.userInterface.Request;

public class OpenAccountController extends AbstractController {


   // private Customer customer;
    private AccountFactory accountFactory;
    private Request request;

    public OpenAccountController(MenuAccessController menuAccessController) {
        super(menuAccessController);
    }


    @Override
    public void start() {
        if(request == null) {
            request = getMenuAccessController().openAccount();
        }
        accountFactory = new AccountFactory();
        OperationType operationType =request.getOperationType();

        switch (operationType){

            case OPENSAVINGSACCOUNT -> {
                Customer customer = getAuthenticateService().getLoggedInCustomer();

                double amount = request.getAmount();
                Account account = accountFactory.create(AccountType.SAVINGS);

                getAccountService().add(account);
                customer.addAccount(account);

                int accountId = account.getId();
                getAccountService().deposit(accountId,amount);
            }

            default -> {
                Customer customer = getAuthenticateService().getLoggedInCustomer();
                Account account = accountFactory.create(AccountType.CHECKING);

                getAccountService().add(account);
                customer.addAccount(account);
            }

        }
    }

    public void setAccountFactory(AccountFactory accountFactory) {
        this.accountFactory = accountFactory;
    }

    public void setRequest(Request request) {
        this.request = request;
    }
}
