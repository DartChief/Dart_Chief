package com.kzn.itis;

import com.kzn.itis.db.config.DatabaseConfiguration;
import com.kzn.itis.db.model.Order;
import com.kzn.itis.db.model.User;
import com.kzn.itis.db.repositories.OrderRepository;
import com.kzn.itis.db.repositories.UserRepository;
import com.kzn.itis.db.repositories.impl.OrderRepositoryImpl;
import com.kzn.itis.db.repositories.impl.UserRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 */
public class SpringExampleProperties {

    private static final Logger logger = LoggerFactory.getLogger(SpringExampleProperties.class);

    @Autowired
    private DatabaseConfiguration config;

    public DatabaseConfiguration getConfig() {
        return config;
    }

    public void setConfig(DatabaseConfiguration config) {
        this.config = config;
    }

    public static String insertOrders(int id, int CustomerId,
                                      int SalersPersonalId, int TotalAmount, Statement stmt) {
        String sql = "INSERT INTO ORDERS VALUES (" + id + "," + CustomerId
                + "," + SalersPersonalId + "," + TotalAmount + ")";
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sql;
    }

    public static String insertUsers(int id, String LastName,
                                        String FirstName, Statement stmt) {
        String sql = "INSERT INTO USERS VALUES (" + id + ",'" + LastName
                + "','" + FirstName + "')";
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sql;
    }

    public void run() throws SQLException {

        logger.info("Welcome to Example Application");
        logger.info("url=" + config.getDbUrl());
        logger.info("username=" + config.getDbUser());

//        Map<String, Object> configOverrides = new HashMap<String, Object>();
//        configOverrides.put("connection.url", config.getDbUrl());
//        configOverrides.put("connection.username", config.getDbUser());
//        configOverrides.put("connection.password", config.getDbPassword());
//        configOverrides.put("hbm2ddl.auto", config.getDbHbm2ddl());
//        SessionUtil.getEntityManagerFactory(configOverrides);

//        Connection con = null;
//        try {
//            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
//            con = DriverManager.getConnection(config.getDbUrl());
//            Statement stmt = con.createStatement();
//            String sql1 = "CREATE TABLE ORDERS (" + "Id INTEGER not NULL,"
//                    + " CustomerId INTEGER not NULL,"
//                    + "SalersPersonalId INTEGER not NULL,"
//                    + "TotalAmount INTEGER not NULL," + " PRIMARY KEY (Id))";
//            stmt.executeUpdate(sql1);
//            insertOrders(1, 1, 5, 200, stmt);
//            insertOrders(2, 2, 6, 300, stmt);
//            insertOrders(3, 3, 7, 400, stmt);
//            String sql2 = "CREATE TABLE USERS (" + "id INTEGER not NULL,"
//                    + " LastName VARCHAR(256),"
//                    + " FirstName VARCHAR(256), PRIMARY KEY (id))";
//            stmt.executeUpdate(sql2);
//            insertUsers(1, "Fam1", "Name1", stmt);
//            insertUsers(2, "Fam2", "Name2", stmt);
//            insertUsers(3, "Fam3", "Name3", stmt);
//            insertUsers(4, "Fam4", "Name4", stmt);
//            insertUsers(5, "Fam5", "Name5", stmt);
//            insertUsers(6, "Fam6", "Name6", stmt);
//            insertUsers(7, "Fam7", "Name7", stmt);
//            String sql = "SELECT s.LastName || ' ' || s.FirstName Name, o.TotalAmount FROM USERS s LEFT JOIN Orders o ON o.Customerid = s.id";
//            ResultSet res = stmt.executeQuery(sql);
//            while (res.next()) {
//                System.out.println(res.getString(1) + " " + res.getString(2));
//            }
//            String sql3 = "DROP TABLE USERS";
//            stmt.executeUpdate(sql3);
//            String sql4 = "DROP TABLE ORDERS";
//            stmt.executeUpdate(sql4);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            assert con != null;
//            con.close();
//        }

        testDBUser();
        testDBOrder();
    }



    protected void testDBUser() {
        UserRepository userRepository = new UserRepositoryImpl();

        User user = new User();
        user.setAge(35);
        user.setFirstname("Sherlock");
        user.setLastname("Holmes");

        userRepository.addUser(user);

        logger.info("User has been added!");

        long count = userRepository.getCount();

        logger.info("New count: " + String.valueOf(count));
    }

    protected void testDBOrder() {

        OrderRepository orderRepository = new OrderRepositoryImpl();

        Order order = new Order();
        order.setCustomerId(123);

        orderRepository.addOrder(order);

        logger.info("Order has been added!");

        long count = orderRepository.getCount();

        logger.info("New count: " + String.valueOf(count));
    }

    public static void main(String... args) throws SQLException {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        SpringExampleProperties main = (SpringExampleProperties)context.getBean("exampleApp");
        main.run();
    }
}
