package com.jh.FindPwd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.jh.main.DBManager;

public class FindPwdDAO {

    public static int updatePwd(HttpServletRequest request) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "UPDATE jh_account SET a_pw = ? WHERE a_id = ?";
        String checkSql = "SELECT * FROM jh_account WHERE a_id = ?";
        int isChanged = 0;

        try {
            con = DBManager.connect();

            String id = request.getParameter("find_pwd_id");
            String userAnswer = request.getParameter("userAnswer");
            String newPwd = request.getParameter("newPwd");
            
            System.out.println("id = "+ id);
            System.out.println(userAnswer);
            System.out.println(newPwd);
            pstmt = con.prepareStatement(checkSql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
            	String dbans = rs.getString("a_question_anwser");            	
            	if (dbans.equals(userAnswer)) {					
            		pstmt = con.prepareStatement(sql);
            		System.out.println("여기까지 체크");
            		pstmt.setString(1, newPwd);
            		pstmt.setString(2, id);
            		if (pstmt.executeUpdate() == 1) {
            			System.out.println("여기선 바껴야지");
            			isChanged = 1;
            			return isChanged;
            		}
				}
            } 
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            DBManager.close(con, pstmt, rs);
        }

        return isChanged;
    }
}
