package org.academiadecodigo.javabank.Services.serviceInterface;

import org.academiadecodigo.javabank.domain.Customer;

import java.util.List;
import java.util.Set;

public interface CustomerServiceInterface {

    Customer get(Integer id);
    List<Customer> list();
    Set<Integer> listCustomerAccountIds(Integer id);
    double getBalance(int customerId);
    void add (Customer customer);
}
