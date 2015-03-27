package com.kzn.itis.db.repositories.impl;

import com.kzn.itis.db.model.Order;
import com.kzn.itis.db.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    int ordersSize;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public void addOrder(Order order) throws SQLException {
        String sql = "INSERT INTO ORDERS VALUES (DEFAULT,:name,:customerId, :salesPersonalId)";
        Map namedParameter = new HashMap();
        namedParameter.put("name", order.getName());
        namedParameter.put("customerId", order.getCustomerId());
        namedParameter.put("salesPersonalId", order.getSalesPersonalId());
        namedParameterJdbcTemplate.update(sql, namedParameter);
    }

    @Override
    public void update(String name, int customerId, int id) throws SQLException {
        String sql = "UPDATE ORDERS SET Name = :name, CustomerId = :customerId WHERE Id = :id";
        Map namedParameter = new HashMap();
        namedParameter.put("name", name);
        namedParameter.put("customerId", customerId);
        namedParameter.put("id", id);
        namedParameterJdbcTemplate.update(sql, namedParameter);
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM ORDERS WHERE Id = :id";
        Map namedParameter = new HashMap();
        namedParameter.put("id", id);
        namedParameterJdbcTemplate.update(sql, namedParameter);
    }

    @Override
    public List<Order> showAll() throws SQLException {
        String sql = "SELECT Id, Name, CustomerId, SalesPersonalId FROM ORDERS";
        List<Order> orders = namedParameterJdbcTemplate.query(
            sql,
            new RowMapper<Order>() {
                @Override
                public Order mapRow(ResultSet resultSet, int i) throws SQLException {
                    Order order = new Order();
                    order.setId(resultSet.getInt("Id"));
                    order.setName(resultSet.getString("Name"));
                    order.setCustomerId(resultSet.getInt("CustomerId"));
                    order.setSalesPersonalId(resultSet.getInt("SalesPersonalId"));
                    return order;
                }
            }
        );
        ordersSize = orders.size();
        return orders;
    }

    @Override
    public long getCount() throws SQLException {
        String sql = "SELECT * FROM ORDERS";
        Map namedParameter = new HashMap();
        namedParameter.put(null, null);
        return namedParameterJdbcTemplate.queryForList(sql, namedParameter).size();
    }
}