package ir.maktab.shop.service.impl;

import ir.maktab.shop.base.service.impl.BaseServiceImpl;
import ir.maktab.shop.domain.Cart;
import ir.maktab.shop.domain.Customer;
import ir.maktab.shop.repository.CartRepository;
import ir.maktab.shop.service.CartService;

import java.time.LocalDate;

public class CartServiceImpl extends BaseServiceImpl<Cart, Integer, CartRepository> implements CartService {
    public CartServiceImpl(CartRepository repository) {
        super(repository);
    }

    @Override
    public Cart createCart(Customer customer) {
        Cart cart = new Cart();
        cart.setCustomer(customer);
        cart.setCreateDate(LocalDate.now());
        return save(cart);
    }

    @Override
    public Cart getCustomerCart(Customer customer) {
        return repository.findCustomerCart(customer);
    }
}
