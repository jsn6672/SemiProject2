package com.pgh.traffic;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//DB 넣는 용도로 만든 컨트롤러(사용X)

@WebServlet("/X_InsertShopC")
public class X_InsertShopC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("시작부터 안되는거니?");
		X_InsertShopDAO.insertShop(request);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
