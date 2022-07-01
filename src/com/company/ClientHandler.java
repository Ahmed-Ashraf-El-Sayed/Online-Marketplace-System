package com.company;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler extends Thread {
    Socket client;
    DataInputStream input;
    DataOutputStream output;
    static ArrayList<String> receivedMessages = new ArrayList<>();

    ClientHandler(Socket clientSocket) throws IOException {
        client = clientSocket;
        input = new DataInputStream(client.getInputStream());
        output = new DataOutputStream(client.getOutputStream());


    }

    @Override
    public void run() {
        String str;
        while (true) {
            try {
                str = input.readUTF();
                synchronized (receivedMessages) {
                    receivedMessages.add(str);

                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }


    }

    public void sendMsg(String str) throws IOException {
        output.writeUTF(str);
    }

    public ArrayList<String> getMessages() {
        return receivedMessages;
    }
}


