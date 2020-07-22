package org.academiadecodigo.javabank.controllers.list;

import org.academiadecodigo.javabank.controllers.controlerGadgets.Controller;
import org.academiadecodigo.javabank.domain.Bank;
import org.academiadecodigo.javabank.managers.AccountManager;

public abstract class AbstractController implements Controller {

    private Bank bank;
    private AccountManager accountManager;
    private CentralController centralController;
    private MenuAccessController menuAccessController;



    public AbstractController(Bank bank){
        this.bank = bank;
        this.accountManager = bank.getAccountManager();
        this.centralController = bank.getCentralController();
        this.menuAccessController = centralController.getMenuAccessController();
    }

    public Bank getBank(){
        return bank;
    }

    public AccountManager getAccountManager() {
        return accountManager;
    }

    public CentralController centralController(){
        return centralController;
    }

    public MenuAccessController getMenuAccessController() {
        return menuAccessController;
    }
}
