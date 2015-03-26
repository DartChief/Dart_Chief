package com.kzn.itis.db.repositories;

import com.kzn.itis.db.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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

    public void showAll() throws SQLException {
        List<Map<String, Object>> all = jdbcTemplate.queryForList("SELECT * FROM ORDERS");
        for (Map<String, Object> anAll : all) {
            System.out.println(anAll);
        }
    }

    public long getCount() throws SQLException {
        return jdbcTemplate.queryForList("SELECT * FROM ORDERS").size();
    }
}
