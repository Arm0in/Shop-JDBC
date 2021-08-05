package ir.maktab.shop.service;

import ir.maktab.shop.base.service.BaseService;
import ir.maktab.shop.domain.Cart;
import ir.maktab.shop.domain.Customer;

public interface CartService extends BaseService<Cart, Integer> {
    Cart createCart(Customer customer);
    Cart getCustomerCart(Customer customer);
}
