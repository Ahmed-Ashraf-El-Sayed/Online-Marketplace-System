package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);
        DataBase dataBase = new DataBase();
        System.out.println("Sign up");
        String username = scanner.nextLine();
        String password = scanner.nextLine();
        Account account = new Account(username,password);
        Client client = new Client(account);
        dataBase.SignUp(client);
        dataBase.printUsers();
    }
}
