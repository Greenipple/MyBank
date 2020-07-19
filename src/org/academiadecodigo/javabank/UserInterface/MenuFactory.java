package org.academiadecodigo.javabank.UserInterface;

import org.academiadecodigo.javabank.UserInterface.Menus.*;
import org.academiadecodigo.javabank.UserInterface.Menus.MenuTypes.MainOptionsType;
import org.academiadecodigo.javabank.UserInterface.Menus.MenuTypes.MenuType;


public class MenuFactory {
    public static MyMenu create(MenuType type, UserInterface userInterface){


        switch (type){
            case WELCOME -> {
                return new WelcomeMenu(userInterface);
            }

            case NEWCUSTOMER -> {
                return new NewCustomerMenu(userInterface);
            }

            case OPENACCOUNT -> {
                return new OpenAccountMenu(userInterface);
            }

            case WHICHACCOUNT -> {
                return new WhichAccountMenu(userInterface);
            }

            default -> {
                return new MainMenu(userInterface){};
            }
        }
    }

    //Main menu only:
    public static MyMenu create(MainOptionsType type,UserInterface userInterface){
        switch (type){
            case BALANCE -> {
                return new BalanceMenu(userInterface);
            }

            case DEPOSIT -> {
                return new DepositMenu(userInterface);
            }

            case WITHDRAWAL ->{
                return new WithdrawalMenu(userInterface);
            }
            default -> {
                return new OpenAccountMenu(userInterface);
            }
        }


    }


}
