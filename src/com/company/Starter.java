package com.company;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.Scanner;

public class Starter {
    public static void main (String[] args) throws IOException, InterruptedException {
        Scanner scan = new Scanner(System.in);
        if(scan.next().equals("server")){
            ServerMT s = new ServerMT();

        }
        else{
            ClientMT c = new ClientMT();
        }
    }
}
