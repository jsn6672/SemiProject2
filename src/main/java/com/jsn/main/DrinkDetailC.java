package com.jsn.main;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DrinkDetailC")
public class DrinkDetailC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String language = request.getParameter("language");
		
		if (language.equals("1")) {
			Login.ChangeCountry(request);			
		}
		String country = (String) request.getSession().getAttribute("country");
		if (country == null) {
			Login.KoreanPage(request);
		}
		if (country.equals("korean")) {
			BrewerDAO.brewer(request);
			BrewerDAO.seedrink(request);
			BrewerDAO.ReadReview(request);
			ArrayList<String> jsnr = (ArrayList<String>) request.getAttribute("review");
			if (jsnr != null && !jsnr.isEmpty()) {
				BrewerDAO.reviewPaging(1, request);				 
			}
			BrewerDAO.listPaging(Integer.parseInt(request.getParameter("listp")), request);
		} else {
			BrewerDAO.brewerJp(request);
			BrewerDAO.seedrinkJp(request);
			BrewerDAO.ReadReviewJp(request);
			ArrayList<String> jsnr = (ArrayList<String>) request.getAttribute("review");
			if (jsnr != null && !jsnr.isEmpty()) {
				BrewerDAO.reviewPaging(1, request);				 
			}
			BrewerDAO.listPaging(Integer.parseInt(request.getParameter("listp")), request);
		}
		request.setAttribute("detailPage", "drinkdetail_review.jsp");
		request.getRequestDispatcher("jsn/jsp/drinkdetail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
