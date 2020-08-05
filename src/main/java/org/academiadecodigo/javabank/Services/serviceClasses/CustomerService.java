package org.academiadecodigo.javabank.Services.serviceClasses;

import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.domain.account.Account;

import java.util.*;

public class CustomerService implements org.academiadecodigo.javabank.Services.serviceInterface.CustomerServiceInterface {


    private HashMap<Integer, Customer> customerList;
    private AuthenticateService authenticateService;
    private AccountService accountService;

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
        HashSet<Account> accountList = customerList.get(id).getAccounts();

        for (Account account : accountList) {
            accountIds.add(account.getId());
        }

        return accountIds;
    }

    @Override
    public double getBalance(int customerId) {

        HashSet<Account> accounts = customerList.get(customerId).getAccounts();
        double balance = 0;
        for(Account account : accounts){
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
        customer.setAccountService(accountService);
        customer.setCustomerId(getNextId());
        customerList.put(customer.getCustomerId(),customer);

    }
    public void setAuthenticateService(AuthenticateService authenticateService){
        this.authenticateService = authenticateService;
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    /*public HashMap<Integer, Customer> getCustomersList(){
        return customerList;
    }*/

}
