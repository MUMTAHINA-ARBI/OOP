package com.example.bdrcs.user;

import com.example.bdrcs.User;

import java.io.Serializable;
import java.time.LocalDate;

public class Director extends User implements Serializable {
    public Director(int id, String name, String gender, String email, LocalDate dob) {
        super(id, name, gender, email, dob);
    }

    @Override
    public String toString() {
        return "Director{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                '}';
    }
}
