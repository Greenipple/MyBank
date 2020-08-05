package org.academiadecodigo.javabank.controllers.list;

import org.academiadecodigo.javabank.controllers.controlerGadgets.ControllerFactory;
import org.academiadecodigo.javabank.controllers.controlerGadgets.ControllerType;
import org.academiadecodigo.javabank.userInterface.OperationType;
import org.academiadecodigo.javabank.userInterface.Request;

public class MainMenuController extends AbstractController {

    private ControllerFactory controllerFactory;


    public MainMenuController(MenuAccessController menuAccessController) {
        super(menuAccessController);
    }

    @Override
    public void start() {

        Request request = getMenuAccessController().mainMenuInputs();
        OperationType operationType = request.getOperationType();

        switch(operationType){
            case DEPOSIT -> {
                int accountId = request.getAccountId();
                double amount = request.getAmount();
                getMenuAccessController().getAccountService().deposit(accountId,amount);
            }

            case WITHDRAWAL -> {
                int accountId = request.getAccountId();
                double amount = request.getAmount();
                getMenuAccessController().getAccountService().withdraw(accountId,amount);
            }

            case LOGOFF -> {
                getAuthenticateService().logOff();
            }

            case BALANCE -> {
                return;
            }

            default -> {
                AbstractController openAccountController = controllerFactory.create(ControllerType.OPENACCOUNT);
                ((OpenAccountController) openAccountController).setRequest(request);
                openAccountController.start();
            }
        }
    }

    public void setControllerFactory(ControllerFactory controllerFactory) {
        this.controllerFactory = controllerFactory;
    }
}
