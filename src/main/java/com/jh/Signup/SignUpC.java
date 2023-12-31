package com.jh.Signup;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jh.login.AccountDAO;

@WebServlet("/SignUpC")


public class SignUpC extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         int idCheck = SignUpDAO.idcheck(request);
         response.getWriter().write(String.valueOf(idCheck));
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		SignUpDAO.signup(request);
		AccountDAO.loginCheck(request);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}