package com.kzn.itis.db.model;


import com.kzn.itis.db.config.DatabaseConfiguration;
import org.springframework.beans.factory.annotation.Autowired;

public class User {

    @Autowired
    private DatabaseConfiguration config;

    private int id;

    public User(int id, String firstName, int age) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String firstname;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
