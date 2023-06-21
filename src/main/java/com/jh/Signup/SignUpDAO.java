package com.jh.Signup;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;

import com.jh.main.DBManager;

public class SignUpDAO {

	public static void signup (HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql ="insert into jh_account values(?,?,?,?,?,?,?)";
		
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			
			String name = request.getParameter("name");
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String gender = request.getParameter("gender");
			String birth = request.getParameter("birth");
			String question = request.getParameter("question");
			String answer = request.getParameter("answer");
			
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			pstmt.setString(3, pw);
			pstmt.setString(4, birth);
			pstmt.setString(5, gender);
			pstmt.setString(6, question);
			pstmt.setString(7, answer);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, null);
		}
	}
	
}
