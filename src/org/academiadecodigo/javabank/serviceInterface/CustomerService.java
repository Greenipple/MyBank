package org.academiadecodigo.javabank.serviceInterface;

import org.academiadecodigo.javabank.domain.Customer;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public interface CustomerService {

    Customer get(Integer id);
    List<Customer> list();
    Set<Integer> listCustomerAccountIds(Integer id);
    double getBalance(int customerId);
    void add (Customer customer);
}
