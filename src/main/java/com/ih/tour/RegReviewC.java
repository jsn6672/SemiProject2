package com.ih.tour;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jh.login.AccountDAO;


@WebServlet("/RegReviewC")
public class RegReviewC extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccountDAO.loginCheck(request);
	    ArrayList<Reviews> reviews = ReviewTDAO.getReview(request);
	    System.out.println("review = "+reviews);
	    request.setAttribute("contentPage", "tour.jsp");
	    request.getRequestDispatcher("ih/index.jsp").forward(request, response);
	    // 나머지 코드
	}
	
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		AccountDAO.loginCheck(request);
		ReviewTDAO.regReview(request);
		response.sendRedirect("tourC");
	//	request.setAttribute("contentPage", "tour.jsp");
	//	request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

}
