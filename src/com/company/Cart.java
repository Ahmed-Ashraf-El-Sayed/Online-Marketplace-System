package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
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
        //this.totalPrice = totalPrice;
        //=String update = "update cart set Total_Price = "+totalPrice+"where Cart_ID = "+this.Cart_ID;
        try {
            // url is jdbc:mysql://localhost:3306/{database name}   user is the user of the database on the machine password should be the same as well
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/marketplace", "root", "Root_password");
            Statement statement = connection.createStatement();
            //statement.executeUpdate(update);
        }catch (Exception e){
            e.printStackTrace();
        }
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
