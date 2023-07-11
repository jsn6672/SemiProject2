package com.hm.room;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jh.login.AccountDAO;

@WebServlet("/reviewlistC")
public class reviewlistC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccountDAO.logintourCheck(request);
		System.out.println("컨트롤러 확인");
		DAOreview.getReview(request);
		DAOroom.getAllRoom(request);
	
	request.setAttribute("contentPage","jsp/hotelmain.jsp");
	request.getRequestDispatcher("hm/index.jsp").forward(request, response);
	}

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("2");
	DAOreview.getReview(request);
	DAOroom.getAllRoom(request);
	request.setAttribute("contentPage", "jsp/hotelmain.jsp");
	request.getRequestDispatcher("hm/index.jsp").forward(request, response);
	}

}
