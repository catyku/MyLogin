package com.creations.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.creations.ExecuteLogin;

@WebServlet(urlPatterns = { "/login.jsp" })
public class LoginServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ExecuteLogin login = new ExecuteLogin();
        String usr = login.match(request.getParameter("account"), request.getParameter("password"));
        HttpSession session = request.getSession();
        if (usr != null) {
            session.setAttribute("user", usr);
            response.sendRedirect("welcome.html");
        } else {
            response.getWriter().println("帳號或密碼錯誤");
        }
    }
    
}
