package com.Kamil.Utils;

import com.Kamil.Model.User;

import java.sql.*;

public class JDBC_OPERATIONS {
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/todoapp","root","root");
            return connection;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    public  static int prepareStatement(User user) throws SQLException {
//        int result = 0;
//
//        PreparedStatement preparedStatement = getConnection().prepareStatement(
//                "insert into users(full_name,email,username,`password`)\n" +
//                "values (?,?,?,?)");
//        preparedStatement.setString(1, user.getFull_name());
//        preparedStatement.setString(2, user.getEmail());
//        preparedStatement.setString(3, user.getUsername());
//        preparedStatement.setString(4, user.getPassword());
//         result = preparedStatement.executeUpdate();
//
//        return result;
//    }
}
