package com.company;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import  java.sql.Connection;
public class Main {

    public static void main(String[] args) {

        Trial trial = new Trial();
        trial.trialFunction();

        Scanner scanner = new Scanner(System.in);
        DataBase dataBase = new DataBase();
        System.out.println("Sign up");
        String username = scanner.nextLine();
        String password = scanner.nextLine();
        Account account = new Account(username,password);
        User client = new User(account);
        dataBase.SignUp(client);
        dataBase.printUsers();
    }
}
