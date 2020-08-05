package org.academiadecodigo.javabank.controllers.controlerGadgets;

import org.academiadecodigo.javabank.Services.serviceClasses.AccountService;
import org.academiadecodigo.javabank.Services.serviceClasses.AuthenticateService;
import org.academiadecodigo.javabank.Services.serviceClasses.CustomerService;
import org.academiadecodigo.javabank.controllers.list.*;

public class ControllerFactory {

    private MenuAccessController menuAccessController;
    private AccountService accountService;
    private AuthenticateService authenticateService;
    private CustomerService customerService;

    public AbstractController create(ControllerType type){

        switch (type){
            case LOGIN -> {
                return new LogInController(menuAccessController);
            }
            case OPENACCOUNT -> {
                OpenAccountController openAccountController= new OpenAccountController(menuAccessController);
                openAccountController.setServices(authenticateService,accountService,customerService);
                return openAccountController;
            }

            case MAIN -> {
                MainMenuController mainMenuController = new MainMenuController(menuAccessController);
                mainMenuController.setControllerFactory(this);
                mainMenuController.setServices(authenticateService,accountService,customerService);
                return mainMenuController;
            }

            default -> {
                return new LogInController(menuAccessController);
            }
        }
    }

    public void setMenuAccessController(MenuAccessController menuAccessController) {
        this.menuAccessController = menuAccessController;
    }

    public void setControllers(AccountService accountService,
                               AuthenticateService authenticateService,
                               CustomerService customerService){
        this.accountService = accountService;
        this.authenticateService = authenticateService;
        this.customerService = customerService;
    }
}
