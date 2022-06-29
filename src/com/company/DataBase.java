package com.company;

import java.util.ArrayList;

public class DataBase {
    private ArrayList<User> users;
    private ArrayList<Item> items;
    public DataBase (){
        this.users = new ArrayList<>();
        this.items = new ArrayList<>();
    }
    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setClients(ArrayList<User> clients) {
        this.users = clients;
    }
    public void SignUp(User user){
        if (!CheckUserName(user.getAccount().getUsername())){
            System.out.println("This username is taken");
            return;
        }
        this.users.add(user);
        System.out.println("Account Created");
    }

    public boolean CheckUserName(String username){
        for (User user : users){
            if (user.getAccount().getUsername().equals(username)){
                return false;
            }
        }
        return true;
    }
    public void printUsers(){
        int i = 1;
        for (User x : users){
            System.out.println(
                    "Client "+(i++) + "   Username: "+ x.getAccount().getUsername()
                    + "   Password: "+ x.getAccount().getPassword()
            );
        }
    }
}
