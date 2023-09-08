package com.Kamil.Controllers;

import com.Kamil.Dao.TodoDao;
import com.Kamil.Dao.TodoDaoImpl;
import com.Kamil.Model.Todo;
import com.Kamil.Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

@WebServlet("/todo/*")
public class TodoServlet extends HttpServlet {
    private TodoDao todoDao;
    @Override
    public void init() throws ServletException {
         todoDao = new TodoDaoImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getPathInfo();
        HttpSession session = req.getSession();


        switch (action) {
            case "/new":
                insertTodo(session,req,resp);
                break;
            default:
                resp.sendRedirect("./MainPage.jsp");
                break;
        }
    }

    protected void insertTodo(HttpSession session,HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        boolean status = Boolean.parseBoolean(req.getParameter("isDone"));
        LocalDate targetDate = LocalDate.parse(req.getParameter("targetDate"));
        User user = (User)session.getAttribute("user");

        Todo todo = new Todo(user.getEmail(),title,description,targetDate,status);
        try {
            todoDao.insertTodo(todo);
            todoDao.setListTodo(session);
            resp.sendRedirect("../MainPage.jsp");
        } catch (SQLException e) {
            resp.sendRedirect("./Error.jsp");
            throw new RuntimeException(e);
        }
    }
}
