package services;

import models.Account;

public class AccountService {
    private Account account = new Account("UA1234567890", 1000.0);

    public Account getAccount() {
        return account;
    }

    public void deposit(double amount) {
        account.deposit(amount);
    }

    public boolean withdraw(double amount) {
        return account.withdraw(amount);
    }
}
