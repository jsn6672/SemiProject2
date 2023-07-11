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
		
//		String url = "jdbc:oracle:thin:@DB202204301707_high?TNS_ADMIN=C:/PHM_java/Wallet_DB202204301707";
//		System.out.println("���� ����");
		String url = "jdbc:oracle:thin:@DB202204301707_high?TNS_ADMIN=C:/Wallet_DB202204301707";
		return DriverManager.getConnection(url, "MACUSER", "Soldesk802!!!");
		
	}

	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		
		try {
			
			if (rs != null) {
				
				rs.close();
			}
			pstmt.close();
			
			if (con != null) {
				con.close();
			}
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		
	}
	
	
}

