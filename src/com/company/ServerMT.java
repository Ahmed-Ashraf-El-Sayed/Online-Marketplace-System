package com.company;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Objects;

public class ServerMT {

    static ArrayList<String> msgs = new ArrayList<>();
    private Server serverMsg;

    ServerMT() throws IOException, InterruptedException {


        serverMsg = new Server();



        ServerSocket server = new ServerSocket(22000);
        Socket clientSocket = server.accept();
        ClientHandler clientHandler1 = new ClientHandler(clientSocket);
        clientHandler1.start();


        /*clientSocket = server.accept();
        ClientHandler clientHandler2  = new ClientHandler(clientSocket);
        clientHandler2.start();*/


        while(true){
            msgs = clientHandler1.getMessages();
            if(!msgs.isEmpty()){
                synchronized (msgs){
                    //for(int i =0 ; i<msgs.size() ; i++){
                        System.out.println("Request from client #1 stating: " + msgs);
                        String s = msgs.get(msgs.size()-1);
                        //serverMsg.ReplyAll(s);
                    if (s.equals("print")){
                        serverMsg.dataBase.printItems();
                    }
                    //}
                    msgs.clear();
                }

            }
            /*msgs = clientHandler2.getMessages();
            if(!msgs.isEmpty()){
                synchronized (msgs){
                    for(int i =0 ; i<msgs.size() ; i++){
                        System.out.println("Request from client #2 stating: " + msgs);
                    }
                    msgs.clear();

                }

            }*/
            Thread.sleep(5);

        }
    }
}

