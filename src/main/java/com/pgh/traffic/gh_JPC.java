package com.pgh.traffic;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jh.login.AccountDAO;

@WebServlet("/gh_JPC")
public class gh_JPC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RentShopDAO.setDB();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().setAttribute("language", "jp");
		RentShopDAO.allRentShopJP(request);
		RentShopDAO.detailRentShopJP(request);
		RentReviewDAO.allReviewJP(request);
		RentShopDAO.paging(1, request);
		ArrayList<String> review = (ArrayList<String>) request.getAttribute("rentReviews");
		if (review != null && !review.isEmpty()) {
			RentReviewDAO.reviewPaging(1, request);
		}
		AccountDAO.logincontentCheck(request);
		request.setAttribute("contentPage", "rentShopResult_JP.jsp");
		request.setAttribute("detailPage", "rentShopDetail_JP.jsp");
		request.getRequestDispatcher("gh/jsp/rentShop_JP.jsp").forward(request, response);
	}

}
