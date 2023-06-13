
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class roomAPI {
	public static void main(String[] args) {
		// 도시 이름 --> 날씨
		// open API
//	https:api.openweathermap.org/data/2.5/weather?q=seoul&unists=metric&appid=e7b1a57cd2158c8d195bfb24b7597bad	
//	e7b1a57cd2158c8d195bfb24b7597bad
//	https://api.openweathermap.org/data/2.5/weather?q=seoul&appid=e7b1a57cd2158c8d195bfb24b7597bad
//	https://api.openweathermap.org/data/2.5/weather?q=seoul&unists=metric&appid=e7b1a57cd2158c8d195bfb24b7597bad	
	
	String url = "http://api.visitjeju.net/vsjApi/contents/searchlist?apiKey=x8uwubc8s4qzunfb&locale=kr";
	
	try {
			URL u = new URL(url);
			HttpsURLConnection huc = (HttpsURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");

			System.out.println(url);

			// jSON 문법
			// 언어가 다르니까 자바코드로 접근하여 처리하기 어렵다.
			// 라이브러리(도구)

			// jSON 데이터 받은거 파싱하게 jSONparser 객체가 필요
			JSONParser jp = new JSONParser();

			// 만든 객체로 isr(받은 데이터) 넣어서 파싱 준비
			JSONObject item = (JSONObject) jp.parse(isr);
			System.out.println(weatherData);

	} catch (Exception e) {
		e.printStackTrace();
	}
	
		
		//원하는 데이터만
		
		//날씨 설명
		JSONArray items = (JSONArray) .get("items");
		JSONArray wo = (JSONArray) items.get(0);
		System.out.println("날씨 : "+ wo); 
		
				
		
		
		//국가
	
		
		
	}

}
