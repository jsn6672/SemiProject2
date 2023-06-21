package com.jh.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.jh.login.Account;
import com.jh.main.DBManager;

public class AccountDAO {

	public static void loginCheck(HttpServletRequest request) {
		Account account = (Account) request.getSession().getAttribute("account");

		if (account == null) {
			request.setAttribute("loginPage", "login.jsp");
		} else {
			request.setAttribute("loginPage", "loginOk.jsp");
		}
	}

	public static void login(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String db_id = null;
		String result = "";
		
		String sql = "select * from jh_account where a_id =?";
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs =  pstmt.executeQuery();
			
			if (rs.next()) {
				String db_pw = rs.getString("a_pw");
				if (pw.equals(db_pw)) {
					Account a = new Account();
					
					a.setName(rs.getString("a_name"));
					a.setId(id);
					a.setPw(db_pw);
					a.setBirth(rs.getString("a_birth"));
					a.setGender(rs.getString("a_gender"));
					a.setAddr(rs.getString("a_addr"));
					a.setQuestion(rs.getString("a_question"));
					a.setQuestion_number(rs.getString("a_question_number"));
					
					HttpSession hs = request.getSession();
					hs.setAttribute("account", a);
				} else {
					result = "암호 오류";
				}
			}else {
				result = "존재하지 않는 회원";
			}
			request.setAttribute("r", result);
			
		} catch (Exception e) {
			request.setAttribute("r", "실패");
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		
	}

	public static void logout(HttpServletRequest request) {
		HttpSession hs = request.getSession();
		hs.removeAttribute("account");
	}

}
