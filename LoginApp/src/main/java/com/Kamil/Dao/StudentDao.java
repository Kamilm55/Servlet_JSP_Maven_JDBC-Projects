package com.Kamil.Dao;

import com.Kamil.Bean.Student;
import java.sql.*;

public class StudentDao {
    public Student check(String userName,String userPassword){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/resumeapp","root","root");
            PreparedStatement preparedStatement = connection.prepareStatement("select * from students where userName=? and userPassword=?");
            preparedStatement.setString(1,userName);
            preparedStatement.setString(2,userPassword);
            ResultSet rs = preparedStatement.executeQuery();

            if(rs.next()){
                Student student = new Student();
                String name = rs.getString("userName");
                String pass = rs.getString("userPassword");
                student.setUserName(name);
                student.setUserPassword(pass);
                return student;
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }
}
