package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Account {
    private String name;
    private int number;
    private String type;
    private double balance;
    private String creationDate;

    public Account() {
    }

    public Account(String name, int number, String type, double balance) {
        this.name = name;
        this.number = number;
        this.type = type;
        this.balance = balance;
        this.creationDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", type='" + type + '\'' +
                ", balance=" + balance +
                ", creationDate='" + creationDate + '\'' +
                '}';
    }
}
