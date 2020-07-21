package org.academiadecodigo.javabank.userInterface.menus;

import org.academiadecodigo.javabank.userInterface.OperationType;
import org.academiadecodigo.javabank.userInterface.Request;
import org.academiadecodigo.javabank.userInterface.menus.menuTypes.MenuType;

import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
import org.academiadecodigo.javabank.userInterface.UserInterface;
import org.academiadecodigo.javabank.domain.Bank;
import org.academiadecodigo.javabank.domain.Customer;

class NewCustomerMenu implements MyMenu {

    private UserInterface userInterface;
    private Bank bank;
    private Customer customer;

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

        bank = userInterface.getBank();
        //customer = new Customer(name);
        //bank.addCustomer(customer);
        //userInterface.setAccountOwner(customer);

        System.out.println("Welcome to JavaR Dola Bank, " + name);

        //MyMenu openAccount = MenuFactory.create(MenuType.OPENACCOUNT,userInterface);
        //openAccount.start();


    }
}
