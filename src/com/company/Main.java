package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
	// write your code here
    /*System.out.println("pull request");
    ServerMT serverMT = new ServerMT();
    ClientMT clientMT = new ClientMT();
    Account account = new Account("3askary","3askary");
    Client client = new Client(account);*/

        Scanner scan = new Scanner(System.in);
        if(scan.next().equals("server")){
            ServerMT s = new ServerMT();
        }
        else{
            //ClientMT c = new ClientMT();
            Account account = new Account("3askary","3askary");
            System.out.println("kekw1");
            Client client = new Client(account);
            System.out.println("kekw2");
            client.ChargeAccount();

        }




    }
}
