package com.kzn.itis.db.repositories;

import com.kzn.itis.db.model.User;

import java.sql.SQLException;
import java.util.ArrayList;

public interface UserRepository {

    public void addUser(User user) throws SQLException;

    public void update(String FirstName, int age, int id) throws SQLException;

    public void delete(int id) throws SQLException;

    public ArrayList showAll() throws SQLException;

    public int getCount() throws SQLException;
}
