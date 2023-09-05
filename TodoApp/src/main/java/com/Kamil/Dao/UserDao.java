package com.Kamil.Dao;

import com.Kamil.Model.User;
import com.Kamil.Utils.JDBC_OPERATIONS;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public User setUserCredentials(String full_name, String email, String user_name, String password){
        User user = new User();
        user.setFull_name(full_name);
        user.setEmail(email);
        user.setUsername(user_name);
        user.setPassword(password);
        return user;
    }

    public  int register(User user) throws SQLException {

        int result = 0;

        PreparedStatement preparedStatement = JDBC_OPERATIONS.getConnection().prepareStatement(
                "insert into users(full_name,email,username,`password`)\n" +
                        "values (?,?,?,?)");
        preparedStatement.setString(1, user.getFull_name());
        preparedStatement.setString(2, user.getEmail());
        preparedStatement.setString(3, user.getUsername());
        preparedStatement.setString(4, user.getPassword());
        result = preparedStatement.executeUpdate();

        return result;
    }

    public User login(String email  , String password) throws Exception {
        PreparedStatement preparedStatement = JDBC_OPERATIONS.getConnection().prepareStatement("select * from users where email = ? and password = ?");
        preparedStatement.setString(1,email);
        preparedStatement.setString(2,password);
        ResultSet rs = preparedStatement.executeQuery();

        if(rs.next()){
            String full_name = rs.getString("full_name");
            String user_name = rs.getString("username");
            User user = setUserCredentials(full_name,email,user_name,password);
            return user;
        }else{
            throw new Exception("There is no user with this email and password");
        }
    }

}
