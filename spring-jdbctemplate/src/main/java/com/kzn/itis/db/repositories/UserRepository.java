package com.kzn.itis.db.repositories;

import com.kzn.itis.db.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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

    public void showAll() throws SQLException {
        List<Map<String, Object>> all = jdbcTemplate.queryForList("SELECT * FROM USERS");
        for (Map<String, Object> anAll : all) {
            System.out.println(anAll);
        }
    }

    public long getCount() throws SQLException {
        return jdbcTemplate.queryForList("SELECT * FROM USERS").size();
    }
}
