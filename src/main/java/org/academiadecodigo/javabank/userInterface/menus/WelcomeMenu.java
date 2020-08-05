package org.academiadecodigo.javabank.userInterface.menus;

import org.academiadecodigo.javabank.userInterface.OperationType;
import org.academiadecodigo.javabank.userInterface.Request;
import org.academiadecodigo.javabank.userInterface.menus.menuTypes.MenuType;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerSetInputScanner;
import org.academiadecodigo.javabank.userInterface.UserInterface;
import org.academiadecodigo.javabank.domain.Customer;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WelcomeMenu implements MyMenu {

    UserInterface userInterface;



    public WelcomeMenu(UserInterface userInterface){
        this.userInterface = userInterface;
    }



    public void start(){


        List<Customer> customers = userInterface.getCustomerList();
        int logId;


        //Create HashSet of client numbers:
        Set<Integer> clientIds= new HashSet<>();
        clientIds.add(0);
        for(Customer customer : customers){
            clientIds.add(customer.getCustomerId());
        }


        IntegerSetInputScanner askIdClient = new IntegerSetInputScanner(clientIds);
        askIdClient.setMessage("Please insert your customer number. \nInsert 0 to input a new client");
        askIdClient.setError("That is not a valid account number");

        logId = MyMenu.prompt.getUserInput(askIdClient);

        if(logId == 0){
          MyMenu newCustomer = MenuFactory.create(MenuType.NEWCUSTOMER,userInterface);
          newCustomer.start();

        }else{

            for(Customer customer: customers){
                if(customer.getCustomerId() == logId){

                    Request request = new Request();

                    request.setCustomer(customer);
                    request.setOperationType(OperationType.LOGIN);

                    userInterface.setRequest(request);

                    System.out.println("Welcome " + customer.getName());
                    return;
                }
            }

        }
    }
}
