package springmvc.repositories.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import springmvc.model.Order;
import springmvc.repositories.OrderRepository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void createTableOrder(){
        try {
            jdbcTemplate.update("CREATE TABLE ORDERS (Id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), Name VARCHAR(45), CustomerId INTEGER, Price DECIMAL , PRIMARY KEY (Id))");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addOrder(Order order) throws SQLException {
        jdbcTemplate.update("INSERT INTO ORDERS VALUES (DEFAULT,?,?,?)",
                order.getName(),
                order.getCustomerId(),
                order.getPrice()
        );
    }

    @Override
    public void update(Order order) throws SQLException {
        jdbcTemplate.update("UPDATE ORDERS SET Name = ?, CustomerId = ?, Price = ? WHERE Id = ?",
                order.getName(),
                order.getCustomerId(),
                order.getPrice(),
                order.getId());
    }

    @Override
    public void delete(int id) throws SQLException {
        jdbcTemplate.update("DELETE FROM ORDERS WHERE Id = ?",
                id);
    }

    @Override
    public List<Order> showAll() throws SQLException {
        List<Order> orders = this.jdbcTemplate.query(
                "SELECT Id, Name, CustomerId, Price FROM ORDERS",
                new RowMapper<Order>() {
                    @Override
                    public Order mapRow(ResultSet resultSet, int i) throws SQLException {
                        Order order = new Order();
                        order.setId(resultSet.getInt("Id"));
                        order.setName(resultSet.getString("Name"));
                        order.setCustomerId(resultSet.getInt("CustomerId"));
                        order.setPrice(resultSet.getBigDecimal("Price"));
                        return order;
                    }
                }
        );
        return orders;
    }

    @Override
    public Order getOrder(final int orderId) throws SQLException {
        return this.jdbcTemplate.query(
                "SELECT * FROM ORDERS WHERE id=" + orderId,
                new ResultSetExtractor<Order>() {
                    @Override
                    public Order extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                        if(resultSet.next()) {
                            Order order = new Order();
                            order.setId(resultSet.getInt("id"));
                            order.setName(resultSet.getString("name"));
                            order.setPrice(resultSet.getBigDecimal("price"));
                            return order;
                        }
                        return null;
                    }
                }
        );
    }

    @Override
    public long getCount() throws SQLException {
        return jdbcTemplate.queryForList("SELECT * FROM ORDERS").size();
    }
}