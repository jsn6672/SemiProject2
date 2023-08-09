package com.jh.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.jsn.main.DBManeger;

public class proposal {
	private static ArrayList<Suggest>proposals;
	public static void seeAllList(HttpServletRequest request) {
		Connection con =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from freeboard_table";
		try {
			proposals = new ArrayList<Suggest>();
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String no = rs.getString("t_no");
				String type = rs.getString("t_type");
				String user = rs.getString("t_user");
				String date = rs.getString("t_date");
				String title = rs.getString("t_title");
				String grade = rs.getString("t_grade");
				String content = rs.getString("t_content");
				proposals.add(new Suggest(no, type, user, date, title, grade, content));
			}
			request.setAttribute("proposal", proposals);
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBManager.close(con, pstmt, rs);
		}
				
		
	}

}
