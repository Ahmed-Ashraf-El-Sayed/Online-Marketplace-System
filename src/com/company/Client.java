package com.company;

public class Client extends User{
    private Cart cart;
    public Client(Account account) {
        super(account);
        this.cart = new Cart();
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
        ServerMT.msgs.add("Zeby");



    }

    public void Pay(){

    }

    public void RequestUsernameChange(){

    }

    public void RequestPasswordChange(){

    }


}
