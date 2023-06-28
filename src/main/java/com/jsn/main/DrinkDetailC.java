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
//	번역, 디테일페이지 컨트롤러
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String language = request.getParameter("language");

		if (language.equals("1")) {
			drinkSession.ChangeCountry(request);
		}
		String country = (String) request.getSession().getAttribute("country");
		if (country == null) {
			drinkSession.KoreanPage(request);
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
