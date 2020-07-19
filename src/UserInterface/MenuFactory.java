package UserInterface;

import UserInterface.Menus.MenuTypes.MainOptionsType;
import UserInterface.Menus.MenuTypes.MenuType;


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
