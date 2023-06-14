package com.hm.room;


	import java.io.InputStream;
	import java.io.InputStreamReader;
	import java.net.MalformedURLException;
	import java.net.URL;
	import java.util.Scanner;

	import javax.net.ssl.HttpsURLConnection;
	import javax.print.DocFlavor.INPUT_STREAM;

	import org.json.simple.JSONArray;
	import org.json.simple.JSONObject;
	import org.json.simple.parser.JSONParser;

	import netscape.javascript.JSObject;
	
	
	public class data {
		public static void main(String[] args) {
			
//			도시 이름 > 날씨
//				open API
			
//			open api 날씨 키e7b1a57cd2158c8d195bfb24b7597bad
			
//			https://api.openweathermap.org/data/2.5/weather?q=seoul&appid=e7b1a57cd2158c8d195bfb24b7597bad

			Scanner sc = new Scanner(System.in);
			System.out.println("please city name");
			String city = sc.next();
			
			String url = "https://api.openweathermap.org/data/2.5/weather?q="+city+"&units=metric&appid=e7b1a57cd2158c8d195bfb24b7597bad";
			
			
			
			try {
				URL u = new URL(url);
				HttpsURLConnection huc = (HttpsURLConnection) u.openConnection();			
				
				InputStream is = huc.getInputStream();
				InputStreamReader isr = new InputStreamReader(is, "utf-8");
				
				System.out.println(isr);
				
//				json 문법
//				언어가 다르니까 자바 코드로 접근, 처리가 불편
//				라이브러리(도구)
				
//				json 데이터 받은거 파싱하게 jsonparser 객체가 필요
				JSONParser jp = new JSONParser();
				
//				만든 그 객체러 isr(받은 데이터) 넣어서 파싱 준비
				JSONObject weatherData = (JSONObject) jp.parse(isr);
				System.out.println(weatherData);
				
//				원하는 데이터만 뽑기
				
//				날씨 설명
				JSONArray weather = (JSONArray) weatherData.get("weather");
				JSONObject wo = (JSONObject) weather.get(0);
				System.out.println("날씨 : " + wo.get("description"));
				
//				국가
				JSONObject sys = (JSONObject) weatherData.get("sys");
				System.out.println("국가 : " + sys.get("country"));
				
				
//				도시
				System.out.println("도시 : " + weatherData.get("name"));
				
//				온도
				JSONObject main = (JSONObject)weatherData.get("main");
				System.out.println("온도 : " + main.get("temp"));
				
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}


