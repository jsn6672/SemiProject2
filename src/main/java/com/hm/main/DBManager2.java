package com.hm.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBManager2 {

	
	// db 작업시에는 일단 연결
	public static Connection connect() throws SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection con = DriverManager.getConnection(url, "c##hm", "hm");
		System.out.println("연결 성공");
		return DriverManager.getConnection(url, "c##hm", "hm");
	}
		// 닫을게 많은데 한번에 닫기 
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
