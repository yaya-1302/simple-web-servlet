package com.enigma.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "loginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private static final String USER_ID = "admin";
    private static final String PASSWORD = "password";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");

        if (USER_ID.equals(userId) && PASSWORD.equals(password)) {
            request.getSession().setAttribute("username", userId);
            response.sendRedirect("home");
        } else {
            response.sendRedirect("login.jsp?error=Invalid+credentials");
        }
    }
}
