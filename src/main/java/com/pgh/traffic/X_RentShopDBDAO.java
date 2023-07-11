package com.pgh.traffic;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

//DB 넣기 전 API 쓰는 용도로 만든 DAO(사용X)

public class X_RentShopDBDAO {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);

			System.out.println("검색: ");
			String search = sc.next();

			search = URLEncoder.encode(search, "UTF-8");
			String url = "https://open.jejudatahub.net/api/proxy/01aDta180abt81t3ba0bt11taab88080/r104t2101t2b42etp041j111bjc1r001?number=&placeName="
					+ search;

			URL u = new URL(url);
			HttpsURLConnection huc = (HttpsURLConnection) u.openConnection();

			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			System.out.println(isr);

			JSONParser jp = new JSONParser();
			JSONObject rentCar = (JSONObject) jp.parse(isr);
			System.out.println(rentCar);

			JSONArray data = (JSONArray) rentCar.get("data");

			for (int i = 0; i < data.size(); i++) {
				JSONObject placeObj = (JSONObject) data.get(i);

				System.out.println("주소명: " + placeObj.get("placeName"));
				System.out.println("지번 주소: " + placeObj.get("addressJibun"));
				System.out.println("도로명 주소: " + placeObj.get("addressDoro"));
				System.out.println("카카오맵 URL: " + placeObj.get("placeUrl"));

				X_RentShopDB X_rentShop = new X_RentShopDB();
				ArrayList<X_RentShopDB> X_rentShops = new ArrayList<X_RentShopDB>();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void searchRentShop(HttpServletRequest request, String pageNum) {
		int p = 1;
		if (pageNum != null) {
			p = Integer.parseInt(pageNum);
		}

		request.setAttribute("pageNum", pageNum);

		String search = request.getParameter("search");
		request.setAttribute("search", search);
		System.out.println(search);
		try {
			search = URLEncoder.encode(search, "UTF-8");
			String url = "https://open.jejudatahub.net/api/proxy/01aDta180abt81t3ba0bt11taab88080/r104t2101t2b42etp041j111bjc1r001?number="
					+ p + "&placeName=" + search;
			System.out.println(url);
			URL u = new URL(url);
			HttpsURLConnection huc = (HttpsURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			System.out.println(isr);

			JSONParser jp = new JSONParser();
			JSONObject rentCar = (JSONObject) jp.parse(isr);
			System.out.println(rentCar);

			JSONArray data = (JSONArray) rentCar.get("data");
			ArrayList<X_RentShopDB> X_rentShops = new ArrayList<X_RentShopDB>();

			for (int i = 0; i < data.size(); i++) {
				JSONObject placeObj = (JSONObject) data.get(i);
				String placeName = (String) placeObj.get("placeName");
				String addressJibun = (String) placeObj.get("addressJibun");
				String addressDoro = (String) placeObj.get("addressDoro");
				double longitude = (double) placeObj.get("longitude");
				double latitude = (double) placeObj.get("latitude");
				String placeUrl = (String) placeObj.get("placeUrl");

				X_RentShopDB X_rentShop = new X_RentShopDB();
				X_rentShop.setPlaceName(placeName);
				X_rentShop.setAddressJibun(addressJibun);
				X_rentShop.setAddressDoro(addressDoro);
				X_rentShop.setLongitude(longitude);
				X_rentShop.setLatitude(latitude);
				X_rentShop.setPlaceUrl(placeUrl);
				X_rentShops.add(X_rentShop);
			}
			request.setAttribute("X_rentShops", X_rentShops);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}