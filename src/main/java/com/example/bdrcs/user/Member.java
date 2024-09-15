package com.example.bdrcs.user;

import com.example.bdrcs.User;

import java.io.Serializable;
import java.time.LocalDate;

public class Member extends User implements Serializable {
    public Member(int id, String name, String gender, String email, LocalDate dob) {
        super(id, name, gender, email, dob);
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                '}';
    }
}
