package org.academiadecodigo.javabank.controllers.list;

import org.academiadecodigo.javabank.Services.serviceClasses.AccountService;
import org.academiadecodigo.javabank.Services.serviceClasses.AuthenticateService;
import org.academiadecodigo.javabank.Services.serviceClasses.CustomerService;
import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.userInterface.Request;
import org.academiadecodigo.javabank.userInterface.UserInterface;

import java.util.List;

public class MenuAccessController {

    private AccountService accountService;
    private AuthenticateService authenticateService;
    private CustomerService customerService;
    private UserInterface userInterface;


    public MenuAccessController(){
        this.userInterface = new UserInterface(this);
    }

    public Request logIn(){

        return userInterface.logIn();
    }

    public Request openAccount(){
        Request request = userInterface.openAccount();
        return request;
    }

    public Request mainMenuInputs(){
        Request request = userInterface.openMainMenu();
        return request;
    }

    public List<Customer> getCustomerList(){
        return customerService.list();
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void setAuthenticateService(AuthenticateService authenticateService) {
        this.authenticateService = authenticateService;
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public CustomerService getCustomerService() {
        return customerService;
    }

    public AuthenticateService getAuthenticateService() {
        return authenticateService;
    }

    public AccountService getAccountService() {
        return accountService;
    }
}
