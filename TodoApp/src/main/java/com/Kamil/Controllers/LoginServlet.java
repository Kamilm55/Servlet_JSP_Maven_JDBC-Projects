package com.Kamil.Controllers;

import com.Kamil.Dao.TodoDao;
import com.Kamil.Dao.TodoDaoImpl;
import com.Kamil.Dao.UserDao;
import com.Kamil.Model.Todo;
import com.Kamil.Model.User;
import com.Kamil.Utils.JDBC_OPERATIONS;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
    UserDao userDao = new UserDao();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email =req.getParameter("email");
        String password=req.getParameter("password");

        User user = null;
        HttpSession session = req.getSession();
        try {
            user = userDao.login(email,password);
            session.setAttribute("user",user);
            TodoDao todoDao = new TodoDaoImpl();
            List<Todo> listTodo = todoDao.getAllTodos(session);
            System.out.println(listTodo);
             session.setAttribute("listTodo",listTodo);
            resp.sendRedirect("./MainPage.jsp");
        } catch (Exception e) {
            System.out.println("Error" + e);
            System.out.println("error message: " + e.getMessage());
            session.setAttribute("error", e.getMessage());
            resp.sendRedirect("./Error.jsp");
        }

    }
}
