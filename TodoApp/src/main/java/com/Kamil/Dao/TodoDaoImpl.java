package com.Kamil.Dao;

import com.Kamil.Model.Todo;
import com.Kamil.Model.User;
import com.Kamil.Utils.JDBC_OPERATIONS;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TodoDaoImpl implements TodoDao {
    private static String INSERT_TODO_SQL = "INSERT INTO todos(title, email, description, target_date,  is_done) values (?, ?, ?, ?, ?);";
    private static String SHOW_ALL_TODOS_SQL = "SELECT * FROM todos where email = ?";


    @Override
    public Todo getTodo(long todoId) {
        return null;
    }

    @Override
    public List<Todo> getAllTodos(HttpSession session ) throws SQLException {
        PreparedStatement preparedStatement = JDBC_OPERATIONS.getConnection().prepareStatement(SHOW_ALL_TODOS_SQL);
         User user = (User) session.getAttribute("user");
        preparedStatement.setString(1,user.getEmail());
        ResultSet rs = preparedStatement.executeQuery();

        if(rs.next()){
            List<Todo> listTodo = new ArrayList<>();

            do{
                long id = rs.getLong("id");
                String title =   rs.getString("title");
                String email =  rs.getString("email");
                String description =  rs.getString("description");
                LocalDate target_date = rs.getDate("target_date").toLocalDate();
                boolean is_done =  rs.getBoolean("is_done");
                Todo todo = new Todo(id,title,email,description,target_date,is_done);
                listTodo.add(todo);
            }
            while (rs.next());


            return listTodo;
        }
        else {
            throw new SQLException("There is no todos in your account");
        }
    }

    @Override
    public void insertTodo(Todo todo) throws SQLException {
        PreparedStatement preparedStatement = JDBC_OPERATIONS.getConnection().prepareStatement(INSERT_TODO_SQL);
        preparedStatement.setString(1,todo.getTitle());
        preparedStatement.setString(2,todo.getEmail());
        preparedStatement.setString(3,todo.getDescription());
        preparedStatement.setString(4,todo.getTargetDate().format(DateTimeFormatter.ofPattern("dd-MMM-yy")));
        preparedStatement.setBoolean(5,todo.getStatus());
        int result = preparedStatement.executeUpdate();
        System.out.println(result + "row(s) inserted");
    }

    @Override
    public boolean deleteTodo() throws SQLException {
        return false;
    }

    @Override
    public boolean updateTodo(Todo todo) throws SQLException {
        return false;
    }
}
