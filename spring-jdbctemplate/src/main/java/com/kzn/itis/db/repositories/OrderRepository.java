package com.kzn.itis.db.repositories;

import com.kzn.itis.db.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.SQLException;

@Repository
public class OrderRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void addOrder(Order order) throws SQLException {
        jdbcTemplate.update("INSERT INTO ORDERS VALUES (DEFAULT,?,?,?)",
                order.getName(),
                order.getCustomerId(),
                order.getSalesPersonalId()
        );
    }

    public void update(String name, int customerId, int id) throws SQLException {
        jdbcTemplate.update("UPDATE ORDERS SET Name = ?, CustomerId = ? WHERE Id = ?",
                name,
                customerId,
                id);
    }

    public void delete(int id) throws SQLException {
        jdbcTemplate.update("DELETE FROM ORDERS WHERE Id = ?",
                id);
    }

//    public List<Order> showAll() throws SQLException {
//        List<Order> orders = this.jdbcTemplate.query(
//                "SELECT Id, Name, CustomerId, SalesPersonalId FROM ORDERS",
//                new RowMapper<Order>() {
//                    @Override
//                    public Order mapRow(ResultSet resultSet, int i) throws SQLException {
//                        Order order = new Order();
//                        order.setId(resultSet.getInt("Id"));
//                        order.setName(resultSet.getString("Name"));
//                        order.setCustomerId(resultSet.getInt("CustomerId"));
//                        order.setSalesPersonalId(resultSet.getInt("SalesPersonalId"));
//                        return order;
//                    }
//                }
//        );
//        return orders;
//    }

    public long getCount() throws SQLException {
        return jdbcTemplate.queryForList("SELECT * FROM ORDERS").size();
    }
}
