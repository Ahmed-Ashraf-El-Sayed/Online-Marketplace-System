package com.company;// A Java program for a Server
import java.net.*;
import java.io.*;

public class ServerNew
{
    //initialize socket and input stream
    private Socket		 socket = null;
    private ServerSocket server = null;
    private DataInputStream in	 = null;
    Client client;
    Server serverMethods;

    // constructor with port
    public ServerNew(int port) throws IOException {
        // starts server and waits for a connection
        serverMethods = new Server();
        client = new Client(new Account("3askary","3askary"));
        try
        {
            server = new ServerSocket(port);
            System.out.println("Server started");

            System.out.println("Waiting for a client ...");

            socket = server.accept();
            System.out.println("Client accepted");

            // takes input from the client socket
            in = new DataInputStream(
                    new BufferedInputStream(socket.getInputStream()));

            String line = "";

            // reads message from client until "Over" is sent
            while (!line.equals("Over"))
            {
                try
                {
                    line = in.readUTF();
                    System.out.println(serverMethods.ReplyAll(line));
                    if (line.equals("items")){
                        serverMethods.dataBase.printItems();
                    }
                    if (line.equals("users")){
                        serverMethods.dataBase.printUsers();
                        System.out.println(client.getAccount().getUsername());
                    }


                }
                catch(IOException i)
                {
                    System.out.println(i);
                }
            }
            System.out.println("Closing connection");

            // close connection
            socket.close();
            in.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }

    /*public static void main(String args[])
    {
        ServerNew server = new ServerNew(5000);
    }*/

}
