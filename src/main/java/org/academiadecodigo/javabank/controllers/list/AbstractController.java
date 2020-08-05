package org.academiadecodigo.javabank.controllers.list;

import org.academiadecodigo.javabank.Services.serviceClasses.AccountService;
import org.academiadecodigo.javabank.Services.serviceClasses.AuthenticateService;
import org.academiadecodigo.javabank.Services.serviceClasses.CustomerService;
import org.academiadecodigo.javabank.controllers.controlerGadgets.Controller;


public abstract class AbstractController implements Controller {


    private AuthenticateService authenticateService;
    private AccountService accountService;
    private CustomerService customerService;

    private MenuAccessController menuAccessController;

    protected AbstractController(MenuAccessController menuAccessController) {
        this.menuAccessController = menuAccessController;
    }


    public void setServices(AuthenticateService authenticateService, AccountService accountService,
                            CustomerService customerService) {
        this.authenticateService = authenticateService;
        this.accountService = accountService;
        this.customerService = customerService;
    }

    public MenuAccessController getMenuAccessController() {
        return menuAccessController;
    }

    public AuthenticateService getAuthenticateService() {
        return authenticateService;
    }

    public AccountService getAccountService() {
        return accountService;
    }

    public CustomerService getCustomerService() {
        return customerService;
    }
}





