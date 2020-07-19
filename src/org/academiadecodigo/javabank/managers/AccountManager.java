package org.academiadecodigo.javabank.managers;

import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.domain.account.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Responsible for account management
 */
public class AccountManager {

    private static int numberAccounts = 0;
    private Map<Integer, Account> accountMap;

    /**
     * Creates a new {@code AccountManager}
     */
    public AccountManager() {
        this.accountMap = new HashMap<>();
    }

    /**
     * Creates a new {@link Account}
     *
     * @param accountType the account type
     * @return the new account
     */
    public Account openAccount(AccountType accountType) {

        Account newAccount;
        numberAccounts++;

        if (accountType == AccountType.CHECKING) {
            newAccount = new CheckingAccount(numberAccounts);
            System.out.println("You have opened a new checking account with the number " + numberAccounts);

        } else {
            newAccount = new SavingsAccount(numberAccounts);
            System.out.println("You have opened a new savings account with the number " + numberAccounts);
        }

        accountMap.put(newAccount.getId(), newAccount);
        return newAccount;
    }

    public Account openAccount(AccountType accountType, Customer customer) {

        Account newAccount;
        numberAccounts++;

        newAccount = AccountFactory.create(accountType,numberAccounts,customer);

        System.out.println (customer.getName() +" has opened a new " + accountType.getString()
                + " account with the number " + numberAccounts);

        accountMap.put(newAccount.getId(), newAccount);
        return newAccount;
    }

    /**
     * Perform an {@link Account} deposit if possible
     *
     * @param id     the id of the account
     * @param amount the amount to deposit
     */
    public void deposit(int id, double amount) {
        accountMap.get(id).credit(amount);
    }

    /**
     * Perform an {@link Account} withdrawal if possible
     *
     * @param id     the id of the account
     * @param amount the amount to withdraw
     */
    public boolean withdraw(int id, double amount) {

        Account account = accountMap.get(id);

        if (!account.canWithdraw(amount)) {
            return false;
        }

        accountMap.get(id).debit(amount);
        return true;
    }

    /**
     * Performs a transfer between two {@link Account} if possible
     *
     * @param srcId  the source account id
     * @param dstId  the destination account id
     * @param amount the amount to transfer
     */
    public void transfer(int srcId, int dstId, double amount) {

        Account srcAccount = accountMap.get(srcId);
        Account dstAccount = accountMap.get(dstId);

        // make sure transaction can be performed
        if (srcAccount.canDebit(amount) && dstAccount.canCredit(amount)) {
            srcAccount.debit(amount);
            dstAccount.credit(amount);
        }
    }

    public Map getAccountMap(){
        return this.accountMap;
    }
}
