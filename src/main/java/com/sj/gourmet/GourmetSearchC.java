package com.sj.gourmet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GourmetSearchC")
public class GourmetSearchC extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GourmetM.searchGourmet(request, response);
//		GourmetM.getAllReview(request);
		request.getRequestDispatcher("sj/gourmetjsp/gourmetResult.jsp").forward(request, response);
	}

}
