package com.jsn.search;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jh.login.AccountDAO;
import com.jsn.main.BrewerDAO;
import com.jsn.main.drinkSession;

@WebServlet("/DrinkSearchListPageC")
public class DrinkSearchListPageC extends HttpServlet {
//	검색한 후 왼쪽 리스트 페이징 컨트롤러
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String country = (String) request.getSession().getAttribute("country");
		if (country == null) {
			drinkSession.KoreanPage(request);
		}
		AccountDAO.logincontentCheck(request);
		if (country.equals("korean")) {
			BrewerDAO.SearchbrewerResult(request);
			BrewerDAO.seedrink(request);
			BrewerDAO.ReadReview(request);
			ArrayList<String> jsnr = (ArrayList<String>) request.getAttribute("review");
			if (jsnr != null && !jsnr.isEmpty()) {
				BrewerDAO.reviewPaging(1, request);
			}
			BrewerDAO.listPaging(Integer.parseInt(request.getParameter("listp")), request);
			request.setAttribute("detailPage", "drinksearch_review.jsp");
			request.getRequestDispatcher("jsn/jsp/drinksearch.jsp").forward(request, response);
		} else {
			BrewerDAO.SearchbrewerResultJp(request);
			BrewerDAO.seedrinkJp(request);
			BrewerDAO.ReadReviewJp(request);
			ArrayList<String> jsnr = (ArrayList<String>) request.getAttribute("review");
			if (jsnr != null && !jsnr.isEmpty()) {
				BrewerDAO.reviewPaging(1, request);
			}
			BrewerDAO.listPaging(Integer.parseInt(request.getParameter("listp")), request);

			request.setAttribute("detailPage", "drinkdetail_review_jp.jsp");
			request.getRequestDispatcher("jsn/jsp/drinkdetail_jp.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
