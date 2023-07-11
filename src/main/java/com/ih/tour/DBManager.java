package com.ih.tour;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// db 관련 작업을 할때 연결코드를 쓴 이후에 작업해옴
// 다 쓰면 닫음 

// 07에서 공부한 AOP를 적용시키자
public class DBManager {
	
	public static final DBManager DB = new DBManager();
	
	
	private DBManager() {
		
	}

	// db작업시엔 어쨋든 연결 해야됨
	public static Connection connect() throws SQLException {
//		인후 
//		String url = "jdbc:oracle:thin:@DB202204301707_high?TNS_ADMIN=/Users/inhookwon/eclipse-workspace/Wallet_DB202204301707";
		
//		재순
		String url = "jdbc:oracle:thin:@DB202204301707_high?TNS_ADMIN=C:/Wallet_DB202204301707";
		System.out.println("연결 성공!");
		return DriverManager.getConnection(url,"MACUSER", "Soldesk802!!!");
	}
	
	public static void close(
			Connection con,
			PreparedStatement pstmt,
			ResultSet rs) {
		
		try {
			if(rs != null) {
				
				rs.close();
			}
			
			pstmt.close();
			
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	
	
}
