package com.company;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerMT {
    static ArrayList<String> msgs;

    ServerMT() throws IOException, InterruptedException {
        ServerSocket server = new ServerSocket(22000);
        Socket clientSocket = server.accept();
        ClientHandler clientHandler1 = new ClientHandler(clientSocket);
        clientHandler1.start();


        clientSocket = server.accept();
        ClientHandler clientHandler2  = new ClientHandler(clientSocket);
        clientHandler2.start();

        while(true){
            msgs = clientHandler1.getMessages();
            if(!msgs.isEmpty()){
                synchronized (msgs){
                    for(int i =0 ; i<msgs.size() ; i++){
                        System.out.println("Request from client #1 stating: " + msgs);
                    }
                    msgs.clear();
                }

            }
            msgs = clientHandler2.getMessages();
            if(!msgs.isEmpty()){
                synchronized (msgs){
                    for(int i =0 ; i<msgs.size() ; i++){
                        System.out.println("Request from client #2 stating: " + msgs);
                    }
                    msgs.clear();

                }

            }
            Thread.sleep(5);

        }
    }
}
