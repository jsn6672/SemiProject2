package com.jsn.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.Buffer;

import org.apache.tomcat.util.json.JSONParser;

public class api_to_db {
	public static void main(String[] args) {

		BufferedReader br = null;

		try {

			String urlStr = "https://api.odcloud.kr/api/3083352/v1/uddi:228d9097-c97f-45f4-ae95-ffa655af3cc8"
					+ "?serviceKey=eGNB6OGxHFZZaB9okpr%2FezV2NzpDYRpi%2FwesAhdum3W0EE2071UCXI8qUptQrW807fZvr58ocyvBmn5%2B2AtY9Q%3D%3D";

			URL url = new URL(urlStr);

			HttpURLConnection urlCon = (HttpURLConnection) url.openConnection();
			urlCon.setRequestMethod("GET"); // 대문자로
			urlCon.setRequestProperty("Content-type", "application/json");
			System.out.println("Response code: "+urlCon.getResponseCode());
			
			br = new BufferedReader(new InputStreamReader(urlCon.getInputStream(), "UTF-8"));
			
			StringBuilder sb = new StringBuilder();
			String line;
			while((line=br.readLine())!=null) {
				sb.append(line);
			}
			System.out.println(sb.toString());
			
			
			
			
			br.close();
			urlCon.disconnect();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
