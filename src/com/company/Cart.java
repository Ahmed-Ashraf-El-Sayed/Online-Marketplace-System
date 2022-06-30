package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Cart {
    //i want a cart_ID int attribute to see which cart i am interacting with
    private ArrayList<Item> items;
    private double totalPrice;

    public Cart() {
        this.items = new ArrayList<>();
        totalPrice = 0;
    }

    public double getTotalPrice() {
        /*
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/marketplace", "root", "Root_password");
            Statement statement = connection.createStatement();
            String query = "select cart_ID,sum(Total_Price) from cart where cart_ID = " + this.cart_ID;
            ResultSet rs = statement.executeQuery(query);
            if (rs.next()) {
                totalPrice = rs.getDouble("Total_Price");
                return totalPrice;
            }
        }catch (Exception e){
            e.printStackTrace();
        }*/
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        //this.totalPrice = totalPrice;
        // sql code but needs cart id
        /*
        String update = "update cart set Total_Price = "+totalPrice+"where Cart_ID = "+this.Cart_ID;
        try {
            // url is jdbc:mysql://localhost:3306/{database name}   user is the user of the database on the machine password should be the same as well
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/marketplace", "root", "Root_password");
            Statement statement = connection.createStatement();
            statement.executeUpdate(update);
        }catch (Exception e){
            e.printStackTrace();
        }
         */
    }

    public void AddItem(Item item) {
        this.items.add(item);
        this.totalPrice += item.getPrice();


        // sql part
        /*
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/marketplace", "root", "Root_password");
            Statement statement = connection.createStatement();
            String update = "insert into cart values("this.cart_ID+","+item.getID()+","+item.getPrice()+")";
            statement.executeUpdate(update);
        }catch (Exception e){
            e.printStackTrace();
        }
        */
    }

    public void RemoveItem(Item item) {
        this.items.remove(item);
        this.totalPrice -= item.getPrice();


        //sql part
        /*
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/marketplace", "root", "Root_password");
            Statement statement = connection.createStatement();
            String update = "delete from cart where item_ID = "+item.getID();
            statement.executeUpdate(update);
        }catch (Exception e){
            e.printStackTrace();
        }
         */
    }

    public void PrintCartItems() {
        for (Item item : items) {
            System.out.println(item);
        }

        //sql part
        /*
        try {
            String query = "select Item_ID,Item_name,Price,Weight,Quantitiy from cart,item where cart_ID = "+this.cart_ID;
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/marketplace", "root", "Root_password");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                System.out.println(" "+rs.getString("Item_ID")+" "+rs.getString("Item_name")+" "+rs.getString("Price")+" "+rs.getString("weight")+" "+rs.getString("quantity"));
                }
            }catch (Exception e){
            e.printStackTrace();
        }
         */
    }
}