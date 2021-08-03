package ir.maktab.shop.domain;

import ir.maktab.shop.base.domain.BaseEntity;

import java.time.LocalDate;

public class User extends BaseEntity<Integer> {
    private String userName;
    private String password;
    private String nationalCode;
    private LocalDate birthday;
    private boolean status;

    public User() {
    }

    public User(String userName, String password, String nationalCode, LocalDate birthday, boolean status) {
        this.userName = userName;
        this.password = password;
        this.nationalCode = nationalCode;
        this.birthday = birthday;
        this.status = status;
    }

    @Override
    public String toString() {
        return "User[" +
                "id= " + getId() +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", nationalCode='" + nationalCode + '\'' +
                ", birthday=" + birthday +
                ", status=" + status +
                ']';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
