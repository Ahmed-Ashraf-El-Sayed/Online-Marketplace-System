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
    public void RemoveItemFromCart(Item item){
        this.cart.RemoveItem(item);
    }
    public void ChargeAccount(){

    }
}
