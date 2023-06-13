package com.hm.room;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

import com.hm.main.DBManager;

public class DAOroom {

	public static void getallroom(HttpServletRequest request) {
			
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
				con = DBManager.connect();
				
			
			
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
