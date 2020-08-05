package org.academiadecodigo.javabank.controllers.list;

import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.userInterface.OperationType;
import org.academiadecodigo.javabank.userInterface.Request;

public class LogInController extends AbstractController {



    public LogInController(MenuAccessController menuAccessController) {
        super(menuAccessController);
    }


    @Override
    public void start() {

        Request request = super.getMenuAccessController().logIn();
        OperationType operationType = request.getOperationType();

        switch (operationType){

            case NEWCUSTOMER -> {
                String name = request.getName();
                Customer customer =new Customer(name);
                getMenuAccessController().getCustomerService().add(customer);
                getMenuAccessController().getAuthenticateService().authenticate(customer.getCustomerId());

            }
            default -> {
                Customer customer = request.getCustomer();
                getMenuAccessController().getAuthenticateService().authenticate(customer.getCustomerId());
            }
        }
    }
}
