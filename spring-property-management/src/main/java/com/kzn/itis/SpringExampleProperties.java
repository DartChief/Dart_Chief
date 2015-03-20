package com.kzn.itis;

import com.kzn.itis.db.config.DatabaseConfiguration;
import com.kzn.itis.db.model.User;
import com.kzn.itis.db.repositories.impl.UserRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.*;

/**
 *
 */
public class SpringExampleProperties {

    private static final Logger logger = LoggerFactory.getLogger(SpringExampleProperties.class);

    @Autowired
    private DatabaseConfiguration config;

//    public static String insertStudents(int id, String LastName,
//                                        String FirstName, Statement stmt) {
//        String sql = "INSERT INTO STUDENTS VALUES (" + id + ",'" + LastName
//                + "','" + FirstName + "')";
//        try {
//            stmt.executeUpdate(sql);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return sql;
//    }

    public void run() throws SQLException {
        logger.info("Welcome to Example Application");
        logger.info("url=" + config.getDbUrl());
        logger.info("username=" + config.getDbUser());

//        Map<String, Object> configOverrides = new HashMap<String, Object>();
//        configOverrides.put("hibernate.connection.url", config.getDbUrl());
//        configOverrides.put("hibernate.connection.username", config.getDbUser());
//        configOverrides.put("hibernate.connection.password", config.getDbPassword());
//        configOverrides.put("hibernate.hbm2ddl.auto", config.getDbHbm2ddl());
//        SessionUtil.getEntityManagerFactory(configOverrides);

        Connection con = null;
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            con = DriverManager.getConnection(config.getDbUrl());
            Statement stmt = con.createStatement();
            String sql = "CREATE TABLE USERS (" + "id INTEGER not NULL,"
                    + " FirstName VARCHAR(256),"
                    + " Age INTEGER, PRIMARY KEY (id))";
            stmt.executeUpdate(sql);
//            String sql = "SELECT s.LastName || ' ' || s.FirstName Name, o.TotalAmount FROM STUDENTS s LEFT JOIN Orders o ON o.Customerid = s.id";
//            ResultSet res = stmt.executeQuery(sql);
//            while (res.next()) {
//                System.out.println(res.getString(1) + " " + res.getString(2));
//            }
//            String sql3 = "DROP TABLE STUDENTS";
//            stmt.executeUpdate(sql3);
//            String sql4 = "DROP TABLE ORDERS";
//            stmt.executeUpdate(sql4);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert con != null;
            con.close();
        }
        UserRepositoryImpl userRepository = new UserRepositoryImpl();
        userRepository.addUser(new User(1, "Sherlock", 39));
        userRepository.addUser(new User(2, "Watson", 42));
        userRepository.addUser(new User(3, "Mycroft", 43));
        userRepository.delete(2);
        userRepository.update("Baskey", 25, 3);
        userRepository.showAll();
        userRepository.getCount();


    }

//    protected void userCreate() {
//        UserRepository userRepository = new UserRepositoryImpl();
//
//        Random random = new Random(+100);
//
//        User user = new User();
//        user.setId(Integer.parseInt(String.valueOf(random)));
//        user.setAge(35);
//        user.setFirstname("Sherlock");
//
//        userRepository.addUser(user);
//
//        logger.info("User has been added!");
//
//        long count = userRepository.getCount();
//
//        logger.info("New count: " + String.valueOf(count));
//    }

    public static void main(String... args) throws SQLException {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        SpringExampleProperties main = (SpringExampleProperties)context.getBean("exampleApp");
        main.run();
    }
}
