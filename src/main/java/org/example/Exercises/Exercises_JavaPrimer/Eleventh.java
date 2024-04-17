package org.example.Exercises.Exercises_JavaPrimer;

public class Eleventh {
}

/**
 * A simple model for a consumer credit card.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 * @author cris6h16
 */
class CreditCard {

    private String customer;
    private String bank;
    private String account;
    private int limit;
    private double balance;

    /**
     * Construct a new credit card instance.
     *
     * @param customer the name of the customer (e.g., "John Bowman")
     * @param bank     the name of the bank (e.g., "California Savings")
     * @param account  the account identifier (e.g., "5391 0375 9387 5309")
     * @param limit    teh credit card limit (measured in dollars)
     */
    public CreditCard(String customer, String bank, String account, int limit, double balance) {
        this.customer = customer;
        this.bank = bank;
        this.account = account;
        this.limit = limit;
        this.balance = balance;
    }

    /**
     * Charges the given price to the card, sufficient credit limit.
     *
     * @param price the amount to be charged
     * @return {@code true} if charge was accepted, {@code false} if charge was denied
     */
    public boolean charge(double price) {
        if (price + balance > limit) return false;

        balance += price;
        return true;
    }

    /**
     * Process customer payment that reduces balance.
     *
     * @param amount the amount of payment made
     */
    public void makePayment(double amount) {
        balance -= amount;
    }

    /**
     * Update the credit limits
     * @param newLimit it'll be the new limit
     * @return {@code true} if was set, {@code false} otherwise
     */
    public boolean updateCreditLimit(int newLimit) {
        if (limit < 0) return false;
        this.limit = newLimit;
        return true;
    }
}
