package com.ih.tour;


import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;



public class TourDAO {
	private static DBManager db = DBManager.DB;
	private static Connection con = null;
	private static PreparedStatement pstmt = null;	
	private static ResultSet rs = null;
	private static ArrayList<Tourp> tourPlaces;
	
	public static void getAllTour(HttpServletRequest request) {
		try {
		//	search = URLEncoder.encode(search, "UTF-8");
			String url = "http://api.visitjeju.net/vsjApi/contents/searchList?apiKey=kzqn5gj47jco7e38&locale=kr&category=c1";
				URL u = new URL(url);
				HttpURLConnection huc = (HttpURLConnection) u.openConnection();
				InputStream is = huc.getInputStream();
				InputStreamReader isr = new InputStreamReader(is, "utf-8");
				JSONParser jp = new JSONParser();
				JSONObject tourPlace = (JSONObject) jp.parse(isr);
				JSONArray data = (JSONArray) tourPlace.get("items");
				tourPlaces = new ArrayList<Tourp>();
				for (int i = 0; i < data.size(); i++) {
				JSONObject placeObj = (JSONObject) data.get(i);
				
				String title = (String) placeObj.get("title");
				if (title.contains("삭제")) {
					continue;
				}
					JSONObject a = (JSONObject) placeObj.get("repPhoto");
					JSONObject b = (JSONObject) a.get("photoid");
//					System.out.println(b.get("imgpath"));
//					System.out.println(placeObj.get("imgpath"));
					String pk = (String) placeObj.get("contentsid");
					String address = (String) placeObj.get("address");
					String introduction = (String) placeObj.get("introduction");
					String phoneno = (String) placeObj.get("phoneno");
					String roadaddress = (String) placeObj.get("roadaddress");
					String imgpath = (String) b.get("imgpath");
					
					
					tourPlaces.add(new Tourp(pk, title, address, roadaddress, introduction, phoneno, roadaddress, imgpath, i, i));
					
					
					
				}
				request.setAttribute("r", tourPlaces);
			
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
//				db.close(con, pstmt, rs);
			}
	}

		
		
		
	

	public static void searchTour(HttpServletRequest request) {
	    try {
	        String search = request.getParameter("searchInput");
	        String encodedSearch = URLEncoder.encode(search, StandardCharsets.UTF_8.toString());
	        String url = "http://api.visitjeju.net/vsjApi/contents/searchList?apiKey=kzqn5gj47jco7e38&locale=kr&category=c1&title=" + encodedSearch;
	        URL u = new URL(url);
	        HttpURLConnection huc = (HttpURLConnection) u.openConnection();
	        InputStream is = huc.getInputStream();
	        InputStreamReader isr = new InputStreamReader(is, "utf-8");
	        JSONParser jp = new JSONParser();
	        JSONObject tourPlace = (JSONObject) jp.parse(isr);
	        JSONArray data = (JSONArray) tourPlace.get("items");
	        tourPlaces = new ArrayList<Tourp>();
	        for (int i = 0; i < data.size(); i++) {
	            JSONObject placeObj = (JSONObject) data.get(i);
	            JSONObject a = (JSONObject) placeObj.get("repPhoto");
	            JSONObject b = (JSONObject) a.get("photoid");
	            String contentsid = (String) placeObj.get("contentsid");
	            String title = (String) placeObj.get("title");
	            String address = (String) placeObj.get("address");
	            String introduction = (String) placeObj.get("introduction");
	            String phoneno = (String) placeObj.get("phoneno");
	            String roadaddress = (String) placeObj.get("roadaddress");
	            String imgpath = (String) b.get("imgpath");
	            double latitude = (double) placeObj.get("latitude");
	            double longitude = (double) placeObj.get("longitude");
	            tourPlaces.add(new Tourp(contentsid, title, address, roadaddress, introduction, phoneno, roadaddress, imgpath, i, longitude));
	        }
	        request.setAttribute("r", tourPlaces);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	

	public static void paging(int page, HttpServletRequest request) {
	    if (tourPlaces == null) {
	        System.err.println("tourPlaces is null!");
	        return;
	    }

	    int cnt = 5; // 페이지 당 아이템 수
	    int total = tourPlaces.size();
	    int pageCount = (int) Math.ceil((double) total / cnt); // 전체 페이지 수

	    int start = cnt * (page - 1);
	    int end = Math.min(start + cnt, total); // Avoid index out of bound error

	    ArrayList<Tourp> items = new ArrayList<Tourp>();
	    for (int i = start; i < end; i++) {
	        items.add(tourPlaces.get(i));
	    }
	    request.setAttribute("tourPlaces", items);

	    int pageGroupSize = 5; // 페이지 그룹 크기
	    int curPageGroupNo = (page - 1) / pageGroupSize; // 현재 페이지 그룹 번호

	    int groupStartPage = curPageGroupNo * pageGroupSize + 1; // 현재 페이지 그룹의 첫 페이지 번호
	    int groupEndPage = Math.min(groupStartPage + pageGroupSize - 1, pageCount); // 현재 페이지 그룹의 마지막 페이지 번호

	    request.setAttribute("curPageNo", page);
	    request.setAttribute("groupStartPage", groupStartPage);
	    request.setAttribute("groupEndPage", groupEndPage);
	    request.setAttribute("prevPageNo", groupStartPage - 1); // "이전" 링크 페이지 번호
	    request.setAttribute("nextPageNo", groupEndPage < pageCount ? groupEndPage + 1 : 0); // "다음" 링크 페이지 번호. 마지막 페이지 그룹인 경우 0
	}


	

}
