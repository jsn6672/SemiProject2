package com.hm.room;

import java.io.InputStream;

import java.io.InputStreamReader;
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

import com.hm.main.DBManager;

public class DAOroom {

	public static void getallroom(HttpServletRequest request) {

		try {
			String url = "https://api.visitjeju.net/vsjApi/contents/searchList?apiKey=x8uwubc8s4qzunfb&locale=kr&category=c3";

			URL u = new URL(url);
			HttpsURLConnection huc = (HttpsURLConnection) u.openConnection();

			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");

			// jSON 문법
			// 언어가 다르니까 자바코드로 접근하여 처리하기 어렵다.
			// 라이브러리(도구)

			// jSON 데이터 받은거 파싱하게 jSONparser 객체가 필요
			JSONParser jp = new JSONParser();

			// 만든 객체로 isr(받은 데이터) 넣어서 파싱 준비
			JSONObject room = (JSONObject) jp.parse(isr);

			JSONArray items = (JSONArray) room.get("items");
			ArrayList<Hotel> hotels = new ArrayList<Hotel>();
			for (int i = 0; i < items.size(); i++) {
				JSONObject roomObj = (JSONObject) items.get(i);

				System.out.println(roomObj.get("title"));
				JSONObject a = (JSONObject)roomObj.get("repPhoto");
				JSONObject b = (JSONObject)a.get("photoid");

//				System.out.println(roomObj.get("address"));
//				System.out.println(roomObj.get("roadaddress"));
//				System.out.println(roomObj.get("introduction"));
//				System.out.println(roomObj.get("latitude"));
//				System.out.println(roomObj.get("longitude"));
//				System.out.println(roomObj.get("phoneno"));
//				System.out.println(roomObj.get("tag"));

				String title = (String) roomObj.get("title");
				String address = (String) roomObj.get("address");
				String roadaddress = (String) roomObj.get("roadaddress");
				String introduction = (String) roomObj.get("introduction");
				double latitude = (double) roomObj.get("latitude");
				double longitude = (double) roomObj.get("longitude");
				String phoneno = (String) roomObj.get("phoneno");
				String imgpath = (String)b.get("imgpath");
				String thumnailpath = (String)b.get("thumnailpath");
				String tag = (String) roomObj.get("tag");

				hotels.add
				(new Hotel(title, address, roadaddress, introduction, latitude, longitude, phoneno, imgpath, thumnailpath, tag));


			}
			request.setAttribute("hotels", hotels);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void searchroom(HttpServletRequest request) {
		
		try {
			String search = request.getParameter("hotelsearch");
			String encodedsearch = URLEncoder.encode(search, "UTF-8");
			System.out.println(encodedsearch);
			String url = "https://api.visitjeju.net/vsjApi/contents/searchList?apiKey=x8uwubc8s4qzunfb&locale=kr&category=c3&title="
					+ encodedsearch;

			URL u = new URL(url);
			HttpsURLConnection huc = (HttpsURLConnection) u.openConnection();

			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");

			// jSON 문법
			// 언어가 다르니까 자바코드로 접근하여 처리하기 어렵다.
			// 라이브러리(도구)

			// jSON 데이터 받은거 파싱하게 jSONparser 객체가 필요
			JSONParser jp = new JSONParser();

			// 만든 객체로 isr(받은 데이터) 넣어서 파싱 준비
			JSONObject room = (JSONObject) jp.parse(isr);

			JSONArray items = (JSONArray) room.get("items");
			ArrayList<Hotel> hotels = new ArrayList<Hotel>();
			for (int i = 0; i < items.size(); i++) {
				JSONObject roomObj = (JSONObject) items.get(i);
				JSONObject a = (JSONObject)roomObj.get("repPhoto");
				JSONObject b = (JSONObject)a.get("photoid");

				System.out.println(roomObj.get("title"));

				String title = (String) roomObj.get("title");
				String address = (String) roomObj.get("address");
				String roadaddress = (String) roomObj.get("roadaddress");
				String introduction = (String) roomObj.get("introduction");
				double latitude = (double) roomObj.get("latitude");
				double longitude = (double) roomObj.get("longitude");
				String phoneno = (String) roomObj.get("phoneno");
				String imgpath = (String)b.get("imgpath");
				String thumnailpath = (String)b.get("thumnailpath");
				String tag = (String) roomObj.get("tag");

				hotels.add
				(new Hotel(title, address, roadaddress, introduction, latitude, longitude, phoneno, imgpath, thumnailpath, tag));

			}
			request.setAttribute("hotels", hotels);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void clickroom(HttpServletRequest request) {
		
		
	}
}