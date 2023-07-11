package com.jsn.main;
//	db愿��젴 �옉�뾽�쓣 �븷�븣 �뿰寃곗퐫�뱶瑜� �벖 �씠�썑�뿉 �옉�뾽 �빐以�

//	�떎�벐硫� �떕�쓬

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//	洹멸구 aop�븯�옄

public class DBManeger {

//	db�옉�뾽�떆�뿏 �뼱夷뚮뜕 �뿰寃고빐�빞 �븿
	public static Connection connect() throws SQLException {

//		String url = "jdbc:oracle:thin:@localhost:1521:xe";
//		String id = "c##jh";
//		String pw = "jh";  
//		return DriverManager.getConnection(url, id, pw);

		// public static Connection connect() throws SQLException {
		// �옱�닚
		String url = "jdbc:oracle:thin:@DB202204301707_high?TNS_ADMIN=C:/Wallet_DB202204301707";
		// �씤�썑
//		        String url = "jdbc:oracle:thin:@DB202204301707_high?TNS_ADMIN=/usr/asdasd/Wallet_DB202204301707";

		// �옱�솚
		// String url =
		// "jdbc:oracle:thin:@DB202204301707_high?TNS_ADMIN=D:/JJH/cloud/Wallet_DB202204301707";
		// �닔吏�

		// 媛��쁽

		// �븯誘�
//		String url = "jdbc:oracle:thin:@localhost:1521:xe";
//		        test
		/*
		 * 
		 */
		/*
		 * System.out.println("�뿰寃� �꽦怨�!"); return
		 * 
		 */
//		String url = "jdbc:oracle:thin:@DB202204301707_high?TNS_ADMIN=C:\\develop program\\Wallet_DB202204301707";
		return DriverManager.getConnection(url, "MACUSER", "Soldesk802!!!");
//				test
//		return DriverManager.getConnection(url, "c##yjs", "yjs");

	}

	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt !=null) {
				pstmt.close();				
			}
			if (con !=null) {
				con.close();				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
