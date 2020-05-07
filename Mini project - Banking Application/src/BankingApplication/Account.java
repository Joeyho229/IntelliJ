package BankingApplication;

import java.util.Date;

public class Account {

    private int ID;
    private String firstName;
    private double balance;
    private String lastName;
    private Date dateCreated;

    public Account(int ID){
        this.ID = ID;
        this.dateCreated = new Date();
    }

    protected int getID(){
        return this.ID;
    }

    protected void setFirstName(String name){
        this.firstName = name;
    }

    protected String getFirstName(){
        return this.firstName;
    }

    protected void setLastName(String name){
        this.lastName = name;
    }

    protected String getLastName(){
        return this.lastName;
    }

    protected void setBalance(double balance){
        this.balance = balance;
    }

    protected double getBalance(){
        return this.balance;
    }

    protected void withdraw(double amount){
        this.balance = balance - amount;
    }

    protected void deposit(double amount){
        this.balance = balance + amount;
    }

    protected Date getDateCreated(){
        return this.dateCreated;
    }

}
