package springmvc.repositories;


import springmvc.model.Order;

import java.sql.SQLException;
import java.util.List;

public interface OrderRepository {

    public void createTableOrder() throws SQLException, Exception;

    public void addOrder(Order order) throws SQLException;

    public void update(Order order) throws SQLException;

    public void delete(int id) throws SQLException;

    public List<Order> showAll() throws SQLException;

    public Order getOrder(final int orderId) throws SQLException;

    public long getCount() throws SQLException;
}
