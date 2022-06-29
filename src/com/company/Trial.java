package com.company;
import java.sql.*;

class Trial {
    public  void trialFunction() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/marketplace", "root", "Root_password");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from person");
            int i =0;
            while (resultSet.next()) {
                System.out.println(resultSet.getString("person_ID") + resultSet.getString("first_name") + resultSet.getString("last_name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
