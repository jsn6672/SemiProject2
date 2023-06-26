package com.jsn.main;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DrinkSearchC")
public class DrinkSearchC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String country = (String) request.getSession().getAttribute("country");
		if (country == null) {
			Login.KoreanPage(request);
		}
		if (country.equals("korean")) {
			BrewerDAO.brewerSearch(request);
			BrewerDAO.seedrink(request);
			BrewerDAO.listPaging(Integer.parseInt(request.getParameter("listp")), request);
			BrewerDAO.ReadReview(request);
			ArrayList<String> jsnr = (ArrayList<String>) request.getAttribute("review");
			if (jsnr != null && !jsnr.isEmpty()) {
				BrewerDAO.reviewPaging(1, request);
			}
		} else {
			BrewerDAO.brewerSearchJp(request);
			BrewerDAO.seedrinkJp(request);
			BrewerDAO.listPaging(Integer.parseInt(request.getParameter("listp")), request);
			BrewerDAO.ReadReviewJp(request);
			ArrayList<String> jsnr = (ArrayList<String>) request.getAttribute("review");
			if (jsnr != null && !jsnr.isEmpty()) {
				BrewerDAO.reviewPaging(1, request);
			}
		}
		request.setAttribute("detailPage", "drinkdetail_review.jsp");
		request.getRequestDispatcher("jsn/jsp/drinkdetail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
