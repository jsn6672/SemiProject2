package com.jh.main;
// DB관련 작업을 할때 연결코드를 쓴 이후에 작업 해옴
// 다 쓰면 닫음

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// 그걸 AOP 하자
public class DBManager {
	
	// DB작업시엔 어쨌든 연결 해야됨
	public static Connection connect() throws SQLException {
	
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "c##jh";
		String pw = "jh";  
		return DriverManager.getConnection(url, id, pw);
	}
		
	// 닫을게 많은데 한번에 닫기
		public static void close(Connection con,PreparedStatement pstmt,ResultSet rs)
		{
			try {
				
			rs.close();
			
			pstmt.close();
			
			con.close();
			} catch (Exception e) {
			}
	}

}
