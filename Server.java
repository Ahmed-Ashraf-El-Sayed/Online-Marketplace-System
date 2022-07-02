package application;

import java.io.IOException;

public class Server {
    public final DataBase dataBase;
    private static Server server;
    Client client;

    private Server(){
        this.dataBase=DataBase.getInstance();
        dataBase.objectifyItems();
        dataBase.objectifyUsers();
    }
    public static Server getInstance(){
        if (server == null){
            return new Server();
        }
        else return server;
    }


    /*public void ReplyUsernameChange(User user,String username){
        if(user.getAccount().VerifyAccount()){
            user.getAccount().setUsername(username);
            // to be updated in database
        }
        else {
            System.out.println("Incorrect");
        }
    }

    public void ReplyPasswordChange(User user,String password){
        if(user.getAccount().VerifyAccount()){
            user.getAccount().setPassword(password);
            // to be updated in database
        }
        else {
            System.out.println("Incorrect");
        }
    }
    */


    public void ReplySignUp(User user){
        //dataBase.SignUp(user);
    }

    public boolean ReplySignIn(User user){
        return user.getAccount().VerifyAccount();
    }

    public String ReplyAll(String request){
        return "Galy request "+request;
    }
}


/*
 * Only one server can be created
 * Linked to database
 * Only one database can be linked/created
 */
