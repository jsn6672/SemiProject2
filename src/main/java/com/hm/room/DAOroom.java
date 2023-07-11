package com.hm.room;

import java.io.InputStream;



import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DAOroom {

	public static ArrayList<Hotel> hotels = new ArrayList<Hotel>();

	public static void getAllRoom(HttpServletRequest request) {

	try {	
			String url = "https://api.visitjeju.net/vsjApi/contents/searchList?apiKey=x8uwubc8s4qzunfb&locale=kr&category=c3";
			URL u = new URL(url);
			HttpsURLConnection huc = (HttpsURLConnection) u.openConnection();

			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");


			JSONParser jp = new JSONParser();

			JSONObject room = (JSONObject) jp.parse(isr);

			JSONArray items = (JSONArray) room.get("items");
			hotels = new ArrayList<Hotel>();
			for (int i = 0; i < items.size(); i++) {
				JSONObject roomObj = (JSONObject) items.get(i);

				//System.out.println(roomObj.get("title"));
				JSONObject a = (JSONObject) roomObj.get("repPhoto");
				JSONObject b = (JSONObject) a.get("photoid");

				String title = (String) roomObj.get("title");
				String address = (String) roomObj.get("address");
				String roadaddress = (String) roomObj.get("roadaddress");
				String introduction = (String) roomObj.get("introduction");
				String phoneno = (String) roomObj.get("phoneno");
				String imgpath = (String) b.get("imgpath");
				String thumnailpath = (String) b.get("thumnailpath");
				String tag = (String) roomObj.get("tag");
				String cid = (String) roomObj.get("contentsid");

				hotels.add(new Hotel(title, address, roadaddress, introduction, phoneno, imgpath, thumnailpath, tag, cid));
			}	
			request.setAttribute("hotels", hotels);
			System.out.println("검색완료");

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

			JSONParser jp = new JSONParser();

			JSONObject room = (JSONObject) jp.parse(isr);

			JSONArray items = (JSONArray) room.get("items");
			hotels = new ArrayList<Hotel>();
			for (int i = 0; i < items.size(); i++) {
				JSONObject roomObj = (JSONObject) items.get(i);
				JSONObject a = (JSONObject) roomObj.get("repPhoto");
				JSONObject b = (JSONObject) a.get("photoid");

				System.out.println(roomObj.get("title"));

				String title = (String) roomObj.get("title");
				String address = (String) roomObj.get("address");
				String roadaddress = (String) roomObj.get("roadaddress");
				String introduction = (String) roomObj.get("introduction");
				String phoneno = (String) roomObj.get("phoneno");
				String imgpath = (String) b.get("imgpath");
				String thumnailpath = (String) b.get("thumnailpath");
				String tag = (String) roomObj.get("tag");
				String pk = (String) roomObj.get("contentsid");

				hotels.add(new Hotel(title, address, roadaddress, introduction, phoneno, imgpath,
						thumnailpath, tag, pk));

			}
			request.setAttribute("hotels", hotels);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void markingMap(HttpServletRequest request) {

		try {
	
			String search = request.getParameter("clickhotel");
			String encodedsearch = null;
			if (search != null)
				encodedsearch = URLEncoder.encode(search, "UTF-8");
			System.out.println(encodedsearch);
			String url = "https://api.visitjeju.net/vsjApi/contents/searchList?apiKey=x8uwubc8s4qzunfb&locale=kr&category=c3&roadaddress="
					+ encodedsearch;

			URL u = new URL(url);
			HttpsURLConnection huc = (HttpsURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");

			JSONParser jp = new JSONParser();

			JSONObject room = (JSONObject) jp.parse(isr);

			JSONArray items = (JSONArray) room.get("items");
			hotels = new ArrayList<Hotel>();
			for (int i = 0; i < items.size(); i++) {
				JSONObject roomObj = (JSONObject) items.get(i);
				JSONObject a = (JSONObject) roomObj.get("repPhoto");
				JSONObject b = (JSONObject) a.get("photoid");

				System.out.println(roomObj.get("title"));

				String title = (String) roomObj.get("title");
				System.out.println(title);
				String address = (String) roomObj.get("address");
				System.out.println(address);
				String roadaddress = (String) roomObj.get("roadaddress");
				System.out.println(roadaddress);
				String introduction = (String) roomObj.get("introduction");
				System.out.println(introduction);
				String phoneno = (String) roomObj.get("phoneno");
				System.out.println(phoneno);
				String imgpath = (String) b.get("imgpath");
				System.out.println(imgpath);
				String thumnailpath = (String) b.get("thumnailpath");
				System.out.println(thumnailpath);
				String tag = (String) roomObj.get("tag");
				System.out.println(tag);
				String pk = (String) roomObj.get("contentsid");

				hotels.add(new Hotel(title, address, roadaddress, introduction,
						 phoneno, imgpath, thumnailpath, tag, pk));

			}
			request.setAttribute("hotels", hotels);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	public static void roomPaging(int page, HttpServletRequest request) {
		
	try {
		
		int cnt = 10;
		int total = hotels.size();
		// int pageCount = (int) Math.ceil((double) total / cnt);
		int pageCount = (int) Math.ceil((double) total / cnt);
		
	//	int start = cnt * (page - 1);
	//	int end = Math.min(start + cnt, total + (total % cnt)); // Avoid index out of bound error
		
		int start = (page - 1) * cnt;
	    int end = Math.min(start + cnt, total);
		 
		 
		List<Hotel> items = hotels.subList(start, end);
		
		int maxPageButtons = 6; // 筌ㅼ뮆占� 占쎈읂占쎌뵠筌욑옙 占쎄퐨占쎄문 甕곌쑵�뱣 占쎈땾
	    int startPage = Math.max(1, page - maxPageButtons / 2);
	    int endPage = Math.min(startPage + maxPageButtons - 1, pageCount);

	    request.setAttribute("pageCount", pageCount);
	    request.setAttribute("curPageNo", page);
	    request.setAttribute("hotels", items);
	    request.setAttribute("startPage", startPage);
	    request.setAttribute("endPage", endPage);
		
	} catch (Exception e) {

	}

	}

	
}