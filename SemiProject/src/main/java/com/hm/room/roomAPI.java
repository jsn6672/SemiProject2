package com.hm.room;
import java.io.InputStream;

import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class roomAPI {
	public static void main(String[] args) {
		
		// open API
//	https:api.openweathermap.org/data/2.5/weather?q=seoul&unists=metric&appid=e7b1a57cd2158c8d195bfb24b7597bad	
//	e7b1a57cd2158c8d195bfb24b7597bad
//	https://api.openweathermap.org/data/2.5/weather?q=seoul&appid=e7b1a57cd2158c8d195bfb24b7597bad
//	https://api.openweathermap.org/data/2.5/weather?q=seoul&unists=metric&appid=e7b1a57cd2158c8d195bfb24b7597bad	
	
	// 일레인 호텔
	try {	
		
		Scanner sc = new Scanner(System.in);
		
		String search = sc.next();
		search = URLEncoder.encode(search,"utf-8");
		String url = "https://api.visitjeju.net/vsjApi/contents/searchList?apiKey=x8uwubc8s4qzunfb&locale=kr&category=c3&title=" + search;
			
			
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
	;

			JSONArray items = (JSONArray) room.get("items");
			for (int i = 0; i < items.size(); i++) {
				JSONObject roomeObj = (JSONObject) items.get(i);
				
				System.out.println(roomeObj.get("phoneno")); 
				System.out.println(roomeObj.get("latitude")); 
				System.out.println(roomeObj.get("longitude")); 
				System.out.println(roomeObj.get("address")); 
				System.out.println(roomeObj.get("roadaddress")); 
				System.out.println("-------------------------------");
			}
			
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	//원하는 데이터만
		
		
		
				
		
		
		//국가
	
		
		
	}

}
