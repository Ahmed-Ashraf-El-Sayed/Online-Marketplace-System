package com.company;

public class Server {
    private DataBase dataBase;
    private static Server server;

    private Server(){
        this.dataBase=DataBase.getInstance();
        dataBase.objectifyItems();
        dataBase.objectifyUsers();
    }

    public static Server getInstance(){
        if (server == null){
            return new Server();
        }
        return server;
    }

    public void ReplyUsernameChange(User user,String username){
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

    public void ReplySignUp(User user){
        dataBase.SignUp(user);
    }

    public boolean ReplySignIn(User user){
        return user.getAccount().VerifyAccount();

        // if true should go to next state

    }
}


/*
 * Only one server can be created
 * Linked to database
 * Only one database can be linked/created
 */
