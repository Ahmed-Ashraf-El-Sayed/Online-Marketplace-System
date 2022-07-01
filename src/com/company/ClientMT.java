package com.company;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.*;

public class ClientMT {

    public ClientMT() throws IOException, IOException {
        InetAddress ip = InetAddress.getLocalHost();
        Socket other = new Socket(ip , 22000);
        DataInputStream otherRead = new DataInputStream(other.getInputStream());
        DataOutputStream otherWrite = new DataOutputStream(other.getOutputStream());
        Scanner scan = new Scanner(System.in);
        String str = "";
        while(true){
            str = scan.nextLine();
            if(str.equalsIgnoreCase("exit")){
                break;
            }
            if(str.equals("Sign in")){
                otherWrite.writeUTF("Enter your login info");
                continue;
            }
            otherWrite.writeUTF(str);

        }
        otherRead.close();
        otherWrite.close();
        other.close();



    }
}
