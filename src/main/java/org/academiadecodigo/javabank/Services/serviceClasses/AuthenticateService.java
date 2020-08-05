package org.academiadecodigo.javabank.Services.serviceClasses;

import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.Services.serviceInterface.AuthServiceInterface;

public class AuthenticateService implements AuthServiceInterface {


    private Customer loggedInCustomer;
    private CustomerService customerService;
   // private HashMap<Integer, Customer> customerList;



    @Override
    public boolean authenticate(Integer id) {
        loggedInCustomer = customerService.get(id);
        return loggedInCustomer != null;
    }

    @Override
    public Customer getLoggedInCustomer() {
        return loggedInCustomer;
    }

    public void logOff(){
        loggedInCustomer = null;
    }
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }
}
