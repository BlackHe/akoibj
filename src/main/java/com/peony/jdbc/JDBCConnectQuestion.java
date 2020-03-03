package com.peony.jdbc;

import com.mysql.jdbc.Driver;

import java.sql.*;
import java.util.Properties;

/**
 * JDBC原生，操作数据库
 */
public class JDBCConnectQuestion {

    final static String URL = "jdbc:mysql://127.0.0.1:3306/albertNlg";
    final static String USER = "root";
    final static String PASSWORD = "123456";

    public static void main(String[] args) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        // 1.加载驱动类
        Class.forName("com.mysql.jdbc.Driver");
        // 2.获取数据库连接
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        // 3.获取数据库操作对象
        Statement statement = connection.createStatement();
        // 4.执行查询，获取结果集对象
        ResultSet resultSet = statement.executeQuery("select * from book ");
        // 5.解析结果集对象
        while (resultSet.next()) {
            System.out.printf("id = [%s],name = [%s]\n", resultSet.getInt("id"), resultSet.getString("name"));
        }
        resultSet.close();
        statement.close();
        connection.close();
    }
}
