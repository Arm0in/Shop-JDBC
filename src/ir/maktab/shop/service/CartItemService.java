package ir.maktab.shop.service;

import ir.maktab.shop.base.service.BaseService;
import ir.maktab.shop.domain.Cart;
import ir.maktab.shop.domain.CartItem;

import java.util.List;

public interface CartItemService extends BaseService<CartItem, Integer> {
    List<CartItem> getCartItems(Cart cart);
}
