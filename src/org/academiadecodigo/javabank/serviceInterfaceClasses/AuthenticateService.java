package org.academiadecodigo.javabank.serviceInterfaceClasses;

import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.serviceInterface.AuthService;

import java.util.HashMap;

public class AuthenticateService implements AuthService {


    private Customer loggedInCustomer;
    private CustomerService customerService;
   // private HashMap<Integer, Customer> customerList;


    public AuthenticateService(CustomerService customerService){
        this.customerService = customerService;
        //this.customerList = customerService.getCustomersList();
    }

    @Override
    public boolean authenticate(Integer id) {

        loggedInCustomer = customerService.get(id);
        return loggedInCustomer != null;
    }

    @Override
    public Customer getAccessingCustomer() {
        return loggedInCustomer;
    }
}
