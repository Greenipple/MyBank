package UserInterface;

import UserInterface.Menus.MenuTypes.MenuType;
import UserInterface.MyMenu;
import UserInterface.UserInterface;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerSetInputScanner;
import org.academiadecodigo.javabank.domain.Bank;
import org.academiadecodigo.javabank.domain.Customer;

import java.util.HashSet;
import java.util.Set;

public class WelcomeMenu implements MyMenu {

    UserInterface userInterface;
    Bank bank;


    public WelcomeMenu(UserInterface userInterface){
        this.userInterface = userInterface;
        this.bank = userInterface.getBank();

    }

    public void start(){

        HashSet<Customer> customers = bank.getCustomers();
        int logId;
        Customer logCustomer;

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
                    logCustomer = customer;
                    userInterface.setAccountOwner(logCustomer);
                    System.out.println("Welcome " + customer.getName());
                    return;
                }
            }

        }
    }
}
