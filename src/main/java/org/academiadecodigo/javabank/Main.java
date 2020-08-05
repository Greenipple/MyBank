package org.academiadecodigo.javabank;


import org.academiadecodigo.javabank.Services.serviceClasses.AccountService;
import org.academiadecodigo.javabank.Services.serviceClasses.AuthenticateService;
import org.academiadecodigo.javabank.Services.serviceClasses.CustomerService;
import org.academiadecodigo.javabank.controllers.controlerGadgets.ControllerFactory;
import org.academiadecodigo.javabank.controllers.list.CentralController;
import org.academiadecodigo.javabank.controllers.list.MenuAccessController;
import org.academiadecodigo.javabank.domain.account.AccountFactory;

public class Main {



    public static void main(String[] args) {

        //Service section:
        AccountService accountService = new AccountService();
        CustomerService customerService = new CustomerService();
        AuthenticateService authenticateService = new AuthenticateService();

        customerService.setAuthenticateService(authenticateService);
        customerService.setAccountService(accountService);
        accountService.setAuthenticateService(authenticateService);
        authenticateService.setCustomerService(customerService);


        //Controllers section:
        CentralController centralController = new CentralController();
        MenuAccessController menuAccessController = new MenuAccessController();
        ControllerFactory controllerFactory = new ControllerFactory();
        //OpenAccountController openAccountController = new OpenAccountController();

        AccountFactory accountFactory = new AccountFactory();


        controllerFactory.setMenuAccessController(menuAccessController);
        controllerFactory.setControllers(accountService,authenticateService,customerService);
        menuAccessController.setCustomerService(customerService);
        menuAccessController.setAccountService(accountService);
        menuAccessController.setAuthenticateService(authenticateService);
        centralController.setAuthenticateService(authenticateService);
        centralController.setMenuAccessController(menuAccessController);
        centralController.setControllerFactory(controllerFactory);
        //openAccountController.setAccountFactory(accountFactory);






        while(true) {
            centralController.start();
        }

    }
}
