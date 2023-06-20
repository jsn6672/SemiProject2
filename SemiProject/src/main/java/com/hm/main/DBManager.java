package com.hm.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBManager {

	
	public static final DBManager DB = new DBManager();
	
	private DBManager() {
		
	}
	
	
	public static Connection connect() throws SQLException {
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		System.out.println("연결성공");
		return DriverManager.getConnection(url, "c##hm", "hm");
		
	}

	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		
		try {
			
			if (rs != null) {
				
				rs.close();
			}
			pstmt.close();
			con.close();
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		
	}
	
	
}

