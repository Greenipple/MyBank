package org.academiadecodigo.javabank.controllers.list;

import org.academiadecodigo.javabank.controllers.AbstractController;
import org.academiadecodigo.javabank.controllers.CentralController;
import org.academiadecodigo.javabank.domain.Bank;
import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.userInterface.menus.MyMenu;

public class LogInController extends AbstractController {



    public LogInController(Bank bank) {
        super(bank);
    }

    @Override
    public void start() {

        Customer customer =  getMenuAccessController().logIn();

        if(!getBank().getCustomers().contains(customer)) {
            getBank().addCustomer(customer);
        }

        getBank().getCentralController().setCustomer(customer);

    }
}
