package com.jsn.practice;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

import javax.net.ssl.HttpsURLConnection;

import org.apache.tomcat.util.json.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import oracle.sql.json.OracleJsonObject;

public class api_to_db2 {
	public static void main(String[] args) {
		String urlStr = "https://api.odcloud.kr/api/3083352/v1/uddi:228d9097-c97f-45f4-ae95-ffa655af3cc8_model"
				+ "?serviceKey=eGNB6OGxHFZZaB9okpr%2FezV2NzpDYRpi%2FwesAhdum3W0EE2071UCXI8qUptQrW807fZvr58ocyvBmn5%2B2AtY9Q%3D%3D";

		try {
			URL url = new URL(urlStr);
			HttpsURLConnection huc = (HttpsURLConnection) url.openConnection();

			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");

			System.out.println(isr);

			org.json.simple.parser.JSONParser jp = new org.json.simple.parser.JSONParser();

			JSONObject drinkData = (JSONObject) jp.parse(isr);
			System.out.println(drinkData);
			
			
			System.out.println(drinkData.get("data"));
			JSONArray drinkdata2 = (JSONArray) drinkData.get("data");
			System.out.println(drinkdata2.get(1));
			
			
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
