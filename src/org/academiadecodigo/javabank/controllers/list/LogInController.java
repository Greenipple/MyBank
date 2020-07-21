package org.academiadecodigo.javabank.controllers.list;

import org.academiadecodigo.javabank.controllers.AbstractController;
import org.academiadecodigo.javabank.controllers.CentralController;
import org.academiadecodigo.javabank.domain.Bank;
import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.userInterface.OperationType;
import org.academiadecodigo.javabank.userInterface.Request;
import org.academiadecodigo.javabank.userInterface.menus.MyMenu;

public class LogInController extends AbstractController {



    public LogInController(Bank bank) {
        super(bank);
    }

    @Override
    public void start() {

        Request request = getMenuAccessController().logIn();
        OperationType operationType = request.getOperationType();
        switch (operationType){
            case NEWCUSTOMER -> {
                String name = request.getName();
                Customer customer =new Customer(name);
                getBank().addCustomer(customer);
                centralController().setCustomer(customer);

            }
            default -> {
                Customer customer = request.getCustomer();
                centralController().setCustomer(customer);
            }
        }



        /*Customer customer =  getMenuAccessController().logIn();

        if(!getBank().getCustomers().contains(customer)) {
            getBank().addCustomer(customer);
        }

        getBank().getCentralController().setCustomer(customer);*/

    }
}
