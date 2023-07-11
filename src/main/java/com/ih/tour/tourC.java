package com.ih.tour;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import com.jh.login.AccountDAO;

@WebServlet("/tourC")
public class tourC extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccountDAO.logintourCheck(request);
		TourDAO.getAllTour(request);
		TourDAO.paging(1, request);
		request.setAttribute("contentPage", "tour.jsp");
		request.getRequestDispatcher("ih/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
