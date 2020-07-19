package org.academiadecodigo.javabank.UserInterface.Menus;

import org.academiadecodigo.javabank.UserInterface.MenuFactory;
import org.academiadecodigo.javabank.UserInterface.Menus.MenuTypes.MenuType;

import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
import org.academiadecodigo.javabank.UserInterface.Menus.MyMenu;
import org.academiadecodigo.javabank.UserInterface.UserInterface;
import org.academiadecodigo.javabank.domain.Bank;
import org.academiadecodigo.javabank.domain.Customer;

public class NewCustomerMenu implements MyMenu {

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


        bank = userInterface.getBank();
        customer = new Customer(name);
        bank.addCustomer(customer);
        userInterface.setAccountOwner(customer);

        System.out.println("Welcome to JavaR Dola Bank, " + name);

        MyMenu openAccount = MenuFactory.create(MenuType.OPENACCOUNT,userInterface);
        openAccount.start();


    }
}
