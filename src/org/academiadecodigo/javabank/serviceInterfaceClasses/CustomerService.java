package org.academiadecodigo.javabank.serviceInterfaceClasses;

import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.domain.account.Account;

import java.util.*;

public class CustomerService implements org.academiadecodigo.javabank.serviceInterface.CustomerService {


    private HashMap<Integer, Customer> customerList;
    private AuthenticateService authenticateService;

    public CustomerService() {
        customerList = new HashMap<>();
    }


    @Override
    public Customer get(Integer id) {
       return customerList.get(id);
    }

    @Override
    public List<Customer> list() {
       return new ArrayList<>(customerList.values());
    }

    @Override
    public Set<Integer> listCustomerAccountIds(Integer id) {
        Set<Integer> accountIds = new HashSet<>();
        HashMap<Integer,Account> accountList = customerList.get(id).getAccounts();

        for (Account account : accountList.values()) {
            accountIds.add(account.getId());
        }

        return accountIds;
    }

    @Override
    public double getBalance(int customerId) {

        HashMap<Integer,Account> accounts = customerList.get(customerId).getAccounts();
        double balance = 0;
        for(Account account : accounts.values()){
            balance += account.getBalance();
        }
        return balance;
    }

    private Integer getNextId(){

        int nextId = 1;

        if (!customerList.isEmpty()){
            for(Customer customer : customerList.values()){
                if (customerList.get(customer.getCustomerId()+1) == null){
                    nextId = customer.getCustomerId()+1;
                    break;
                }
            }
        }
        return nextId;
    }

    @Override
    public void add(Customer customer) {
      customer.setCustomerId(getNextId());
      customerList.put(customer.getCustomerId(),customer);

    }
    public void setAuthenticateService(AuthenticateService authenticateService){
        this.authenticateService = authenticateService;
    }

    /*public HashMap<Integer, Customer> getCustomersList(){
        return customerList;
    }*/

}
