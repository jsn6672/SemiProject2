package com.jh.main;
// DB���� �۾��� �Ҷ� �����ڵ带 �� ���Ŀ� �۾� �ؿ�
// �� ���� ����

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// �װ� AOP ����
public class DBManager {
	
	// DB�۾��ÿ� ��·�� ���� �ؾߵ�
	public static Connection connect() throws SQLException {
	
//		String url = "jdbc:oracle:thin:@localhost:1521:xe";
//		String id = "c##jh";
//		String pw = "jh";  
//		return DriverManager.getConnection(url, id, pw);
		String url = "jdbc:oracle:thin:@DB202204301707_high?TNS_ADMIN=C:/Wallet_DB202204301707";
		return DriverManager.getConnection(url, "MACUSER", "Soldesk802!!!");

		
		
	}
		
	// ������ ������ �ѹ��� �ݱ�
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
