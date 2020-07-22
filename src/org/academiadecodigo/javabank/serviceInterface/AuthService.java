package org.academiadecodigo.javabank.serviceInterface;

import org.academiadecodigo.javabank.domain.Customer;

public interface AuthService {

    boolean authenticate(Integer id);
    Customer getAccessingCustomer();
}
