package com.kzn.itis.db.repositories;

import com.kzn.itis.db.model.Order;

import java.sql.SQLException;

public interface OrderRepository {

    public void addOrder(Order order) throws SQLException;

    public void update(String name, int id) throws SQLException;

    public void delete(int id) throws SQLException;

    public void showAll() throws SQLException;

    public long getAmount() throws SQLException;

}
