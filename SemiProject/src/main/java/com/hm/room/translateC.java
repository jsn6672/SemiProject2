package com.hm.room;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/translatejpC")
public class translateC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String SL = request.getParameter("langauage");
	if ("kr".equals(SL)) {
        DAOroom.translate(request);
        
       
    } else if ("jp".equals(SL)) {
        // 일본어로 변경하는 코드 작성
        System.out.println("일본어로 변경합니다.");
    }
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	}

}
