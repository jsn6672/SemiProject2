package com.hm.room;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/reviewDeleteC")
public class reviewDeleteC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	DAOreview.deleteReview(request);
	DAOroom.getAllRoom(request);
	DAOreview.getReview(request);	
	request.setAttribute("contentPage", "jsp/hotelmain.jsp");
	request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
