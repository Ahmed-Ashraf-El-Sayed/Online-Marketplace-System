package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;
import java.sql.*;


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
        try {
            // url is jdbc:mysql://localhost:3306/{database name}   user is the user of the database on the machine password should be the same as well
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/marketplace", "root", "Root_password");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select username , password from person where username = '"+ this.getUsername() +"' and password = '"+this.getPassword()+"';");
            if(resultSet.next()){
            System.out.println("account verification passed");
            return true;
            }
            else{
                System.out.println("invalid account");
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("account disabled");
        return false;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        //this.username = username;
        String update = "update person set username = '"+username+"' where username = '"+this.username+"'";
        try {
            // url is jdbc:mysql://localhost:3306/{database name}   user is the user of the database on the machine password should be the same as well
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/marketplace", "root", "Root_password");
            Statement statement = connection.createStatement();
            statement.executeUpdate(update);
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        //this.password = password;
        String update = "update person set password = '"+password+"' where password = '"+this.password+"'";
        try {
            // url is jdbc:mysql://localhost:3306/{database name}   user is the user of the database on the machine password should be the same as well
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/marketplace", "root", "Root_password");
            Statement statement = connection.createStatement();
            statement.executeUpdate(update);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public double getCash() {
        try {
            // url is jdbc:mysql://localhost:3306/{database name}   user is the user of the database on the machine password should be the same as well
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/marketplace", "root", "Root_password");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select balance from person where username = '"+ this.getUsername()+"'");
            if (resultSet.next()){
                return resultSet.getDouble("balance");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public void setCash(double cash) {
        //this.cash = cash;
        String update = "update person set balance = "+cash+" where username = "+this.username;
        try {
            // url is jdbc:mysql://localhost:3306/{database name}   user is the user of the database on the machine password should be the same as well
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/marketplace", "root", "Root_password");
            Statement statement = connection.createStatement();
            statement.executeUpdate(update);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void AddMoney(double amount){
        /*if(this.VerifyAccount()){
            this.setCash(this.getCash()+amount);
        }*/
        //this sets the balance of the account or user
        String update = "update person set balance = balance +"+amount+"where username = username";
        try {
            // url is jdbc:mysql://localhost:3306/{database name}   user is the user of the database on the machine password should be the same as well
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/marketplace", "root", "Root_password");
            Statement statement = connection.createStatement();
            statement.executeUpdate(update);
        }catch (Exception e){
            e.printStackTrace();
        }
        /*else {
            System.out.println("Incorrect data");
        }*/
    }
    public void PayMoney(double amount){
        String update = "update person set balance = balance -"+amount+"where username = username";
        try {
            // url is jdbc:mysql://localhost:3306/{database name}   user is the user of the database on the machine password should be the same as well
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/marketplace", "root", "Root_password");
            Statement statement = connection.createStatement();
            statement.executeUpdate(update);
        }catch (Exception e) {
            e.printStackTrace();

        /*if(this.VerifyAccount()){
            this.setCash(this.getCash()-amount);
        }
        else {
            System.out.println("Incorrect data");
        }*/
        }
    }

}
