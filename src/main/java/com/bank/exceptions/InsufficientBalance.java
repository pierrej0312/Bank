package com.bank.exceptions;

import com.bank.models.accounts.Account;

public class InsufficientBalance extends RuntimeException {
    public InsufficientBalance(Account a, double n) {
        throw new IllegalArgumentException("Account " + a.getNumber() + "has insufficient balance: " + n);
    }
}
