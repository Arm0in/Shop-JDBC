package ir.maktab.shop.domain;

import ir.maktab.shop.base.domain.BaseEntity;

public class Item extends BaseEntity<Integer> {
    private Product product;
    private int quantity;

    public Item(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartItem[" +
                "product=" + product.getName() +
                ", quantity=" + quantity +
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
}
