package com.kzn.itis.db.repositories;

import com.kzn.itis.db.model.User;

import java.sql.SQLException;

public interface UserRepository {

    public void addUser(User user) throws SQLException;

    public void update(String name, int age, int id) throws SQLException;

    public void delete(int id) throws SQLException;

    public void showAll() throws SQLException;

    public long getCount() throws SQLException;
}
