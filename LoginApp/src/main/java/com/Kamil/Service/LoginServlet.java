package com.Kamil.Service;

import com.Kamil.Bean.Student;
import com.Kamil.Dao.StudentDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {

    StudentDao studentDao = new StudentDao();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");

          Student student = studentDao.check(name,password);

        if(student != null){
            req.setAttribute("student",student);
            RequestDispatcher rd = req.getRequestDispatcher("./LoginSuccess.jsp");
            rd.forward(req,resp);
        }
        else {
            System.out.println("Login fail");
            RequestDispatcher rd = req.getRequestDispatcher("./LoginFail.jsp");
            rd.forward(req,resp);
        }
    }
}
