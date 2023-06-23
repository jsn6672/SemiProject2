package com.jsn.main;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DrinkReviewC")
public class DrinkReviewC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String country = (String) request.getSession().getAttribute("country");
		if (country.equals("korean")) {
			BrewerDAO.brewer(request);
			BrewerDAO.seedrink(request);
			BrewerDAO.ReadReview(request);
			ArrayList jsnr = (ArrayList)request.getAttribute("review");
			if (jsnr.size() != 0) {			 
				BrewerDAO.reviewPaging(Integer.parseInt(request.getParameter("p")), request);
			}
			BrewerDAO.listPaging(Integer.parseInt(request.getParameter("listp")), request);
		} else {
			BrewerDAO.brewerJp(request);
			BrewerDAO.seedrinkJp(request);
			BrewerDAO.ReadReviewJp(request);
			ArrayList jsnr = (ArrayList)request.getAttribute("review");
			if (jsnr.size() != 0) {		 
				BrewerDAO.reviewPaging(Integer.parseInt(request.getParameter("p")), request);
			}
			BrewerDAO.listPaging(Integer.parseInt(request.getParameter("listp")), request);
		}
		request.setAttribute("detailPage", "drinkdetail_review.jsp");
		request.getRequestDispatcher("jsn/jsp/drinkdetail.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BrewerDAO.CreateReview(request);
//		mr로 다 받아야 해서 등록 성공시 새로운 어트리뷰트 만들어서 그걸로 돌리기
		
		String country = (String) request.getSession().getAttribute("country");
		if (country.equals("korean")) {
			BrewerDAO.brewer(request);
			BrewerDAO.seedrink(request);
			BrewerDAO.listPaging(Integer.parseInt((String) request.getAttribute("listp")),request);
			BrewerDAO.ReadReview(request);
			Object reviewAttribute = request.getAttribute("review");
			ArrayList jsnr = (reviewAttribute instanceof ArrayList) ? (ArrayList) reviewAttribute : new ArrayList();

			if (jsnr.size() != 0) {
				BrewerDAO.reviewPaging(1, request);				 
			}
		} else {
			BrewerDAO.brewerJp(request);
			BrewerDAO.seedrinkJp(request);
			BrewerDAO.listPaging(Integer.parseInt((String) request.getAttribute("listp")), request);
			BrewerDAO.ReadReviewJp(request);
			ArrayList jsnr = (ArrayList)request.getAttribute("review");
			if (jsnr.size() != 0) {
				BrewerDAO.reviewPaging(1, request);				 
			}
		}
		
		request.setAttribute("detailPage", "drinkdetail_review.jsp");
		request.getRequestDispatcher("jsn/jsp/drinkdetail.jsp").forward(request, response);
		
	}

}
