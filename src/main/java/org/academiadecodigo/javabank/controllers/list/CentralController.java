package org.academiadecodigo.javabank.controllers.list;

import org.academiadecodigo.javabank.Services.serviceClasses.AuthenticateService;
import org.academiadecodigo.javabank.controllers.controlerGadgets.Controller;
import org.academiadecodigo.javabank.controllers.controlerGadgets.ControllerFactory;
import org.academiadecodigo.javabank.controllers.controlerGadgets.ControllerType;
import org.academiadecodigo.javabank.domain.Customer;


public class CentralController implements Controller {

    private AuthenticateService authenticateService;
    private MenuAccessController menuAccessController;
    private ControllerFactory controllerFactory;




    public void start(){
        if (authenticateService.getLoggedInCustomer() == null){
            AbstractController logIn = controllerFactory.create(ControllerType.LOGIN);
            logIn.start();

        }
        if(authenticateService.getLoggedInCustomer().getAccounts().size() == 0){
            System.out.println("You need an account to be a customer here!");
            Controller createAccount = controllerFactory.create(ControllerType.OPENACCOUNT);
            createAccount.start();
        }


        Controller main = controllerFactory.create(ControllerType.MAIN);
        main.start();
    }

    public Customer getCustomer(){
        return authenticateService.getLoggedInCustomer();
    }



    public MenuAccessController getMenuAccessController() {
        return menuAccessController;
    }

    public void setAuthenticateService(AuthenticateService authenticateService) {
        this.authenticateService = authenticateService;
    }

    public void setMenuAccessController(MenuAccessController menuAccessController) {
        this.menuAccessController = menuAccessController;
    }

    public void setControllerFactory(ControllerFactory controllerFactory) {
        this.controllerFactory = controllerFactory;
    }
}
