package ir.maktab.shop.domain;

import ir.maktab.shop.base.domain.BaseEntity;

public class CartItem extends BaseEntity<Integer> {
    private Product product;
    private int quantity;
    private int orderId;

    public CartItem() {
    }

    public CartItem(Product product, int quantity, int orderId) {
        this.product = product;
        this.quantity = quantity;
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "CartItem[" +
                "product=" + product.getName() +
                ", quantity=" + quantity +
                ", orderId=" + orderId +
                ']';
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

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
