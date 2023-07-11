package com.sj.gourmet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jh.login.AccountDAO;

@WebServlet("/GourmetReviewC")
public class GourmetReviewC extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccountDAO.logincontentCheck(request);
		GourmetM.regReviewGourmet(request);
		request.getRequestDispatcher("sj/gourmetjsp/gourmetResult.jsp").forward(request, response);
	}
	
}
