package ir.maktab.shop.base.domain;

public class BaseEntity<ID> {

    private ID id;
    private boolean isDeleted;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
