package com.company;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class GUIMethods {
    Scanner scanner = new Scanner(System.in);
    DataBase dataBase = DataBase.getInstance();
    Server server = Server.getInstance();
    public void SignUp() throws IOException {
        //server.dataBase.printUsers();
        System.out.println("Enter username ");
        String username = scanner.nextLine();
        System.out.println("Enter Password");
        String password = scanner.nextLine();
        // This should be by gui
        Account account = new Account(username,password);
        Client client = new Client(account);
        server.dataBase.SignUp(client);
        //server.dataBase.printUsers();
    }
    public void SignIn() throws IOException {
        System.out.println("Enter username ");
        String username = scanner.nextLine();
        System.out.println("Enter Password");
        String password = scanner.nextLine();
        Account account = new Account(username,password);
        Client client = new Client(account);
        if(server.dataBase.SignIn(client)){
            //Should go to next state
            System.out.println("Tmam");
        }
        else {
            System.out.println("Invalid Credentials");
        }
    }
    public void ShowItems(){
        server.dataBase.printItems();
    }
    public void Search(String s){
        s = s.toLowerCase();
        s = s.substring(0, 1).toUpperCase() + s.substring(1);
        for (Item x : server.dataBase.getItems()){
            if (s.equals(x.getName())){
                //Should appear solo
            }
        }
    }



}
