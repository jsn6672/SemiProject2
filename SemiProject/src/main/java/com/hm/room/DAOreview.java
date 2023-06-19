package com.hm.room;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;

import com.hm.main.DBManager;

public class DAOreview {

	public static void regReview(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into hotelR_test values(hotelR_test_seq.nextval,?,?,?,?,?,?)";		
		
		try {
			
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
	}

	
	
	
}
