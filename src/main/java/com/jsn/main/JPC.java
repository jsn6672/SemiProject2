package com.jsn.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JPC")
public class JPC extends HttpServlet {
//	번역db 삽입 컨트롤러
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BrewerDAO.setDB(request);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
