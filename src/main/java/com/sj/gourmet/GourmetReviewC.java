package com.sj.gourmet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GourmetReviewC")
public class GourmetReviewC extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Object storeId = request.getParameter("storeId");
//		GourmetM.getAllReview(request);
		GourmetM.searchGourmet(request, response);
		request.setAttribute("reviewPage", "gourmetReview.jsp");
		request.getRequestDispatcher("sj/gourmetjsp/gourmetResult.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GourmetM.regReviewGourmet(request);
		request.setAttribute("contentPage", "gourmetResult.jsp");
		// request.getRequestDispatcher("sj/gourmetjsp/gourmet.jsp").forward(request, response);
	}
	
}
