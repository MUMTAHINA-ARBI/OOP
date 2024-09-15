package com.example.bdrcs;

import java.io.*;
import java.time.LocalDate;

public abstract class User implements Serializable {

    protected int id;
    protected String name, gender, email;
    protected LocalDate dob;

    public User(int id, String name, String gender, String email, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.dob = dob;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
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
