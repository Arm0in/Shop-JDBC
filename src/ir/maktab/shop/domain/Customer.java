package ir.maktab.shop.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Customer extends User {
    private BigDecimal balance;

    public Customer() {
    }

    public Customer(String userName, String password, String nationalCode, LocalDate birthday, boolean status, BigDecimal balance) {
        super(userName, password, nationalCode, birthday, status);
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Customer[" +
                super.toString() +
                "balance=" + balance +
                ']';
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
