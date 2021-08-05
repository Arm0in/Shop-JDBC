package ir.maktab.shop.domain;

import ir.maktab.shop.base.domain.BaseEntity;

import java.time.LocalDate;

public class Cart extends BaseEntity<Integer> {
    private Customer customer;
    private LocalDate createDate;

    public Cart() {
    }

    public Cart(Customer customer, LocalDate createDate) {
        this.customer = customer;
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Cart[" +
                "id=" + super.getId() +
                ", customer=" + customer +
                ", createDate=" + createDate +
                ']';
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }
}
