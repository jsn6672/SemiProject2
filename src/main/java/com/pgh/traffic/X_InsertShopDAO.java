package com.pgh.traffic;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

//DB 넣는 용도로 만든 DAO(사용X)

public class X_InsertShopDAO {

	public static void insertShop(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;

		String sql = "insert into rentshop_data values(rentshop_data_seq.nextval,?,?,?,?,?,?,?,?)";
		for (int p = 1; p <= 19; p++) {

			try {
				con = DBManager2.connect();
				pstmt = con.prepareStatement(sql);

				String url = "https://open.jejudatahub.net/api/proxy/01aDta180abt81t3ba0bt11taab88080/r104t2101t2b42etp041j111bjc1r001?number="
						+ p;

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

				int shop_grade_cnt = 0;
				double shop_grade_avg = 0;
				for (int i = 0; i < data.size(); i++) {
					JSONObject placeObj = (JSONObject) data.get(i);

					String shop_placename = (String) placeObj.get("placeName");
					String shop_jibun = (String) placeObj.get("addressJibun");
					String shop_doro = (String) placeObj.get("addressDoro");
					double shop_longitude = (double) placeObj.get("longitude");
					double shop_latitude = (double) placeObj.get("latitude");
					String shop_url = (String) placeObj.get("placeUrl");

//					rentShops.add(new RentShop(shop_placename, shop_jibun, shop_doro, shop_longitude, shop_latitude, shop_url));

					pstmt.setString(1, shop_placename);
					pstmt.setString(2, shop_jibun);
					pstmt.setString(3, shop_doro);
					pstmt.setDouble(4, shop_longitude);
					pstmt.setDouble(5, shop_latitude);
					pstmt.setString(6, shop_url);
					pstmt.setDouble(7, shop_grade_avg);
					pstmt.setInt(8, shop_grade_cnt);

					if (pstmt.executeUpdate() == 1) {
						System.out.println("등록 성공!");
					}
				}
			} catch (Exception e) {
				System.out.println("db server error");
				e.printStackTrace();
			} finally {
				DBManager2.close(con, pstmt, null);
			}
		}
	}
}
