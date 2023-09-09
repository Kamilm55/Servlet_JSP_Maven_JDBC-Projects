package com.Kamil.Dao;

import com.Kamil.Model.Todo;
import com.Kamil.Model.User;
import com.Kamil.Utils.JDBC_OPERATIONS;
import jakarta.servlet.http.HttpSession;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TodoDaoImpl implements TodoDao {
    private static String INSERT_TODO_SQL = "INSERT INTO todos(title, email, description, target_date,  is_done) values (?, ?, ?, ?, ?);";
    private static String SHOW_ALL_TODOS_SQL = "SELECT * FROM todos where email = ?";
    private static  String GET_ONE_TODO_WITH_ID_SQL = "select * from todos where id = ?";
    private static  String UPDATE_ONE_TODO_SQL = "Update todos " +
            "SET title = ? , description = ? ,target_date = ? ,is_done = ?  where id = ?;";
    private static  String DELETE_ONE_TODO_WITH_ID_SQL = "DELETE FROM todos WHERE id = ?;";
    @Override
    public Todo getTodo(long todoId) throws SQLException {
        PreparedStatement preparedStatement = JDBC_OPERATIONS.getConnection().prepareStatement(GET_ONE_TODO_WITH_ID_SQL);
        preparedStatement.setLong(1,todoId);
        ResultSet rs = preparedStatement.executeQuery();

        if (rs.next()){
            Todo todo = JDBC_OPERATIONS.setAllTodoFields(rs);
            return todo;
        }else{
            throw new RuntimeException("There is no todo with this id");
        }
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
              Todo todo = JDBC_OPERATIONS.setAllTodoFields(rs);
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
        preparedStatement.setObject(4,todo.getTargetDate());
        preparedStatement.setBoolean(5,todo.getStatus());
        int result = preparedStatement.executeUpdate();
        System.out.println(result + "row(s) inserted");
    }

    @Override
    public void setListTodo(HttpSession session) throws SQLException {
        List<Todo> listTodo = this.getAllTodos(session);
        session.setAttribute("listTodo",listTodo);
    }

    @Override
    public void deleteTodo(long todoId) throws SQLException {
        PreparedStatement preparedStatement = JDBC_OPERATIONS.getConnection().prepareStatement(DELETE_ONE_TODO_WITH_ID_SQL);
        preparedStatement.setLong(1,todoId);
        int result = preparedStatement.executeUpdate();
        System.out.println(result + " row(s) deleted where id = " + todoId);
    }

    @Override
    public void updateTodo(Todo todo) throws SQLException {
        PreparedStatement preparedStatement = JDBC_OPERATIONS.getConnection().prepareStatement(UPDATE_ONE_TODO_SQL);
        preparedStatement.setString(1,todo.getTitle());
        preparedStatement.setString(2,todo.getDescription());
        preparedStatement.setObject(3,todo.getTargetDate());
        preparedStatement.setBoolean(4,todo.getStatus());
        preparedStatement.setLong(5,todo.getId());
        int result = preparedStatement.executeUpdate();
        System.out.println(result + " row(s) updated where id = " + todo.getId());
    }
}
