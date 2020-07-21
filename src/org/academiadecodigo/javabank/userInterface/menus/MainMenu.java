package org.academiadecodigo.javabank.userInterface.menus;

import org.academiadecodigo.javabank.userInterface.OperationType;
import org.academiadecodigo.javabank.userInterface.Request;
import org.academiadecodigo.javabank.userInterface.menus.menuTypes.MainOptionsType;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.javabank.userInterface.UserInterface;

class MainMenu implements MyMenu {

    private UserInterface userInterface;
    private String name;

    public MainMenu(UserInterface userInterface){
        this.userInterface = userInterface;
        this.name = userInterface.getAccountOwner().getName();
    }

    public void start(){

        String[] options = {"Get balance", "Make a deposit",
                "Make a withdrawal", "Open an account", "Log off"};

        MenuInputScanner mainMenu = new MenuInputScanner(options);
        mainMenu.setMessage("What would you like to do, " + name + "?" );

        int answerIndex = MyMenu.prompt.getUserInput(mainMenu);
        MainOptionsType choice = MainOptionsType.values()[answerIndex-1];

        if (answerIndex == 5){
            System.out.println("logging off.....");
            Request request = new Request();
            request.setOperationType(OperationType.LOGOFF);
            userInterface.setRequest(request);
            userInterface.setAccountOwner(null);
            userInterface.setAccount(null);
            return;
        }

        MyMenu next = MenuFactory.create(choice,userInterface);
        next.start();

    }
}
