package org.academiadecodigo.javabank.userInterface.menus;


import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.bootcamp.scanners.precisiondouble.DoubleInputScanner;
import org.academiadecodigo.bootcamp.scanners.precisiondouble.DoubleRangeInputScanner;
import org.academiadecodigo.javabank.userInterface.OperationType;
import org.academiadecodigo.javabank.userInterface.Request;
import org.academiadecodigo.javabank.userInterface.UserInterface;
import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.domain.account.AccountType;
import org.academiadecodigo.javabank.domain.account.SavingsAccount;



class OpenAccountMenu implements MyMenu {


    private UserInterface userInterface;
    private Customer customer;



    public OpenAccountMenu(UserInterface userInterface){
        this.userInterface = userInterface;
        this.customer = userInterface.getLoggedCustomer();
    }

    public void start(){

          String[] options = {"Checking", "Savings", "Go back"};
        MenuInputScanner whatKind = new MenuInputScanner(options);
        whatKind.setMessage("What kind of account would you like to open?");


        System.out.println(customer.getName());

        int answer = prompt.getUserInput(whatKind);

        switch (answer){
            case 1 ->{
                Request request = new Request();

                request.setOperationType(OperationType.OPENCHECKINGACCOUNT);
                userInterface.setRequest(request);
            }

            case 2 -> {
                double amountToStart = askForMin();

                Request request = new Request();

                request.setOperationType(OperationType.OPENSAVINGSACCOUNT);
                request.setAmount(amountToStart);

                userInterface.setRequest(request);
            }

            case 3 ->{
                return;
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
