package ir.maktab.shop.domain;

import ir.maktab.shop.base.domain.BaseEntity;

import java.time.LocalDate;

public class Order extends BaseEntity<Integer> {
    private Customer customer;
    private LocalDate orderDate;

    public Order(Customer customer, LocalDate orderDate) {
        this.customer = customer;
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Order[" +
                "id=" + super.getId() +
                ", customer=" + customer +
                ", orderDate=" + orderDate +
                ']';
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
}
