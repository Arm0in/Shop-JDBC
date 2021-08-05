package ir.maktab.shop.service.impl;

import ir.maktab.shop.base.service.impl.BaseServiceImpl;
import ir.maktab.shop.domain.Cart;
import ir.maktab.shop.repository.CartRepository;
import ir.maktab.shop.service.CartService;

public class CartServiceImpl extends BaseServiceImpl<Cart, Integer, CartRepository> implements CartService {
    public CartServiceImpl(CartRepository repository) {
        super(repository);
    }
}
