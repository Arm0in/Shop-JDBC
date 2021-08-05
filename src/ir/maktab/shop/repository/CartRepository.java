package ir.maktab.shop.repository;

import ir.maktab.shop.base.repository.BaseRepository;
import ir.maktab.shop.domain.Cart;
import ir.maktab.shop.domain.Customer;

public interface CartRepository extends BaseRepository<Cart, Integer> {
    public Cart findCustomerCart(Customer customer);
}
