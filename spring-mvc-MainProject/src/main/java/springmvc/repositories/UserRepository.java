package springmvc.repositories;


import springmvc.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserRepository {

    public void createTableUser() throws SQLException, Exception;

    public void addUser(User user) throws SQLException;

    public void update(User user) throws SQLException;

    public void delete(int id) throws SQLException;

    public List<User> showAll() throws SQLException;

    public User getUser(int userId) throws SQLException;

    public long getCount() throws SQLException;
}
