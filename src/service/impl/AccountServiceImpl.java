package service.impl;

import model.BankAccount;
import model.Customer;
import service.AccountService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AccountServiceImpl implements AccountService {
    private BankAccount account;
    private final Map<String,BankAccount> accounts;
    private static AccountServiceImpl INSTANCE;
    private AccountServiceImpl() {
        this.accounts = new HashMap<>();
    }
    public static AccountServiceImpl getInstance(){
        if(INSTANCE == null){
            INSTANCE = new AccountServiceImpl();
        }
        return INSTANCE;
    }


    @Override
    public BigDecimal checkAccountBalance(String accountNumber) {
        BankAccount account = accounts.get(accountNumber);
        if(account != null && account.getAccountId().equals(accountNumber)){
            return account.getBalance();
        }
        return null;
    }

    @Override
    public boolean transferFunds(String fromAccountNumber, String toAccountNumber, BigDecimal amount) {
        if(amount.compareTo(BigDecimal.valueOf(0.0)) > 0){         //checks if the amount to be transferred is a positive value
            if(checkAccountBalance(fromAccountNumber).compareTo(amount) > 0){     //checks if the there is enough money to be transferred
                accounts.get(fromAccountNumber).debit(amount);
                accounts.get(toAccountNumber).credit(amount);
                return true;
            }
        }
        return false;
    }

    @Override
    public BankAccount createAccount(Customer customer, BankAccount account) {
        BankAccount newAccount = new BankAccount(customer.getUserId(), account.getBalance());
        accounts.put(customer.getUserId(), newAccount);
        return newAccount;
    }
}
