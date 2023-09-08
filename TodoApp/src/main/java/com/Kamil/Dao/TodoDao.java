package com.Kamil.Dao;

import com.Kamil.Model.Todo;
import jakarta.servlet.http.HttpSession;

import java.sql.SQLException;
import java.util.List;

public interface TodoDao {
    Todo getTodo(long todoId);
    List<Todo> getAllTodos(HttpSession session) throws SQLException;
    void insertTodo(Todo todo) throws SQLException;
    boolean deleteTodo() throws SQLException;
    boolean updateTodo(Todo todo) throws SQLException;
    void setListTodo(HttpSession session) throws SQLException;
}
