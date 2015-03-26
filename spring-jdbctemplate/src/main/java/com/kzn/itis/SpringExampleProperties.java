package com.kzn.itis;

import com.kzn.itis.db.config.DatabaseConfiguration;
import com.kzn.itis.db.model.Order;
import com.kzn.itis.db.model.User;
import com.kzn.itis.db.repositories.OrderRepository;
import com.kzn.itis.db.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SpringExampleProperties {

    private static final Logger logger = LoggerFactory.getLogger(SpringExampleProperties.class);

    @Autowired
    private DatabaseConfiguration config;

    public void run(AbstractApplicationContext context) throws SQLException {
        logger.info("Welcome to Example Application");
        logger.info("url=" + config.getDbUrl());
        logger.info("username=" + config.getDbUser());

        Connection con1 = null;
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            con1 = DriverManager.getConnection(config.getDbUrl());
            Statement stmt = con1.createStatement();
            try {
                String sql = "CREATE TABLE USERS (" + "Id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
                        + " Name VARCHAR(256),"
                        + " Age INTEGER, PRIMARY KEY (Id))";
                stmt.executeUpdate(sql);
            } catch (SQLException s) {
                if(s.getSQLState().equals("X0Y32")) {
                    logger.info("Table is already exists!");
                } else {
                    logger.info("Table USERS was created!");
                }
            } finally {
                con1.close();
            }
        } catch (Exception e) {
                e.printStackTrace();
        } finally {
            assert con1 != null;
            con1.close();
        }

        Connection con2 = null;
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            con2 = DriverManager.getConnection(config.getDbUrl());
            Statement stmt = con2.createStatement();
            try {
                String sql = "CREATE TABLE ORDERS (" + "Id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
                        + " Name VARCHAR(45),"
                        + " CustomerId INTEGER,"
                        + " SalesPersonalId INTEGER, PRIMARY KEY (Id))";
                stmt.executeUpdate(sql);
            } catch (SQLException s) {
                if(s.getSQLState().equals("X0Y32")) {
                    logger.info("Table is already exists!");
                } else {
                    logger.info("Table ORDERS was created!");
                }
            } finally {
                con2.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert con2 != null;
            con2.close();
        }

        UserRepository userRepository = context.getBean("userRepository", UserRepository.class);
        OrderRepository orderRepository = context.getBean("orderRepository", OrderRepository.class);

        usersWorkflow(userRepository);
        ordersWorkflow(orderRepository);

    }

    public void usersWorkflow(UserRepository userRepository) throws SQLException {
        System.out.println("Users count = " + String.valueOf(userRepository.getCount()));
        userRepository.showAll();
        userRepository.addUser(new User("Sherloc", 39));
        logger.info("User has been added!");
        userRepository.addUser(new User("Watson", 42));
        logger.info("User has been added!");
        System.out.println("Users count = " + String.valueOf(userRepository.getCount()));
        userRepository.delete(2);
        logger.info("User has been deleted!");
        userRepository.update("Sherlock", 38, 1);
        logger.info("User has been updated!");
        userRepository.showAll();
        System.out.println("Users count = " + String.valueOf(userRepository.getCount()));

//        userRepository.addUser(new User("Mycroft", 45));
//        logger.info("User has been added!");
//        userRepository.addUser(new User("Polly", 34));
//        logger.info("User has been added!");
//        userRepository.addUser(new User("Mrs.Hudson", 63));
//        logger.info("User has been added!");
//        System.out.println("Count = " + String.valueOf(userRepository.getCount()));
//        logger.info("User has been deleted!");
//        userRepository.showAll();
//        userRepository.addUser(new User("Lestrade", 44));
//        logger.info("User has been added!");
//        userRepository.addUser(new User("Moriarty", 38));
//        logger.info("User has been added!");
//        System.out.println("Count = " + String.valueOf(userRepository.getCount()));
//        userRepository.delete(7);
//        logger.info("User has been deleted!");
//        userRepository.update("Iren", 35, 4);
//        logger.info("User has been updated!");
//        userRepository.showAll();
//        System.out.println("Count = " + String.valueOf(userRepository.getCount()));
    }

    public void ordersWorkflow(OrderRepository orderRepository) throws SQLException {
        System.out.println("Orders count = " + String.valueOf(orderRepository.getCount()));
        orderRepository.showAll();
        orderRepository.addOrder(new Order("Evidence", 1, 1));
        logger.info("Order has been added!");
        orderRepository.addOrder(new Order("Guns", 2, 2));
        logger.info("Order has been added!");
        System.out.println("Orders count = " + String.valueOf(orderRepository.getCount()));
        orderRepository.delete(1);
        logger.info("Order has been deleted!");
        orderRepository.update("Roses", 3, 2);
        logger.info("Order has been updated!");
        orderRepository.showAll();
        System.out.println("Orders count = " + String.valueOf(orderRepository.getCount()));
    }

    public static void main(String... args) throws SQLException {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        SpringExampleProperties main = (SpringExampleProperties)context.getBean("exampleApp");
        main.run(context);
    }
}
