package ir.maktab.shop.service.impl;

import ir.maktab.shop.base.service.impl.BaseServiceImpl;
import ir.maktab.shop.domain.CartItem;
import ir.maktab.shop.repository.CartItemRepository;
import ir.maktab.shop.service.CartItemService;

public class CartItemServiceImpl extends BaseServiceImpl<CartItem, Integer, CartItemRepository> implements CartItemService {
    public CartItemServiceImpl(CartItemRepository repository) {
        super(repository);
    }
}
