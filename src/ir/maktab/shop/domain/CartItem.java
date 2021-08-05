package ir.maktab.shop.domain;

import ir.maktab.shop.base.domain.BaseEntity;

public class CartItem extends BaseEntity<Integer> {
    private Product product;
    private int quantity;
    private Cart cart;

    public CartItem() {
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "product=" + product +
                ", quantity=" + quantity +
                ", cart id=" + cart.getId() +
                '}';
    }

    public CartItem(Product product, int quantity, Cart cart) {
        this.product = product;
        this.quantity = quantity;
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
