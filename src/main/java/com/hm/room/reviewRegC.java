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
	System.out.println("�α���üũ ���");
	DAOreview.regReview(request);
	System.out.println("���� �ۼ� ���");
//	DAOreview.getReview(request);
//	System.out.println("���� ��ȸ ���");
	DAOroom.getAllRoom(request);
	System.out.println("ȣ�� ��ȸ ���");
	request.setAttribute("contentPage", "jsp/hotelmain.jsp");
	request.getRequestDispatcher("hm/index.jsp").forward(request, response);
	}

}
