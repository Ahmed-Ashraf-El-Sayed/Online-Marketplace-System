package com.company;// A Java program for a Client
import java.net.*;
import java.io.*;

public class ClientNew
{
    // initialize socket and input output streams
    private Socket socket		 = null;
    private DataInputStream input = null;
    private DataOutputStream out	 = null;
    //ClientTrial clientTrial;
    Client client;
    String line = "";

    // constructor to put ip address and port
    public ClientNew(String address, int port)
    {

        // establish a connection
        try
        {
            client = new Client(new Account("abdo","abdo"));
            socket = new Socket(address, port);
            System.out.println("Connected");

            // takes input from terminal
            input = new DataInputStream(System.in);

            // sends output to the socket
            out = new DataOutputStream(socket.getOutputStream());
        }
        catch(UnknownHostException u)
        {
            System.out.println(u);
        }
        catch(IOException i)
        {
            System.out.println(i);
        }

        // string to read message from input


        // keep reading until "Over" is input
        while (!line.equals("Over"))
        {
            try
            {
                line = client.TakeInputs();
                out.writeUTF(line);
            }
            catch(IOException i)
            {
                System.out.println(i);
            }
        }

        // close the connection
        try
        {
            input.close();
            out.close();
            socket.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }



    public static void main(String args[])
    {
        ClientNew client = new ClientNew("127.0.0.1", 5000);
    }
}
