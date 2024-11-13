
package model;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    private final List<BankAccount> accounts;
    public Customer(String userId, String name, String email, String password) {
        super(userId, name, email, password, Role.CUSTOMER);
        accounts = new ArrayList<>();
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }
}