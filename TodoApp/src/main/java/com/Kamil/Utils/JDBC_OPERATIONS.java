package com.Kamil.Utils;

import com.Kamil.Model.Todo;
import com.Kamil.Model.User;

import java.sql.*;
import java.time.LocalDate;

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

        public static Todo setAllTodoFields(ResultSet rs) throws SQLException {
            long id = rs.getLong("id");
            String title =   rs.getString("title");
            String email =  rs.getString("email");
            String description =  rs.getString("description");
            LocalDate target_date = rs.getDate("target_date").toLocalDate();
            boolean is_done =  rs.getBoolean("is_done");
            Todo todo = new Todo(id,title,email,description,target_date,is_done);
            return todo;
        }


}
