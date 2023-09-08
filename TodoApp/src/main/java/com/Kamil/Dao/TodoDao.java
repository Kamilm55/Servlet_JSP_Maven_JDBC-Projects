package com.Kamil.Dao;

import com.Kamil.Model.Todo;
import jakarta.servlet.http.HttpSession;

import java.sql.SQLException;
import java.util.List;

public interface TodoDao {
    Todo getTodo(long todoId) throws SQLException;
    List<Todo> getAllTodos(HttpSession session) throws SQLException;
    void insertTodo(Todo todo) throws SQLException;
    void deleteTodo(long todoId) throws SQLException;
    void updateTodo(Todo todo) throws SQLException;
    void setListTodo(HttpSession session) throws SQLException;
}
