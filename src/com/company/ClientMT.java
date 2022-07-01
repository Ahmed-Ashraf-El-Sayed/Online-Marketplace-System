package com.company;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.*;

public class ClientMT {
    boolean isOn;
    Client client;

    public ClientMT() throws IOException, IOException {
        isOn = true;

        //client = new Client(new Account("3askary","3askary"));


        InetAddress ip = InetAddress.getLocalHost();
        Socket other = new Socket(ip , 22000);
        DataInputStream otherRead = new DataInputStream(other.getInputStream());
        DataOutputStream otherWrite = new DataOutputStream(other.getOutputStream());

        Thread t = new Thread(){
            @Override
            public void run() {
                String str = "";
                while(isOn){
                    try {
                        str = otherRead.readUTF();
                        System.out.println("Other client said: " + str);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }


                }
            }
        };
        t.start();
        Scanner scan = new Scanner(System.in);
        String str = "";
        while(true){
            str = scan.nextLine();
            otherWrite.writeUTF(str);
            if(str.equalsIgnoreCase("exit")){
                break;
            }
        }
        isOn = false;
        otherRead.close();
        otherWrite.close();
        other.close();



    }
}
