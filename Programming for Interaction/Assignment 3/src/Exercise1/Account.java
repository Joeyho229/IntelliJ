package Exercise1;

import java.util.Date;

public class Account {
    private int id = 0;
    private Date dateCreated;
    private double balance = 0.0;
    private double annualInterestRate;

    public Account() {
        this.dateCreated = new Date();
    }

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
        this.dateCreated = new Date();
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double annualInterestRate() {
        return this.annualInterestRate;
    }

    public void annualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public Date dateCreated() {
        return this.dateCreated;
    }

    public void dateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public double getMonthlyInterestRate() {
        return this.annualInterestRate / 12;
    }

    public double getMonthlyInterest() {
        return balance * (annualInterestRate / 1200);
    }

    public void withdraw(double amount) {
        this.balance = balance - amount;
    }

    public void deposit(double amount) {
        this.balance = balance + amount;
    }
    }