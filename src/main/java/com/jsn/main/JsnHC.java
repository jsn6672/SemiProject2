package com.jsn.main;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JsnHC")
public class JsnHC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		drinkSession.KoreanPage(request);
//		BrewerDAO.brewer(request);

		String country = (String) request.getSession().getAttribute("country");
		if (country.equals("korean")) {
			BrewerDAO.brewerHC(request);
			BrewerDAO.seedrink(request);
			BrewerDAO.ReadReview(request);
			ArrayList<String> jsnr = (ArrayList<String>) request.getAttribute("review");
			if (jsnr != null && !jsnr.isEmpty()) {
				System.out.println("리뷰 있음");
				BrewerDAO.reviewPaging(1, request);
			}else {
				System.out.println("리뷰 없음");
			}
			
//			ArrayList jsnr = (ArrayList) request.getAttribute("review");
//			if (jsnr.size() != 0) {
//				BrewerDAO.reviewPaging(1, request);
//			}
			BrewerDAO.listPaging(1, request);
		} else {
			BrewerDAO.brewerHCJp(request);
			BrewerDAO.seedrinkJp(request);
			BrewerDAO.ReadReviewJp(request);
			ArrayList<String> jsnr = (ArrayList<String>) request.getAttribute("review");
			if (jsnr != null && !jsnr.isEmpty()) {
				BrewerDAO.reviewPaging(1, request);
			}
			BrewerDAO.listPaging(1, request);
		}
		request.setAttribute("detailPage", "drinkdetail_review.jsp");
		request.getRequestDispatcher("jsn/jsp/drinkdetail.jsp").forward(request, response);

//		request.getRequestDispatcher("jsn/jsp/drink.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
