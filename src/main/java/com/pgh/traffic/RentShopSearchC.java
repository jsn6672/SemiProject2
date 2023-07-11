package com.pgh.traffic;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jh.login.AccountDAO;

@WebServlet("/RentShopSearchC")
public class RentShopSearchC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		ArrayList<String> searchResult = (ArrayList<String>) request.getAttribute("rentShops");
		if (searchResult == null || searchResult.isEmpty()) {
			RentShopDAO.allRentShop(request);
		}
		RentShopDAO.paging(1, request);
		AccountDAO.logincontentCheck(request);
		String gh_lang = request.getSession().getAttribute("language").toString();
		if (gh_lang.equals("jp")) {
			RentShopDAO.searchRentShopJP(request);
			RentShopDAO.detailRentShopJP(request);
			RentReviewDAO.allReviewJP(request);
			request.setAttribute("contentPage", "rentShopSearchResult_JP.jsp");
			request.setAttribute("detailPage", "rentShopSearchDetail_JP.jsp");
			request.getRequestDispatcher("gh/jsp/rentShop_JP.jsp").forward(request, response);
		} else if (gh_lang.equals("kr")) {
			RentShopDAO.searchRentShop(request);
			RentShopDAO.detailRentShop(request);
			RentReviewDAO.allReview(request);
			request.setAttribute("contentPage", "rentShopSearchResult.jsp");
			request.setAttribute("detailPage", "rentShopSearchDetail.jsp");
			request.getRequestDispatcher("gh/jsp/rentShop.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
