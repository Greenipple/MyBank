package org.academiadecodigo.javabank.domain.account;

/**
 * The possible {@link Account} types
 */
public enum AccountType {

    /**
     * @see CheckingAccount
     */
    CHECKING("checking"),

    /**
     * @see SavingsAccount
     */
    SAVINGS("savings");

    private String lowerCase;

    AccountType(String lowerCase) {
        this.lowerCase = lowerCase;
    }
    public String getString(){
        return lowerCase;
    }
}
