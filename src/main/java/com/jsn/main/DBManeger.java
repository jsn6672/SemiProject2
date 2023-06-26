package com.jsn.main;
//	db관련 작업을 할때 연결코드를 쓴 이후에 작업 해줌
//	다쓰면 닫음

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//	그걸 aop하자

public class DBManeger {
	
//	db작업시엔 어쨌던 연결해야 함
		   public static Connection connect() throws SQLException {
			   // 재순
//		        String url = "jdbc:oracle:thin:@DB202204301707_high?TNS_ADMIN=C:/Wallet_DB202204301707";
		       // 인후
//		        String url = "jdbc:oracle:thin:@DB202204301707_high?TNS_ADMIN=/usr/asdasd/Wallet_DB202204301707";
		        
		        // 재환
		        
		        // 수진
		        
		        // 가현
		        
		        // 하민
		        
//		        test
		        String url = "jdbc:oracle:thin:@localhost:1521:xe";
		        
		        
		        System.out.println("연결 성공!");
//		        return DriverManager.getConnection(url,"MACUSER", "Soldesk802!!!");
		        
//				test
				return DriverManager.getConnection(url, "c##yjs", "yjs");
	}
	
	
	
	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			pstmt.close();
			con.close();			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
