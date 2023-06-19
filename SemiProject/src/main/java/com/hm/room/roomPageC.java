package com.hm.room;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/roomPageC")
public class roomPageC extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOroom.getAllRoom(request);
		
		String pStr = request.getParameter("p");
		int p = 1;
		if (pStr != null && !pStr.isEmpty()) {
			try {
				p = Integer.parseInt(pStr);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		
		DAOroom.roomPaging(p, request);
		
		request.setAttribute("contentPage", "jsp/hotelmain.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	
	}

}
