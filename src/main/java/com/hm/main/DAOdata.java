package com.hm.main;

import java.io.InputStream;

import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.hm.room.Hotel;

public class DAOdata {

	public static void data(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;

		for (int page = 1; page <= 5 ; page++) {

			String sql = "insert into hotelgrade_test values(?,?,?,?)";

			try {
				con = DBManager2.connect();
				pstmt = con.prepareStatement(sql);

				String url = "https://api.visitjeju.net/vsjApi/contents/searchList?apiKey=x8uwubc8s4qzunfb&locale=kr&category=c3&page="+page;
						

				URL u = new URL(url);
				HttpsURLConnection huc = (HttpsURLConnection) u.openConnection();

				InputStream is = huc.getInputStream();
				InputStreamReader isr = new InputStreamReader(is, "utf-8");

	
				JSONParser jp = new JSONParser();

				JSONObject room = (JSONObject) jp.parse(isr);

				JSONArray items = (JSONArray) room.get("items");
				ArrayList<Hoteldata> hotelDB = new ArrayList<Hoteldata>();

				for (int i = 0; i < items.size(); i++) {
					JSONObject roomObj = (JSONObject) items.get(i);

					System.out.println(roomObj.get("title"));

					String pk = (String) roomObj.get("contentsid");
					String title = (String) roomObj.get("title");
					int reviewcnt = 0;
					double grade = 0;

					pstmt.setString(1, pk);
					pstmt.setString(2, title);
					pstmt.setInt(3, reviewcnt);
					pstmt.setDouble(4, grade);

					if (pstmt.executeUpdate() == 1) {
						System.out.println("�벑濡앹꽦怨�");

					}

				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager2.close(con, pstmt, null);
			}
		}
	}

	public static void data2(HttpServletRequest request) {
		
			Connection con = null;
			PreparedStatement pstmt = null;

			for (int page = 6; page <= 10 ; page++) {

				String sql = "insert into hotelgrade_test values(?,?,?,?)";

				try {
					con = DBManager2.connect();
					pstmt = con.prepareStatement(sql);

					String url = "https://api.visitjeju.net/vsjApi/contents/searchList?apiKey=x8uwubc8s4qzunfb&locale=kr&category=c3&page="+page;
							

					URL u = new URL(url);
					HttpsURLConnection huc = (HttpsURLConnection) u.openConnection();

					InputStream is = huc.getInputStream();
					InputStreamReader isr = new InputStreamReader(is, "utf-8");

					JSONParser jp = new JSONParser();

					JSONObject room = (JSONObject) jp.parse(isr);

					JSONArray items = (JSONArray) room.get("items");
					ArrayList<Hoteldata> hotelDB = new ArrayList<Hoteldata>();

					for (int i = 0; i < items.size(); i++) {
						JSONObject roomObj = (JSONObject) items.get(i);

						System.out.println(roomObj.get("title"));

						String pk = (String) roomObj.get("contentsid");
						String title = (String) roomObj.get("title");
						int reviewcnt = 0;
						double grade = 0;

						pstmt.setString(1, pk);
						pstmt.setString(2, title);
						pstmt.setInt(3, reviewcnt);
						pstmt.setDouble(4, grade);

						if (pstmt.executeUpdate() == 1) {
							System.out.println("�벑濡앹꽦怨�");

						}

					}

				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					DBManager2.close(con, pstmt, null);
				}
			}

		
	}

}
