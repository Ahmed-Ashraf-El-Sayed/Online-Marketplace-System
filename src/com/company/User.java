package com.company;

public class User {
    private Account account;
    public User(Account account){
        this.account = account;
    }
    public void SignIn (String username, String password){
        if (this.account.VerifyAccount(username, password)){
            System.out.println("Sign in completed");
        }
    }
    public void ChangeUserName(String newUsername){
        String username = null,password = null; // to be entered from user.
        if (this.account.VerifyAccount(username,password)){
            this.account.setUsername(newUsername);
        }
    }
    public void ChangePassword(String newPassword){
        String username = null,password = null; // to be entered from user.
        if (this.account.VerifyAccount(username,password)){
            this.account.setPassword(newPassword);
        }
    }

    public Account getAccount() {
        return account;
    }
}
