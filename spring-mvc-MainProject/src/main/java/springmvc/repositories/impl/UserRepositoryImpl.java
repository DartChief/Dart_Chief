package springmvc.repositories.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import springmvc.model.User;
import springmvc.repositories.UserRepository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void createTableUser() throws SQLException {
        try {
            jdbcTemplate.update("CREATE TABLE USERS (Id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), FirstName VARCHAR(256), LastName VARCHAR(256), Age INTEGER, PRIMARY KEY (Id))");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void addUser(User user) throws SQLException {
        jdbcTemplate.update("INSERT INTO USERS VALUES (DEFAULT,?,?,?)",
                user.getFirstName(),
                user.getLastName(),
                user.getAge()
        );
    }

    @Override
    public void update(User user) throws SQLException {
        jdbcTemplate.update("UPDATE USERS SET FirstName = ?, LastName = ?, Age = ? WHERE Id = ?",
                user.getFirstName(),
                user.getLastName(),
                user.getAge(),
                user.getId());
    }

    @Override
    public void delete(int id) throws SQLException {
        jdbcTemplate.update("DELETE FROM USERS WHERE Id = ?",
                id);
    }

    @Override
    public List<User> showAll() throws SQLException {
        List<User> users = this.jdbcTemplate.query(
                "SELECT Id, FirstName, LastName, Age FROM USERS",
                new RowMapper<User>() {
                    @Override
                    public User mapRow(ResultSet rs, int i) throws SQLException {
                        User user = new User(
                                rs.getString("firstName"),
                                rs.getString("lastName"),
                                rs.getInt("age"),
                                rs.getInt("id")
                        );
                        return user;
                    }
                }
        );
        return users;
    }

    @Override
    public User getUser(final int userId) throws SQLException {
        return this.jdbcTemplate.query(
                "SELECT * FROM USERS WHERE id=" + userId,
                new ResultSetExtractor<User>() {
                    @Override
                    public User extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                        if(resultSet.next()) {
                            User user = new User();
                            user.setId(resultSet.getInt("id"));
                            user.setFirstName(resultSet.getString("firstName"));
                            user.setLastName(resultSet.getString("lastName"));
                            user.setAge(resultSet.getInt("age"));
                            return user;
                        }
                        return null;
                    }
                }
        );
    }



    @Override
    public long getCount() throws SQLException {
        return jdbcTemplate.queryForList("SELECT * FROM USERS").size();
    }
}