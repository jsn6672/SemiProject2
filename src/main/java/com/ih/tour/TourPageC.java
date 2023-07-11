package com.ih.tour;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/TourPageC")
public class TourPageC extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//paging 하려면 전체조회
		TourDAO.getAllTour(request);
		
		
		String pStr = request.getParameter("p");
		int p = 1; // default page
		if (pStr != null && !pStr.isEmpty()) {
			try {
				p = Integer.parseInt(pStr);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		
		
		TourDAO.paging(p, request);
		
		request.setAttribute("contentPage", "tour.jsp");
		request.getRequestDispatcher("ih/index.jsp").forward(request, response);
	}
}