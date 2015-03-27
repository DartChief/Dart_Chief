

package com.kzn.itis;

import com.kzn.itis.db.config.DatabaseConfiguration;
import com.kzn.itis.db.model.Order;
import com.kzn.itis.db.model.User;
import com.kzn.itis.db.repositories.impl.OrderRepositoryImpl;
import com.kzn.itis.db.repositories.impl.UserRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class SpringExampleProperties {

    private static final Logger logger = LoggerFactory.getLogger(SpringExampleProperties.class);

    @Autowired
    private DatabaseConfiguration config;

    public void run(AbstractApplicationContext context) throws SQLException{
        logger.info("Welcome to Example Application");
        logger.info("url=" + config.getDbUrl());
        logger.info("username=" + config.getDbUser());

        UserRepositoryImpl userRepository = context.getBean("userRepositoryImpl", UserRepositoryImpl.class);
        OrderRepositoryImpl orderRepository = context.getBean("orderRepositoryImpl", OrderRepositoryImpl.class);

        usersWorkflow(userRepository);
        ordersWorkflow(orderRepository);

    }

    public void usersWorkflow(UserRepositoryImpl userRepository) throws SQLException {
        System.out.println("Users count = " + String.valueOf(userRepository.getCount()));
        List<User> usersList = userRepository.showAll();
        for(int i = 0; i < usersList.size(); i++) {
            System.out.println(usersList.get(i));
        }
        userRepository.addUser(new User("Sherloc", 39));
        logger.info("User has been added!");
        userRepository.addUser(new User("Watson", 42));
        logger.info("User has been added!");
        userRepository.addUser(new User("Mycroft", 45));
        logger.info("User has been added!");
        userRepository.addUser(new User("Polly", 34));
        logger.info("User has been added!");
        userRepository.addUser(new User("Mrs.Hudson", 63));
        logger.info("User has been added!");
        usersList = userRepository.showAll();
        for(int i = 0; i < usersList.size(); i++) {
            System.out.println(usersList.get(i));
        }
        System.out.println("Users count = " + String.valueOf(userRepository.getCount()));
        userRepository.delete(5);
        logger.info("User has been deleted!");
        userRepository.update("Sherlock", 38, 1);
        logger.info("User has been updated!");
        usersList = userRepository.showAll();
        for(int i = 0; i < usersList.size(); i++) {
            System.out.println(usersList.get(i));
        }
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

    public void ordersWorkflow(OrderRepositoryImpl orderRepository) throws SQLException {
        System.out.println("Orders count = " + String.valueOf(orderRepository.getCount()));
        orderRepository.addOrder(new Order("Evidence", 1, 1));
        logger.info("Order has been added!");
        orderRepository.addOrder(new Order("Guns", 2, 2));
        logger.info("Order has been added!");
        System.out.println("Orders count = " + String.valueOf(orderRepository.getCount()));
        orderRepository.delete(1);
        logger.info("Order has been deleted!");
        orderRepository.update("Roses", 3, 2);
        logger.info("Order has been updated!");
        System.out.println("Orders count = " + String.valueOf(orderRepository.getCount()));
    }

    public static void main(String... args) throws SQLException {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        SpringExampleProperties main = (SpringExampleProperties)context.getBean("exampleApp");
        main.run(context);
    }

}
