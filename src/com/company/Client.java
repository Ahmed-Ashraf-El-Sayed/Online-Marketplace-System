package com.company;

import java.io.IOException;

public class Client extends User{
    private Cart cart;

    private ClientMT clientMT;
    private ClientHandler clientHandler;

    public Client(Account account) throws IOException {
        super(account);
        this.cart = new Cart();
        clientMT = new ClientMT();
    }
    public void AddItemToCart(Item item){
        this.cart.AddItem(item);
    }
    public void RemoveItemFromCart(Item item)
    {
        this.cart.RemoveItem(item);
    }

    // Should request from server throughout these methods

    public void ChargeAccount(){

        ServerMT.msgs.add("7ot flos");



    }

    public void Pay(){

    }

    public void RequestUsernameChange(){

    }

    public void RequestPasswordChange(){

    }


}
