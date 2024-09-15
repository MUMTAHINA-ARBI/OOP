package com.example.bdrcs;

import java.io.*;

public class LoginCredential implements Serializable{

    private int userId; //foreign field
    private String password, userType;

    public LoginCredential(int userId, String password, String userType) {
        this.userId = userId;
        this.password = password;
        this.userType = userType;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "LoginCredential{" +
                "userId=" + userId +
                ", password='" + password + '\'' +
                ", userType='" + userType + '\'' +
                '}';
    }


    public void verifyLogin(){
        //
    }

    public void changePassword(){
        //
    }

    public static int isDuplicateId(int givenId){
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try{
            File f = new File("LoginCredential.bin");
            if(f.exists()){
                LoginCredential loginCredentialObject = null;
                while(true){
                    loginCredentialObject = (LoginCredential)ois.readObject();
                    if(loginCredentialObject.getUserId() == givenId){
                        return -1; // invalid: id already exists
                    }
                }
            }
        }
        catch(Exception e){
            if(ois !=null) {
                try {
                    ois.close();
                    return 1; // Valid: checked ALL users from file, not a duplicate id
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        } //end catch
        return 1; // Valid: file does not exist, first user, not a duplicate id
    }
}
