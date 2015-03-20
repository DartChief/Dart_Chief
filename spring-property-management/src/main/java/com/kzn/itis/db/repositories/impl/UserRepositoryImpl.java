package com.kzn.itis.db.repositories.impl;

import com.kzn.itis.db.config.DatabaseConfiguration;
import com.kzn.itis.db.model.User;
import com.kzn.itis.db.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.*;
import java.util.ArrayList;

public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private DatabaseConfiguration config;

    @Override
    public void addUser(User user) throws SQLException {
        Connection con = null;
        try {
            con  = DriverManager.getConnection(config.getDbUrl());
            Statement statement = con.createStatement();
            String sql = "INSERT INTO STUDENTS VALUES (" + user.getId() + ",'" + user.getFirstname()
                    + "','" + user.getAge() + "')";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            assert con != null;
            con.close();
        }
    }

    @Override
    public void update(String name, int age, int id) throws SQLException { //можно передать User
        Connection con = null;
        try {
            con  = DriverManager.getConnection(config.getDbUrl());
            Statement statement = con.createStatement();
            String sql = "UPDATE USERS SET FirstName = '" + name + "', Age = " +  age + ", WHERE id = " + id;
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            assert con != null;
            con.close();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        Connection con = null;
        try {
            con  = DriverManager.getConnection(config.getDbUrl());
            Statement statement = con.createStatement();
            String sql = "DELETE FROM USERS WHERE  Id = " + id;
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            assert con != null;
            con.close();
        }
    }

    @Override
    public ArrayList<User> showAll() throws SQLException {
        Connection con = null;
        ArrayList<User> all = null;
        try {
            con = DriverManager.getConnection(config.getDbUrl());
            Statement statement = con.createStatement();
            String sql = "SELECT * FROM USERS";
            ResultSet res = statement.executeQuery(sql);
            all = new ArrayList();
            while (res.next()) {
                all.add(new User(res.getInt("Id"), res.getString("FirstName"), res.getInt("Age")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            assert con != null;
            con.close();
        }
        return all;
    }

    @Override
    public int getCount() throws SQLException {
//        Connection con = null;
//        try {
//            con  = DriverManager.getConnection(config.getDbUrl());
//            Statement statement = con.createStatement();
//            showAll().size();
//            ResultSet res = statement.executeQuery()
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            assert con != null;
//            con.close();
//        }
        return showAll().size();
    }
}
