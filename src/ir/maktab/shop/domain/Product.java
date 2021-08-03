package ir.maktab.shop.domain;

import ir.maktab.shop.base.domain.BaseEntity;

import java.math.BigDecimal;

public class Product extends BaseEntity<Integer> {
    private String name;
    private String brand;
    private String description;
    private BigDecimal price;
    private int stock;
    private Category category;


    public Product(int id, String name, String brand, String description, BigDecimal price, int stock, Category category) {
        super.setId(id);
        this.name = name;
        this.brand = brand;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product[" +
                "id=" + super.getId() +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", category=" + category.getTitle() +
                ']';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
