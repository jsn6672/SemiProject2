package com.jh.FindPwd;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jh.Signup.SignUpDAO;
import com.jh.login.AccountDAO;

@WebServlet("/FindPwdC")
public class FindPwdC extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		AccountDAO.loginCheck(request);
		if (FindPwdDAO.updatePwd(request) == 1) {
			String errorMessage3 = "비밀번호 변경 성공.";
			request.setAttribute("errorMessage3", errorMessage3);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			String errorMessage2 = "아이디 혹은 질문/대답이 틀렸습니다.";
			request.setAttribute("errorMessage2", errorMessage2);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		return;
	}
}
