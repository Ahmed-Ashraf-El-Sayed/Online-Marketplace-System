package com.company;

import java.util.ArrayList;

public class DataBase {
    private ArrayList<Client> clients;
    public DataBase (){
        this.clients = new ArrayList<>();
    }
    public ArrayList<Client> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }
    public void SignUp(Client client){
        this.clients.add(client);
    }
    public void printUsers(){
        int i = 1;
        for (Client x : clients){
            System.out.println(
                    "Client "+(i++) + "   Username: "+ x.getAccount().getUsername()
                    + "   Password: "+ x.getAccount().getPassword()
            );
        }
    }
}
