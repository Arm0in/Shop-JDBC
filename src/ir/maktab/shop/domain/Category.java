package ir.maktab.shop.domain;

import ir.maktab.shop.base.domain.BaseEntity;

public class Category extends BaseEntity<Integer> {
    private String title;
    private String description;

    public Category() {
    }

    public Category(String title, String description) {
        this.title = title;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Category[" +
                "id=" + super.getId() +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ']';
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
