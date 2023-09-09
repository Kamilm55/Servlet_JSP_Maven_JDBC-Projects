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
            case "/setTodoForEditOption":
                setTodoForEditOption(session,req,resp);
                break;
            case "/edit":
                editTodo(session,req,resp);
                break;
            case "/delete":
                deleteTodo(session,req,resp);
                break;
            case "/AddButton":
                addButton(session,req,resp);
                break;
            default:
                resp.sendRedirect("../MainPage.jsp");
                break;
        }

    }
    protected void addButton(HttpSession session, HttpServletRequest req, HttpServletResponse resp) throws IOException{
        session.removeAttribute("todo");
        resp.sendRedirect("../TodoForm.jsp");
    }
    protected void editTodo(HttpSession session, HttpServletRequest req, HttpServletResponse resp) throws IOException    {
        long id = Integer.parseInt(req.getParameter("id"));
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        boolean status = Boolean.parseBoolean(req.getParameter("isDone"));
        LocalDate targetDate = LocalDate.parse(req.getParameter("targetDate"));
        User user = (User)session.getAttribute("user");

        Todo todo = new Todo(id,title, user.getEmail(), description,targetDate,status);

        try {
            todoDao.updateTodo(todo);
            todoDao.setListTodo(session);
            session.removeAttribute("todo");
            resp.sendRedirect("../MainPage.jsp");
        } catch (SQLException e) {
            resp.sendRedirect("./Error.jsp");
//            throw new RuntimeException(e);
        }
    }
    protected void setTodoForEditOption(HttpSession session, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        long id = Integer.parseInt(req.getParameter("id"));
        Todo todo;
        try {
             todo = todoDao.getTodo(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        session.setAttribute("todo" , todo);
        resp.sendRedirect("../TodoForm.jsp");
    }
    protected  void deleteTodo(HttpSession session,HttpServletRequest req, HttpServletResponse resp) throws IOException {
        long id = Integer.parseInt(req.getParameter("id"));

        try {
            todoDao.deleteTodo(id);
            todoDao.setListTodo(session);
            resp.sendRedirect("../MainPage.jsp");
        } catch (SQLException e) {
            resp.sendRedirect("./Error.jsp");
            throw new RuntimeException(e);
        }

    }
    protected void insertTodo(HttpSession session,HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        session.removeAttribute("todo");
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
