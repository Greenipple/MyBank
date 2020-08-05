package org.academiadecodigo.javabank.userInterface.menus;

import org.academiadecodigo.javabank.userInterface.OperationType;
import org.academiadecodigo.javabank.userInterface.Request;

import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
import org.academiadecodigo.javabank.userInterface.UserInterface;

class NewCustomerMenu implements MyMenu {

    private UserInterface userInterface;

    public NewCustomerMenu(UserInterface userInterface){
        this.userInterface = userInterface;
    }
    public void start() {

        StringInputScanner askName = new StringInputScanner();
        askName.setMessage("What is your name? \nType '\\Exit' to eject");


        String name = prompt.getUserInput(askName);


        if(name.equals("\\Exit")){
            System.out.println("Ejecting.....");
            System.exit(0);
        }

        Request request = new Request();
        request.setName(name);
        request.setOperationType(OperationType.NEWCUSTOMER);
        userInterface.setRequest(request);

        System.out.println("Welcome to JavaR Dola$ Bank, " + name);

    }
}
