package com.jh.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginC")
public class loginC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AccountDAO.logout(request);
		AccountDAO.loginCheck(request);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (AccountDAO.validLogin(request)) {
			AccountDAO.login(request);
			AccountDAO.loginCheck(request);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			
			AccountDAO.loginCheck(request);
		        String errorMessage = "아이디나 암호가 틀렸습니다.";
		        request.setAttribute("errorMessage", errorMessage);
		        request.getRequestDispatcher("index.jsp").forward(request, response);
		    }
		}
		
	}

