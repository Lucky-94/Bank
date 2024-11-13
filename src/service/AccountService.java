package service;

import model.BankAccount;
import model.Customer;

import java.math.BigDecimal;

public interface AccountService {
    BigDecimal checkAccountBalance(String accountNumber);
    boolean transferFunds(String fromAccountNumber, String toAccountNumber, BigDecimal amount);

    BankAccount createAccount(Customer customer, BankAccount account);
}
