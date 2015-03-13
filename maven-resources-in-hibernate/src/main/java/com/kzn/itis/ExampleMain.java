package com.kzn.itis;

import com.kzn.itis.db.model.User;
import com.kzn.itis.db.repositories.UserRepository;
import com.kzn.itis.db.repositories.impl.UserRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class ExampleMain {

    private static final Logger logger = LoggerFactory.getLogger(ExampleMain.class);

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

    public static String insertStudents(int id, String LastName,
                                        String FirstName, Statement stmt) {
        String sql = "INSERT INTO STUDENTS VALUES (" + id + ",'" + LastName
                + "','" + FirstName + "')";
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sql;
    }


    public static void main(String... args) throws SQLException {
        logger.info("Welcome to Example Application");

        UserRepository userRepository = new UserRepositoryImpl();

        User user = new User();
        user.setAge(25);
        user.setFirstname("James");
        user.setLastname("Bond");

        userRepository.addUser(user);

        logger.info("User has been added!");

        long count = userRepository.getCount();

        logger.info("New count: " + String.valueOf(count));


        //String url = "jdbc:derby:./db_dev; create = true";
        InputStream fis = ExampleMain.class.getResourceAsStream("/derby.properties");
        Properties prop = new Properties();
        try {
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Connection con = null;
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            con = DriverManager.getConnection(prop.getProperty("connectionUrl"));
            Statement stmt = con.createStatement();
			/*String sql1 = "CREATE TABLE ORDERS (" + "Id INTEGER not NULL,"
					+ " CustomerId INTEGER not NULL,"
					+ "SalersPersonalId INTEGER not NULL,"
					+ "TotalAmount INTEGER not NULL," + " PRIMARY KEY (Id))";
			stmt.executeUpdate(sql1);
			insertOrders(1, 1, 5, 200, stmt);
			insertOrders(2, 2, 6, 300, stmt);
			insertOrders(3, 3, 7, 400, stmt);
			String sql2 = "CREATE TABLE STUDENTS (" + "id INTEGER not NULL,"
					+ " LastName VARCHAR(256),"
					+ " FirstName VARCHAR(256), PRIMARY KEY (id))";
			stmt.executeUpdate(sql2);
			insertStudents(1, "Fam1", "Name1", stmt);
			insertStudents(2, "Fam2", "Name2", stmt);
			insertStudents(3, "Fam3", "Name3", stmt);
			insertStudents(4, "Fam4", "Name4", stmt);
			insertStudents(5, "Fam5", "Name5", stmt);
			insertStudents(6, "Fam6", "Name6", stmt);
			insertStudents(7, "Fam7", "Name7", stmt);*/
            String sql = "SELECT s.LastName || ' ' || s.FirstName Name, o.TotalAmount FROM STUDENTS s LEFT JOIN Orders o ON o.Customerid = s.id";
            ResultSet res = stmt.executeQuery(sql);
            while (res.next()) {
                System.out.println(res.getString(1) + " " + res.getString(2));
            }
			/*String sql3 = "DROP TABLE STUDENTS";
			stmt.executeUpdate(sql3);
			String sql4 = "DROP TABLE ORDERS";
			stmt.executeUpdate(sql4);*/
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
            }
        }

    }
}
