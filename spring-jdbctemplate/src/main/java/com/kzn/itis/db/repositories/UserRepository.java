package com.kzn.itis.db.repositories;

import com.kzn.itis.db.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {

        this.jdbcTemplate = new JdbcTemplate(dataSource);

    }

    public void addUser(User user) throws SQLException {
        jdbcTemplate.update("INSERT INTO USERS VALUES (DEFAULT,?,?)",
                user.getName(),
                user.getAge()
        );
    }

    public void update(String name, int age, int id) throws SQLException {
        jdbcTemplate.update("UPDATE USERS SET Name = ?, Age = ? WHERE Id = ?",
                name,
                age,
                id);
    }

    public void delete(int id) throws SQLException {
        jdbcTemplate.update("DELETE FROM USERS WHERE Id = ?",
                id);
    }

    public List<User> showAll() throws SQLException {
        List<User> users = this.jdbcTemplate.query(
                "SELECT Id, Name, Age FROM USERS",
                new RowMapper<User>() {
                    @Override
                    public User mapRow(ResultSet resultSet, int i) throws SQLException {
                        User user = new User();
                        user.setId(resultSet.getInt("Id"));
                        user.setName(resultSet.getString("Name"));
                        user.setAge(resultSet.getInt("Age"));
                        return user;
                    }
                }
        );
        return users;
    }

    public long getCount() throws SQLException {
        return jdbcTemplate.queryForList("SELECT * FROM USERS").size();
    }
}
