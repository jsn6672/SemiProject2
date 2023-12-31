package com.jsn.main;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jh.login.AccountDAO;

@WebServlet("/DrinkSearchC")
public class DrinkSearchC extends HttpServlet {
//	검색창 컨트롤러
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String country = (String) request.getSession().getAttribute("country");

		if (country == null) {
			drinkSession.KoreanPage(request);
		}
		AccountDAO.logincontentCheck(request);
		if (country.equals("korean")) {
			BrewerDAO.brewerSearch(request);
			String notfound = (String) request.getAttribute("notfound");
			System.out.println("andigh"+notfound);
			if (notfound != null) {
				response.sendRedirect("JsnHC");
				return;
			} else {
				drinkSession.SearchResult(request);
				BrewerDAO.seedrink(request);
				BrewerDAO.listPaging(1, request);
				BrewerDAO.ReadReview(request);
				ArrayList<String> jsnr = (ArrayList<String>) request.getAttribute("review");
				if (jsnr != null && !jsnr.isEmpty()) {
					System.out.println("리뷰 있음");
					BrewerDAO.reviewPaging(1, request);
				}
			}
			request.setAttribute("detailPage", "drinksearch_review.jsp");
			request.getRequestDispatcher("jsn/jsp/drinksearch.jsp").forward(request, response);
		} else {
			BrewerDAO.brewerSearchJp(request);
			String notfound = (String) request.getAttribute("notfound");
			if (notfound != null) {
				response.sendRedirect("JsnHC");
				return;
			} else {
				drinkSession.SearchResult(request);
				BrewerDAO.seedrinkJp(request);
				BrewerDAO.listPaging(1, request);
				BrewerDAO.ReadReviewJp(request);
				ArrayList<String> jsnr = (ArrayList<String>) request.getAttribute("review");
				if (jsnr != null && !jsnr.isEmpty()) {
					BrewerDAO.reviewPaging(1, request);
				}
				request.setAttribute("detailPage", "drinkdetail_review_jp.jsp");
				request.getRequestDispatcher("jsn/jsp/drinkdetail_jp.jsp").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
