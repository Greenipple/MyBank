package org.academiadecodigo.javabank.domain.account;

import org.academiadecodigo.javabank.domain.Customer;

/**
 * A checking account with no restrictions
 * @see Account
 * @see AccountType#CHECKING
 */
public class CheckingAccount extends Account {

    /**
     * Creates a new {@code CheckingAccount} instance
     *
     * @see Account#Account(int)
     */
    public CheckingAccount(int id, Customer accountOwner) {
        super(id);
        super.setAccountOwner(accountOwner);
    }

    /**
     * @see Account#getAccountType()
     */
    @Override
    public AccountType getAccountType() {
        return AccountType.CHECKING;
    }
}
