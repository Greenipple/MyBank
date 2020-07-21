package org.academiadecodigo.javabank.controllers.controlerGadgets;

import org.academiadecodigo.javabank.controllers.list.LogInController;
import org.academiadecodigo.javabank.controllers.list.MainMenuController;
import org.academiadecodigo.javabank.controllers.list.OpenAccountController;
import org.academiadecodigo.javabank.domain.Bank;

public class ControllerFactory {
    public static Controller create(ControllerType type, Bank bank){

        switch (type){
            case LOGIN -> {
                return new LogInController(bank);
            }
            case OPENACCOUNT -> {
                return new OpenAccountController(bank);
            }

            case MAIN -> {
                return new MainMenuController(bank);
            }

            default -> {
                return new LogInController(bank);
            }
        }
    }
}
