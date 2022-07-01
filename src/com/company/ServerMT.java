package com.company;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Objects;


public class ServerMT {

     ArrayList<String> msgs = new ArrayList<>();
    ArrayList<String> info = new ArrayList<>();
    int login =0;

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
                    if((msgs.get(msgs.size()-1).equals("Sign in"))){
                        System.out.println("Enter your login info");
                        login = 1;
                        msgs.clear();
                        continue;
                    }
                    if(login == 1){
                        for(int i =0 ; i<msgs.size() ; i++){
                            info.add(msgs.get(i));
                            //System.out.println(info);
                            login=0;
                            msgs.clear();
                            continue;
                        }


                    }
                    for(int i =0 ; i<msgs.size() ; i++){
                        System.out.println("Request from client #1 stating: " + msgs);
                        Reply(msgs.get(msgs.size()-1));
                    }
                    if(msgs.equals("Enter your login info")){

                    }
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
    public void Reply(String s){
        if ("pay".equals(s)) {
            System.out.println("Edfa3ly flos");
        }
        else if (s.equals("charge")){
            System.out.println("esh7nly");
        }
        else if (s.equals("sign in")){
            
        }
    }

}

