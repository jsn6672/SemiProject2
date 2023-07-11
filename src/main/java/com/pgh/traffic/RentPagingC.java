package com.pgh.traffic;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jh.login.AccountDAO;

@WebServlet("/RentPagingC")
public class RentPagingC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int listP = Integer.parseInt(request.getParameter("listp"));
		int reviewP = Integer.parseInt(request.getParameter("reviewp"));
	
		AccountDAO.logincontentCheck(request);
		
		String gh_lang = request.getSession().getAttribute("language").toString();
		System.out.println("============");
		System.out.println(gh_lang);
		System.out.println("============");
		if (gh_lang.equals("jp")) {
			RentShopDAO.allRentShopJP(request);
			RentShopDAO.detailRentShopJP(request);
			RentReviewDAO.allReviewJP(request);
			request.setAttribute("contentPage", "rentShopResult_JP.jsp");
			request.setAttribute("detailPage", "rentShopDetail_JP.jsp");
			request.getRequestDispatcher("gh/jsp/rentShop_JP.jsp").forward(request, response);
		} else if (gh_lang.equals("kr")) {
			RentShopDAO.allRentShop(request);
			RentShopDAO.detailRentShop(request);
			RentReviewDAO.allReview(request);
			request.setAttribute("contentPage", "rentShopResult.jsp");
			request.setAttribute("detailPage", "rentShopDetail.jsp");
			request.getRequestDispatcher("gh/jsp/rentShop.jsp").forward(request, response);
		}
		RentShopDAO.paging(listP,request);
		ArrayList<String> review = (ArrayList<String>) request.getAttribute("rentReviews");
		if (review != null && !review.isEmpty()) {
			RentReviewDAO.reviewPaging(reviewP, request);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
