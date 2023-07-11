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
		System.out.println(account);
		if (account == null) {
			request.setAttribute("loginPage", "login.jsp");
		} else {
			request.setAttribute("loginPage", "loginOk.jsp");
		}
	}
	public static void logincontentCheck(HttpServletRequest request) {
		Account account = (Account) request.getSession().getAttribute("account");
		System.out.println(account);
		if (account == null) {
			request.setAttribute("loginPage", "../../login.jsp");
		} else {
			request.setAttribute("loginPage", "../../loginOk.jsp");
		}
	}

	public static void logintourCheck(HttpServletRequest request) {
		Account account = (Account) request.getSession().getAttribute("account");
		System.out.println(account);
		if (account == null) {
			request.setAttribute("loginPage", "../login.jsp");
		} else {
			request.setAttribute("loginPage", "../loginOk.jsp");
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
		
		String sql = "select * from account_tbl where id =?";
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs =  pstmt.executeQuery();
			if (rs.next()) {
				String db_pw = rs.getString("pw");
				if (pw.equals(db_pw)) {
					Account a = new Account();
					
					a.setName(rs.getString("name"));
					a.setId(id);
					a.setPw(db_pw);
					a.setBirth(rs.getString("birth"));
					a.setGender(rs.getString("gender"));
					a.setQuestion(rs.getString("question"));
					a.setQuestion_answer(rs.getString("question_answer"));
					
					HttpSession hs = request.getSession();
					hs.setAttribute("account", a);
					
					result = "로그인 성공";
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

	public static boolean validLogin(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String db_id = null;
		boolean isValid = false;
		
		String sql = "select * from account_tbl where id =?";
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs =  pstmt.executeQuery();
			
			if (rs.next()) {
				String db_pw = rs.getString("pw");
				if (pw.equals(db_pw)) {
					isValid = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		return isValid;
		
	}
	
}
