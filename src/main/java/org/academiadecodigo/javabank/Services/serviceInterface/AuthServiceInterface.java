package org.academiadecodigo.javabank.Services.serviceInterface;

import org.academiadecodigo.javabank.domain.Customer;

public interface AuthServiceInterface {

    boolean authenticate(Integer id);
    Customer getLoggedInCustomer();
}
