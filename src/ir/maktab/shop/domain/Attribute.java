package ir.maktab.shop.domain;

import ir.maktab.shop.base.domain.BaseEntity;

public class Attribute extends BaseEntity<Integer> {
    private String attributeName;
    private String attributeValue;

    public Attribute() {
    }

    public Attribute(String attributeName, String attributeValue) {
        this.attributeName = attributeName;
        this.attributeValue = attributeValue;
    }

    @Override
    public String toString() {
        return "Attribute{" +
                "attributeName='" + attributeName + '\'' +
                ", attributeValue='" + attributeValue + '\'' +
                '}';
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
    }
}
