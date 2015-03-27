package com.kzn.itis.db.repositories;

import com.kzn.itis.db.model.Order;

import java.sql.SQLException;
import java.util.List;

public interface OrderRepository {

    public void addOrder(Order order) throws SQLException;

    public void update(String name, int customerId, int id) throws SQLException;

    public void delete(int id) throws SQLException;

    public List<Order> showAll() throws SQLException;

    public long getCount() throws SQLException;
}
