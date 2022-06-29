package com.company;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import  java.sql.Connection;
public class Main {

    public static void main(String[] args) {
	// write your code here
        /*try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/marketplace", "root", "Root_password");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from person");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("person_ID")+" " + resultSet.getString("first_name")+" "+ resultSet.getString("last_name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }*/
        trialDatabase trial = new trialDatabase();
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
