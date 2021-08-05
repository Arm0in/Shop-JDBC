package ir.maktab.shop.repository;

import ir.maktab.shop.base.repository.BaseRepository;
import ir.maktab.shop.domain.Cart;
import ir.maktab.shop.domain.CartItem;

import java.util.List;

public interface CartItemRepository extends BaseRepository<CartItem, Integer> {
    List<CartItem> findCartItems(Cart cart);
}
