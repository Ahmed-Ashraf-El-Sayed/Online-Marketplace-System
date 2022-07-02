package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Objects;

public class DataBase {
    private ArrayList<User> users;
    private ArrayList<Item> items;
    private static DataBase dataBase;

    private DataBase() {
        this.users = new ArrayList<>();
        this.items = new ArrayList<>();
    }

    public static DataBase getInstance() {
        return Objects.requireNonNullElseGet(dataBase, DataBase::new);
    }

    public ArrayList<User> getUsers() {

        return users;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setClients(ArrayList<User> clients) {
        this.users = clients;
    }


    public void SignUp(User user) {
        if (!CheckUserName(user.getAccount().getUsername())) {
            System.out.println("This username is taken");
            return;
        }
        this.users.add(user);
        System.out.println("Account Created");

        // update database
    }


    public boolean CheckUserName(String username) {
        for (User user : users) {
            if (user.getAccount().getUsername().equals(username)) {
                return false;
            }
        }
        return true;
    }


    public void printUsers() {
        int i = 1;
        for (User x : users) {
            System.out.println(
                    "Client " + (i++) + "   Username: " + x.getAccount().getUsername()
                            + "   Password: " + x.getAccount().getPassword()
            );
        }
    }
    public void printItems(){
        int i=1;
        for (Item item : items){
            System.out.println(
                    "Item " + (i++) +"    name: "+ item.getName() +
                    "   Price: "+item.getPrice()
            );
        }
    }
    public void AddUser(User user){
        this.users.add(user);
        //Should be updated in database
    }

//fetch items from database into arraylist

    public void objectifyItems() {
        try {
            String query = "select Item_name,Price,Quantitiy,Weight from Item ";
            // url is jdbc:mysql://localhost:3306/{database name}   user is the user of the database on the machine password should be the same as well
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/marketplace", "root", "abdo1234");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()){
                Item item = new Item(
                        rs.getString("Item_name"),
                        rs.getString("Quantitiy")+" - "+rs.getString("Weight"),
                        rs.getDouble("price"));
                items.add(item);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void objectifyUsers(){
        try {
            String query = "select customer_username,customer_password from customer ";
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/marketplace", "root", "abdo1234");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()){
                Account account = new Account(rs.getString("customer_username"),rs.getString("customer_password"));
                User user = new User(account);
                users.add(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean SignIn(User user){
        for(User x : users){
            if (x.getAccount().getUsername().equals(user.getAccount().getUsername())){
                if (x.getAccount().getPassword().equals(user.getAccount().getPassword())){
                    return true;
                }
            }
        }
        return false;
    }
}