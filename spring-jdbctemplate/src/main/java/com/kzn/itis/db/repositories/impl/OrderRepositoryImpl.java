//package com.kzn.itis.db.repositories.impl;
//
//import com.kzn.itis.db.config.DatabaseConfiguration;
//import com.kzn.itis.db.model.Order;
//import com.kzn.itis.db.repositories.OrderRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.sql.*;
//
//public class OrderRepositoryImpl implements OrderRepository {
//
//    @Autowired
//    private DatabaseConfiguration config;
//
//    @Override
//    public void addOrder(Order order) throws SQLException {
//
//        Connection con = null;
//        try {
//            con  = DriverManager.getConnection(config.getDbUrl());
//            Statement statement = con.createStatement();
//            String sql = "INSERT INTO ORDERS VALUES (DEFAULT ,'" + order.getName()
//                    + "'," + order.getCustomerId() + "," + order.getSalesPersonalId() + ")";
//            statement.executeUpdate(sql);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            assert con != null;
//            con.close();
//        }
//    }
//
//    @Override
//    public void update(String name, int id) throws SQLException {
//        Connection con = null;
//        try {
//            con  = DriverManager.getConnection(config.getDbUrl());
//            Statement statement = con.createStatement();
//            String sql = "UPDATE ORDERS SET Name = '" + name + "'  WHERE Id = " + id;
//            statement.executeUpdate(sql);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            assert con != null;
//            con.close();
//        }
//    }
//
//    @Override
//    public void delete(int id) throws SQLException {
//        Connection con = null;
//        try {
//            con  = DriverManager.getConnection(config.getDbUrl());
//            Statement statement = con.createStatement();
//            String sql = "DELETE FROM ORDERS WHERE  Id = " + id;
//            statement.executeUpdate(sql);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            assert con != null;
//            con.close();
//        }
//    }
//
//    @Override
//    public void showAll() throws SQLException {
//        Connection con = null;
//        try {
//            con = DriverManager.getConnection(config.getDbUrl());
//            Statement statement = con.createStatement();
//            String sql = "SELECT * FROM ORDERS";
//            ResultSet res = statement.executeQuery(sql);
//            while (res.next()) {
//                System.out.println(res.getInt(1) + " " + res.getString(2) + " " + res.getInt(3));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            assert con != null;
//            con.close();
//        }
//    }
//
//    @Override
//    public long getAmount() throws SQLException {
//        Connection con = null;
//        int i = 0;
//        try {
//            con = DriverManager.getConnection(config.getDbUrl());
//            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
//                    ResultSet.CONCUR_READ_ONLY);
//            String sql = "SELECT * FROM ORDERS";
//            ResultSet res = statement.executeQuery(sql);
//            while(res.next()) {
//                i++;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            assert con != null;
//            con.close();
//        }
//        return i;
//    }
//}
