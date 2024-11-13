package model;

import java.math.BigDecimal;

public class BankAccount {
    private String accountId;
    private BigDecimal balance;

    public BankAccount(String accountId, BigDecimal balance) {
        this.accountId = accountId;
        this.balance = BigDecimal.valueOf(0.0);
    }

    public String getAccountId() {
        return accountId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void credit(BigDecimal amount) {this.balance = this.balance.add(amount);}
    public void debit(BigDecimal amount) {this.balance = this.balance.subtract(amount);}
}
