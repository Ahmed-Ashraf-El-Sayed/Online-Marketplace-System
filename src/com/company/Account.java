package com.company;

import java.util.Objects;

public class Account {
    private String username;
    private String password;
    private double cash;
    public Account(String username, String password){
        this.username = username;
        this.password = password;
        this.cash = 0;
    }
    public boolean VerifyAccount(){
        String username=null , password=null; // Input
        return Objects.equals(this.getUsername(), username) && Objects.equals(this.getPassword(), password);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public void AddMoney(double amount){
        if(this.VerifyAccount()){
            this.setCash(this.getCash()+amount);
        }
        else {
            System.out.println("Incorrect data");
        }
    }

    public void PayMoney(double amount){
        if(this.VerifyAccount()){
            this.setCash(this.getCash()-amount);
        }
        else {
            System.out.println("Incorrect data");
        }
    }
}
