package com.jh.Signup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.jh.login.Account;
import com.jh.main.DBManager;


public class SignUpDAO {

    public static void signup(HttpServletRequest request) {
        Connection con = null;
        PreparedStatement pstmt = null;
        String sql = "INSERT INTO jh_account values (?,?,?,?,?,?,?)";

        try {
            con = DBManager.connect();
            pstmt = con.prepareStatement(sql);

            String id = request.getParameter("userId");
            String pw = request.getParameter("userPw");
            String name = request.getParameter("userName");
            String gender = request.getParameter("gender");
            String birth = request.getParameter("userBirth");
            String question = request.getParameter("question");
            String answer = request.getParameter("userAnswer");
            
            System.out.println(name);
            System.out.println(id);
            System.out.println(pw);
            System.out.println(birth);
            System.out.println(gender);
            System.out.println(question);
            System.out.println(answer);
            
            pstmt.setString(1, id);
            pstmt.setString(2, pw);
            pstmt.setString(3, name);
            pstmt.setString(4, gender);
            pstmt.setString(5, birth);
            pstmt.setString(6, question);
            pstmt.setString(7, answer);

            if (pstmt.executeUpdate() == 1) {
                System.out.println("등록완료");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(con, pstmt, null);
        }
    }

	public static int idcheck(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String id = request.getParameter("id");
		String sql = "select * from jh_account where a_id =?";
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs =  pstmt.executeQuery();
			
			if (rs.next()) {
				return 1;
			}else {
				return 0;
			}
			
		} catch (Exception e) {
			request.setAttribute("r", "실패");
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		return 0;
	}
}
