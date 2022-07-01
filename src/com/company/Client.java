package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Client extends User{
    private Cart cart;

    //private ClientMT clientMT;
    //private ClientHandler clientHandler;

    public Client(Account account) throws IOException {
        super(account);
        this.cart = new Cart();
        //clientMT = new ClientMT();
    }
    public void AddItemToCart(Item item){
        this.cart.AddItem(item);
    }
    public void RemoveItemFromCart(Item item)
    {
        this.cart.RemoveItem(item);
    }

    // Should request from server throughout these methods

    public String ChargeAccount(){

        return "7ot flos";

    }

    public String Pay(){
        return "edfa3";
    }

    public void RequestUsernameChange(){

    }

    public void RequestPasswordChange(){

    }
    public String TakeInputs(){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if (s.equals("charge")){
            return ChargeAccount();
        }
        else if (s.equals("pay")){
            return Pay();
        }
        else if (s.equals("username")){
            return "username";
        }
        return "Emshy yala";
    }


}
