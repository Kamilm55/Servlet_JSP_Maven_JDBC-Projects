package com.Kamil.Dao;

import com.Kamil.Model.Todo;
import com.Kamil.Utils.JDBC_OPERATIONS;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TodoDaoImpl implements TodoDao {
    private static String INSERT_TODO_SQL = "INSERT INTO todos(title, email, description, target_date,  is_done) values (?, ?, ?, ?, ?);";
    @Override
    public Todo getTodo(long todoId) {
        return null;
    }

    @Override
    public List<Todo> getAllTodos() {
        return null;
    }

    @Override
    public void insertTodo(Todo todo) throws SQLException {
        PreparedStatement preparedStatement = JDBC_OPERATIONS.getConnection().prepareStatement(INSERT_TODO_SQL);
        preparedStatement.setString(1,todo.getTitle());
        preparedStatement.setString(1,todo.getEmail());
        preparedStatement.setString(1,todo.getDescription());
        preparedStatement.setString(1,todo.getTargetDate().format(DateTimeFormatter.ofPattern("dd-MMM-yy")));
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
