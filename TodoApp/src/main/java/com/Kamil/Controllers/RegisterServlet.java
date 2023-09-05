package com.Kamil.Controllers;

import com.Kamil.Dao.UserDao;
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

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
    UserDao userDao = new UserDao();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

         String full_name = req.getParameter("fullName");
         String email =req.getParameter("email");
         String username=req.getParameter("userName");
         String password=req.getParameter("password");

        User user = userDao.setUserCredentials(full_name,email,username,password);

        HttpSession session = req.getSession();
        try {
            int isRegister = userDao.register(user);
//            System.out.println(isRegister + "row(s) affected");

            //use session(resp.sendRedirect) or req.attribute:
            // check user has or not ?

            session.setAttribute("user",user);
            resp.sendRedirect("./MainPage.jsp");
        } catch (SQLException e) {
            //Create error page and write all error inside it
            System.out.println("error: " + e.getMessage());
            session.setAttribute("error", e.getMessage());
            resp.sendRedirect("./Error.jsp");
//            throw new RuntimeException(e);
        }
    }
}
