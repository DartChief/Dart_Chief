package com.kzn.itis.db.repositories.impl;

import com.kzn.itis.db.model.User;
import com.kzn.itis.db.repositories.UserRepository;
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
public class UserRepositoryImpl implements UserRepository {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    int usersSize;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public void addUser(User user) throws SQLException {
        String sql = "INSERT INTO USERS VALUES (DEFAULT,:Name,:Age)";
        Map namedParameter = new HashMap();
        namedParameter.put("Name", user.getName());
        namedParameter.put("Age", user.getAge());
        namedParameterJdbcTemplate.update(sql, namedParameter);
    }

    @Override
    public void update(String name, int age, int id) throws SQLException {
        String sql = "UPDATE USERS SET Name = :name, Age = :age WHERE Id = :id";
        Map namedParameter = new HashMap();
        namedParameter.put("name", name);
        namedParameter.put("age", age);
        namedParameter.put("id", id);
        namedParameterJdbcTemplate.update(sql, namedParameter);
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM USERS WHERE Id = :id";
        Map namedParameter = new HashMap();
        namedParameter.put("id", id);
        namedParameterJdbcTemplate.update(sql, namedParameter);
    }

    @Override
    public List<User> showAll() throws SQLException {
        String sql = "SELECT Id, Name, Age FROM USERS";
        List<User> users = namedParameterJdbcTemplate.query(
                sql,
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
        usersSize = users.size();
        return users;
    }

    @Override
    public long getCount() throws SQLException { //Считаю, что тут не выгодно использовать NamedParameterJdbcTemplate, ну да ладно.
        String sql = "SELECT * FROM USERS";
        Map namedParameter = new HashMap();
        //Криво, костыль, но с NamedParameterJdbcTemplate по другому я не знаю как.
        namedParameter.put(null, null);
        return namedParameterJdbcTemplate.queryForList(sql, namedParameter).size();
    }
}