package com.company;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Item> items;
    public Cart(){
        this.items = new ArrayList<>();
    }
    public void AddItem(Item item){
        this.items.add(item);
    }
    public void RemoveItem(Item item){
        this.items.remove(item);
    }
    public void PrintCartItems(){
        for (Item item : items){
            System.out.println(item);
        }
    }
}
