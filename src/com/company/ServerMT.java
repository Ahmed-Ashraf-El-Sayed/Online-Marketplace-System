package com.company;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Objects;


public class ServerMT {

     ArrayList<String> msgs = new ArrayList<>();
    ArrayList<String> info = new ArrayList<>();
    Client client;
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
                            client = new Client(new Account(info.get(0),"ay 7aga"));
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
            if (client.getAccount().getCash() >= client.getCart().getTotalPrice()){
                System.out.println("Tm el daf3");
                client.getAccount().setCash(client.getAccount().getCash()-client.getCart().getTotalPrice());
            }
            else {
                System.out.println("m3aksh flos ya ebn el mtnaka");
            }
        }
        else if (s.equals("charge")){
            System.out.println("esh7nly");
        }
        else if (s.equals("items")){
            serverMsg.dataBase.printItems();
        }
        else if (s.equals("one")){
            client.getCart().AddItem(serverMsg.dataBase.getItems().get(0));
            System.out.println("total price: "+ client.getCart().getTotalPrice());
        }
    }

}

