package org.academiadecodigo.javabank.userInterface.menus;


import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.bootcamp.scanners.precisiondouble.DoubleInputScanner;
import org.academiadecodigo.bootcamp.scanners.precisiondouble.DoubleRangeInputScanner;
import org.academiadecodigo.javabank.userInterface.UserInterface;
import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.domain.account.AccountType;
import org.academiadecodigo.javabank.domain.account.SavingsAccount;



public class OpenAccountMenu implements MyMenu {


    private UserInterface userInterface;
    private Customer customer;



    public OpenAccountMenu(UserInterface userInterface){
        this.userInterface = userInterface;
        this.customer = userInterface.getAccountOwner();
    }

    public void start(){

          String[] options = {"Checking", "Savings", "Go back"};
        MenuInputScanner whatKind = new MenuInputScanner(options);
        whatKind.setMessage("What kind of account would you like to open?");


        System.out.println(customer.getName());

        int answer = prompt.getUserInput(whatKind);

        switch (answer){
            case 1 ->{
                customer.openAccount(AccountType.CHECKING);
            }

            case 2 -> {
                double amountToStart = askForMin();
                int accountId = customer.openAccount(AccountType.SAVINGS);
                customer.deposit(accountId,amountToStart);
            }

            case 3 ->{
                userInterface.startMenu();
            }
        }
    }
    public double askForMin(){
        double min = SavingsAccount.getMinBalance();
        DoubleInputScanner amount = new DoubleRangeInputScanner(min,Double.POSITIVE_INFINITY);
        amount.setMessage("You need to make a minimum deposit of " + min + " potatoes.\n" +
                "How much would you like to deposit?");

        return prompt.getUserInput(amount);
    }
}
