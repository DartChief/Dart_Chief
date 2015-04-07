package com.itis;

import java.util.ArrayList;
import java.util.List;

public class UserBean {

    public static class User {

        public User() {
        }

        public User(String firsname, String lastname, int age) {
            Firsname = firsname;
            Lastname = lastname;
            this.age = age;
        }

        String Firsname;
        String Lastname;
        int age;
    }

    List<User> userList = new ArrayList<User>() {
        @Override
        public boolean add(User element) {
            super.add(new User("asdsfw", "feferf", 32));
            super.add(new User("wef", "vdf", 33));
            super.add(new User("dfvdf", "fefdfvdfverf", 32));
            super.add(new User("asvcsdvcsdsfw", "fedfvdvferf", 32));
            super.add(new User("asdsvefdfw", "fefweveerf", 32));
            return true;
        }
    };

    public List<User> addUser() {
        userList.add(new User("asdsfw", "feferf", 32));
        userList.add(new User("wef", "vdf", 33));
        userList.add(new User("dfvdf", "fefdfvdfverf", 32));
        userList.add(new User("asvcsdvcsdsfw", "fedfvdvferf", 32));
        userList.add(new User("asdsvefdfw", "fefweveerf", 32));
        return userList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}