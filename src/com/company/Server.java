package com.company;

public class Server {
    private DataBase dataBase;
    private static Server server;

    private Server(){
        this.dataBase = new DataBase();
    }

    public static Server CreateInstance(){
        if (server == null){
            return new Server();
        }
        return server;
    }


}
