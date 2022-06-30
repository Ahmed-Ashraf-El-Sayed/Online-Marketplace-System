package com.company;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Item> items;
    private double totalPrice;
    public Cart(){
        this.items = new ArrayList<>();
        totalPrice = 0;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void AddItem(Item item){
        this.items.add(item);
        this.totalPrice+=item.getPrice();
    }
    public void RemoveItem(Item item){
        this.items.remove(item);
        this.totalPrice-= item.getPrice();
    }
    public void PrintCartItems(){
        for (Item item : items){
            System.out.println(item);
        }
    }
}
