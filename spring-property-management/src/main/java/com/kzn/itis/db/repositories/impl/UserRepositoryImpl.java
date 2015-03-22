package com.kzn.itis.db.repositories.impl;

import com.kzn.itis.db.config.DatabaseConfiguration;
import com.kzn.itis.db.model.User;
import com.kzn.itis.db.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.*;

public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private DatabaseConfiguration config;

    @Override
    public void addUser(User user) throws SQLException {
        Connection con = null;
        try {
            con  = DriverManager.getConnection(config.getDbUrl());
            Statement statement = con.createStatement();
            String sql = "INSERT INTO USERS VALUES (DEFAULT ,'" + user.getName()
                    + "'," + user.getAge() + ")";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            assert con != null;
            con.close();
        }
    }

    @Override
    public void update(String name, int age, int id) throws SQLException {
        Connection con = null;
        try {
            con  = DriverManager.getConnection(config.getDbUrl());
            Statement statement = con.createStatement();
            String sql = "UPDATE USERS SET Name = '" + name + "', Age = " + age + " WHERE Id = " + id;
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
    public void showAll() throws SQLException {
        Connection con = null;
        try {
            con = DriverManager.getConnection(config.getDbUrl());
            Statement statement = con.createStatement();
            String sql = "SELECT * FROM USERS";
            ResultSet res = statement.executeQuery(sql);
            //all = new ArrayList<User>();
            while (res.next()) {
                System.out.println(res.getInt(1) + " " + res.getString(2) + " " + res.getInt(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            assert con != null;
            con.close();
        }
        //return all;
    }

    @Override
    public long getCount() throws SQLException {
        Connection con = null;
        int i = 0;
        try {
            con = DriverManager.getConnection(config.getDbUrl());
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM USERS";
            ResultSet res = statement.executeQuery(sql);
            while(res.next()) {
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            assert con != null;
            con.close();
        }
        return i;
    }
}
