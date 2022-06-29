package com.company;

import java.util.ArrayList;

public class DataBase {
    private ArrayList<User> users;
    private ArrayList<Item> items;
    public DataBase (){
        this.users = new ArrayList<>();
    }
    public ArrayList<User> getUsers() {
        return users;
    }

    public void setClients(ArrayList<User> clients) {
        this.users = clients;
    }
    public void SignUp(User user){
        this.users.add(user);
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
