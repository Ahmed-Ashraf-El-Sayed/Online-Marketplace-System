package com.company;

public class User {
    private Account account;
    public User(Account account){
        this.account = account;
    }
    public void SignIn (){
        if (this.account.VerifyAccount()){
            System.out.println("Sign in completed");
        }
    }
    public void ChangeUserName(String newUsername){
        if (this.account.VerifyAccount()){
            this.account.setUsername(newUsername);
        }
    }
    public void ChangePassword(String newPassword){
        if (this.account.VerifyAccount()){
            this.account.setPassword(newPassword);
        }
    }

    public Account getAccount() {
        return account;
    }
}
