package com.Kamil.Dao;

import com.Kamil.Model.Todo;

import java.sql.SQLException;
import java.util.List;

public interface TodoDao {
    Todo getTodo(long todoId);
    List<Todo> getAllTodos();
    void insertTodo(Todo todo) throws SQLException;
    boolean deleteTodo() throws SQLException;
    boolean updateTodo(Todo todo) throws SQLException;

}
