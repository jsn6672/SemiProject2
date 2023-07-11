package com.ih.tour;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.tagext.TryCatchFinally;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DAOdata {
	private static DBManager db = DBManager.DB;
	private static Connection  con = null;
	
	private static ArrayList<TourData> tourData;

	
	
	public static void data(HttpServletRequest request) {
	PreparedStatement pstmt = null;	
		
		
		for(int page = 1; page <= 12; page++) {
			
	
		String sql = "insert into TourData values(?,?,?,?,?,?,?,?,?,?)";
		
		try {
			con = db.connect();
			pstmt = con.prepareStatement(sql);
			
			
			String url = "http://api.visitjeju.net/vsjApi/contents/searchList?apiKey=kzqn5gj47jco7e38&locale=kr&category=c1&page=" + page;

			URL u = new URL(url);
			HttpURLConnection huc = (HttpURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");

			
			JSONParser jp = new JSONParser();
			
			JSONObject tourPlace = (JSONObject) jp.parse(isr);
		
			
			
			JSONArray data = (JSONArray) tourPlace.get("items");
			tourData = new ArrayList<TourData>();
			
			int tourcount = 0;
			double gradeavg =0;
			for (int i = 0; i < data.size(); i++) {
				JSONObject placeObj = (JSONObject) data.get(i);
				
				
				
				//System.out.println(placeObj.get("title"));
				String pk = (String) placeObj.get("contentsid");
				String title = (String) placeObj.get("title");
				String address = (String) placeObj.get("address");
				String roadaddress = (String) placeObj.get("roadaddress");
				String introduction = (String) placeObj.get("introduction");
				String phoneno = (String) placeObj.get("phoneno");
				String alltag = (String) placeObj.get("alltag");
					JSONObject a = (JSONObject) placeObj.get("repPhoto");
					JSONObject b = (JSONObject) a.get("photoid");
				String imgpath = (String) b.get("imgpath");
				
				tourData.add(new TourData(pk, title, address, roadaddress, introduction, phoneno, alltag, imgpath, i, i));
				
				pstmt.setString(1, pk);
	            pstmt.setString(2, title);
	            pstmt.setString(3, address);
	            pstmt.setString(4, roadaddress);
	            pstmt.setString(5, introduction);
	            pstmt.setString(6, phoneno);
	            pstmt.setString(7, alltag);
	            pstmt.setString(8, imgpath);
	            pstmt.setInt(9, tourcount);
	            pstmt.setDouble(10, gradeavg);
				
	            
	            System.out.println(placeObj.get("title"));
	            
	            
	            if(pstmt.executeUpdate() == 1) {
	                System.out.println("등록성공");
	                request.setAttribute("result", con);
	            }
				
			}
			
			
			
		} catch (Exception e) {
			  request.setAttribute("result", "db server error...");
			e.printStackTrace();
		}finally {
			db.close(con, pstmt, null);
		}
		
		
		
		}
		
	}
}
