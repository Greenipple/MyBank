package org.academiadecodigo.javabank.domain;

import org.academiadecodigo.javabank.controllers.list.CentralController;
import org.academiadecodigo.javabank.managers.AccountManager;

import java.util.HashSet;

/**
 * The bank entity
 */
public class Bank {

    private AccountManager accountManager;
    private HashSet<Customer> customers = new HashSet<>();
    private static int numberCustomers = 0;

    private CentralController centralController;


    /**
     * Creates a new instance of Bank and initializes it with the given account manager
     *
     * @param accountManager the account manager
     */
    public Bank(AccountManager accountManager) {
        this.accountManager = accountManager;
        this.centralController = new CentralController(this,accountManager);
    }

    /**
     * Adds a new customer to the bank
     *
     * @param customer the new bank customer
     * @see Customer#setAccountManager(AccountManager)
     */
    public void addCustomer(Customer customer) {

        numberCustomers++;

        customer.setCustomerId(numberCustomers);
        customers.add(customer);
        customer.setAccountManager(accountManager);

    }

    /**
     * Gets the total balance of the bank
     *
     * @return the bank total balance
     */
    public double getBalance() {

        double balance = 0;

        for (Customer customer : customers) {
            balance += customer.getBalance();
        }

        return balance;
    }

    public HashSet getCustomers(){
        return customers;
    }

    public AccountManager getAccountManager(){
        return accountManager;
    }

    public CentralController getCentralController() {
        return centralController;
    }
}
