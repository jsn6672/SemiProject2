package com.pgh.traffic;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jh.login.AccountDAO;

@WebServlet("/RentShopC")
public class RentShopC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().setAttribute("language", "kr");
		RentShopDAO.allRentShop(request);
		RentShopDAO.detailRentShop(request);
		RentShopDAO.paging(1, request);
		RentReviewDAO.allReview(request);

		ArrayList<String> review = (ArrayList<String>) request.getAttribute("rentReviews");
		if (review != null && !review.isEmpty()) {
			RentReviewDAO.reviewPaging(1, request);
		}
		AccountDAO.logincontentCheck(request);
		request.setAttribute("contentPage", "rentShopResult.jsp");
		request.setAttribute("detailPage", "rentShopDetail.jsp");
		request.getRequestDispatcher("gh/jsp/rentShop.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
