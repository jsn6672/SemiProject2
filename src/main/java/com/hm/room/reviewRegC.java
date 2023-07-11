package com.hm.room;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jh.login.AccountDAO;
@WebServlet("/reviewRegC")
public class reviewRegC extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	AccountDAO.logintourCheck(request);
	System.out.println("로그인체크 통과");
	DAOreview.regReview(request);
	System.out.println("리뷰 작성 통과");
//	DAOreview.getReview(request);
//	System.out.println("리뷰 조회 통과");
	DAOroom.getAllRoom(request);
	System.out.println("호텔 조회 통과");
	request.setAttribute("contentPage", "jsp/hotelmain.jsp");
	request.getRequestDispatcher("hm/index.jsp").forward(request, response);
	}

}
