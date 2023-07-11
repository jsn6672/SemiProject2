package com.sj.gourmet;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.channels.SelectableChannel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.sql.Result;
import javax.swing.Spring;

import org.apache.jasper.compiler.NewlineReductionServletWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.hm.room.Hotel;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

import netscape.javascript.JSObject;
import java.sql.Connection;






public class GourmetM {

	public static void searchGourmet(HttpServletRequest request, Object String) {

		try {
			request.setCharacterEncoding("UTF-8"); // post �슂泥� �떆 �븳湲� �븞源⑥�寃� �븯�뒗 踰�
			
			String input = request.getParameter("input");
			System.out.println(input);
			input = URLEncoder.encode(input, "utf-8");
			System.out.println(input);

			String select = request.getParameter("type");
			System.out.println(select);
			String url = ""; 
			System.out.println(url);
			if (select.equals("name")) {
			    url = "https://api.visitjeju.net/vsjApi/contents/searchList?apiKey=h4pgnhsr49ndslpf&locale=kr&category=c4&pag=&title=" + input;
			} else if (select.equals("location")) {
			    url = "https://api.visitjeju.net/vsjApi/contents/searchList?apiKey=h4pgnhsr49ndslpf&locale=kr&category=c4&pag=&alltag=" + input;
			}
			System.out.println(url);
			
			URL u = new URL(url);
			HttpsURLConnection huc = (HttpsURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			System.out.println("isr" + isr);

			JSONParser jp = new JSONParser();
			JSONObject restaurant = (JSONObject) jp.parse(isr);
			System.out.println("restaurant :" + restaurant);	 
//			JSONObject items = (JSONObject) restaurant.get("items");
//			System.out.println("items :" + items);	 
//			JSONObject repPhoto = (JSONObject) items.get("repPhoto");
//			System.out.println("repPhoto :" + repPhoto);	 
//			JSONObject photoid = (JSONObject) repPhoto.get("photoid");
//			System.out.println("photoid :" + photoid);	 
			JSONArray data = (JSONArray) restaurant.get("items");
			System.out.println(data);
			
			System.out.println(data.size());
			ArrayList<GourmetInfo2> gourmetInfos = new ArrayList<GourmetInfo2>();
			String id = "";
			String name = "";
			String tel = "";
			String addr = "";
			String menu = "";
			String img = "";
			
			String reviewSql = "select * from sj_gourmet_review where gm_store = ?";
			String reviewSql2 = "select * from jh_account where a_id=?";
			Connection con = DBManager.connect();
			PreparedStatement pstmt = null;
			PreparedStatement pstmt2 = null;
			ResultSet rs = null;
			Gourmet g = null;
			ArrayList<Gourmet> gourmets = new ArrayList<Gourmet>();
			for (int i = 0; i < 10; i++) {
				
				System.out.println("이게 ㅑ 임" + i);
				GourmetInfo2 gourmetInfo = new GourmetInfo2();
				try {
					JSONObject info = (JSONObject) data.get(i);
					
				
				JSONObject repPhoto = (JSONObject) info.get("repPhoto");
//				System.out.println("repPhoto :" + repPhoto);	 
				JSONObject photoid = (JSONObject) repPhoto.get("photoid");
//				System.out.println("photoid :" + photoid);	 
				
				id = (String) info.get("contentsid");
				name = (String) info.get("title");
//				System.out.println("-----------");
//				System.out.println(name);
				tel = (String) info.get("phoneno");
//				System.out.println(tel);
				addr = (String) info.get("roadaddress");
//				System.out.println(addr);
				menu = (String) info.get("alltag");
//				System.out.println(menu);
				img = (String) photoid.get("imgpath");
//				System.out.println(img);
//				System.out.println("------------");

				} catch (IndexOutOfBoundsException e) {
					break;
				}
				gourmetInfo.setId(id);
				gourmetInfo.setName(name); 
				gourmetInfo.setTel(tel);
				gourmetInfo.setAddr(addr); 
				gourmetInfo.setMenu(menu);
				gourmetInfo.setImg(img);
				
				
				pstmt = con.prepareStatement(reviewSql);
				pstmt.setString(1, id);
				
				rs = pstmt.executeQuery();
				System.out.println(id);
				while (rs.next()) {
					g = new Gourmet();
					
					g.setGm_no(rs.getString("gm_no"));
					g.setGm_g_no(rs.getString("gm_store"));
					pstmt2 = con.prepareStatement(reviewSql2);
					/*
					 * String name2 = rs.getString("gm_user"); pstmt2.setString(1, name2);
					 */
					/* g.setGm_l_no("rs.getString("a_name")); */
					g.setGm_l_no(rs.getString("gm_user"));
					g.setGm_pw(rs.getString("gm_pw"));
					g.setGm_grade(rs.getString("gm_grade"));
					g.setGm_date(rs.getString("gm_date"));
					g.setGm_menu(rs.getString("gm_menu"));
					g.setGm_review(rs.getString("gm_review"));
					g.setGm_pic(rs.getString("gm_pic"));
					gourmets.add(g);
					System.out.println(g);
				}
				gourmetInfo.setReviews(gourmets);
				gourmetInfos.add(gourmetInfo);
			}
			request.setAttribute("gourmetInfos", gourmetInfos);
			request.setAttribute("input", input);
			request.setAttribute("select", select);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}

	}

	/*
	 * public static void mapGourmet(HttpServletRequest request) {
	 * 
	 * String addr = request.getParameter("addr"); System.out.println(addr);
	 * request.setAttribute("addr", addr);
	 * 
	 * }
	 * 
	 * public static void saveDB(HttpServletRequest request) {
	 * 
	 * Connection con = null; PreparedStatement pstmt = null;
	 * 
	 * String sql = "insert into sj_gourmet_db value (?,?,?,?,?,?,?,?,?,?)";
	 * 
	 * try { con = DBManager.connect(); pstmt = con.prepareStatement(sql);
	 * 
	 * request.setCharacterEncoding("utf-8");
	 * 
	 * 
	 * 
	 * String url = ""; url =
	 * "https://api.visitjeju.net/vsjApi/contents/searchList?apiKey=h4pgnhsr49ndslpf&locale=kr&category=c4";
	 * 
	 * URL u = new URL(url); HttpsURLConnection huc = (HttpsURLConnection)
	 * u.openConnection(); InputStream is = huc.getInputStream(); InputStreamReader
	 * isr = new InputStreamReader(is, "utf-8"); System.out.println("isr" + isr);
	 * 
	 * JSONParser jp = new JSONParser(); JSONObject restaurant = (JSONObject)
	 * jp.parse(isr); System.out.println("restaurant :" + restaurant); // JSONObject
	 * items = (JSONObject) restaurant.get("items"); // System.out.println("items :"
	 * + items); // JSONObject repPhoto = (JSONObject) items.get("repPhoto"); //
	 * System.out.println("repPhoto :" + repPhoto); // JSONObject photoid =
	 * (JSONObject) repPhoto.get("photoid"); // System.out.println("photoid :" +
	 * photoid); JSONArray data = (JSONArray) restaurant.get("items");
	 * System.out.println(data);
	 * 
	 * System.out.println(data.size()); ArrayList<GourmetInfo> gourmetInfos = new
	 * ArrayList<GourmetInfo>(); String name = ""; String tel = ""; String addr =
	 * ""; String menu = ""; String img = ""; for (int i = 0; i < data.size(); i++)
	 * { GourmetInfo gourmetInfo = new GourmetInfo(); JSONObject info = (JSONObject)
	 * data.get(i);
	 * 
	 * JSONObject repPhoto = (JSONObject) info.get("repPhoto"); //
	 * System.out.println("repPhoto :" + repPhoto); JSONObject photoid =
	 * (JSONObject) repPhoto.get("photoid"); // System.out.println("photoid :" +
	 * photoid);
	 * 
	 * 
	 * name = (String) info.get("title"); // System.out.println("-----------"); //
	 * System.out.println(name); tel = (String) info.get("phoneno"); //
	 * System.out.println(tel); addr = (String) info.get("roadaddress"); //
	 * System.out.println(addr); menu = (String) info.get("alltag"); //
	 * System.out.println(menu); img = (String) photoid.get("imgpath"); //
	 * System.out.println(img); // System.out.println("------------");
	 * 
	 * 
	 * gourmetInfo.setName(name); gourmetInfo.setTel(tel);
	 * gourmetInfo.setAddr(addr); gourmetInfo.setMenu(menu);
	 * gourmetInfo.setImg(img);
	 * 
	 * gourmetInfos.add(gourmetInfo);
	 * 
	 * } request.setAttribute("gourmetInfos", gourmetInfos);
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } finally { DBManager.close(con,
	 * pstmt, null); }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 */

	public static void regReviewGourmet(HttpServletRequest request) {

		Connection con=null;
		PreparedStatement pstmt=null;
		String path = request.getServletContext().getRealPath("sj/fileUpload");
		String sql = "insert into sj_gourmet_review values (gm_no_seq.nextval, ?, 0, ?, ?, sysdate, ?, ?, 0)";
//		String sql = "insert into sj_gourmet_review values (gm_no_seq.nextval, ?, ?, ?, ?, sysdate, ?, ?, 0)";
		try {
			MultipartRequest mr = new MultipartRequest(request, path, 30*1024*1024, "utf-8", new DefaultFileRenamePolicy());
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			
			request.setCharacterEncoding("utf-8");
			
			/*
			 * 리뷰 PK 
			 * 1. 가게 ID 
			 * 2. 유저 
			 * 3. 패스워드 
			 * 4. 평점 
			 * 날짜 
			 * 5. 메뉴 
			 * 6. 리뷰 
			 * 7. 사진
			 */
			
			String id = mr.getParameter("g_id_s");
			System.out.println(id);
			/* String user = request.getParameter("gm_l_no"); */
			String pw = mr.getParameter("sj-r_pw");
			String grade = mr.getParameter("sj-reviewGrade");
			String menu = mr.getParameter("sj-r_menu");
			String review = mr.getParameter("sj-r_text");
//			String pic = request.getParameter("sj-r_pic");
			System.out.println("------------------------");
			System.out.println(id);
			System.out.println("------------------------");
			System.out.println(pw);
			System.out.println(grade);
			System.out.println(menu);
			System.out.println(review);
//			System.out.println(pic);
			
			pstmt.setString(1, id);
			/* pstmt.setString(2, user); */
			pstmt.setString(2, pw);
			pstmt.setString(3, grade);
			pstmt.setString(4, menu);
			pstmt.setString(5, review);
//			pstmt.setString(6, pic);
			
			if (pstmt.executeUpdate() == 1) {
				System.out.println("등록성공!");
				request.setAttribute("등록성공", "등록성공");			
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "db server error...");
		} finally {
			DBManager.close(con, pstmt, null);
		}
		
		
	

	
//	public static void getAllReview(HttpServletRequest request) {
//		
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		String sql = "select * from sj_gourmet_review where gm_store = ?";
//		try {
//			con = DBManager.connect();
//			pstmt = con.prepareStatement(sql);
//			String id = request.getParameter("reviewId");
//			System.out.println(id);
//			
//			pstmt.setString(1, id);
//			rs = pstmt.executeQuery();
//			
//			Gourmet g = null;
//			
//			ArrayList<Gourmet2> gourmets = new ArrayList<Gourmet2>();
//			
//			while (rs.next()) {
//				g = new Gourmet2();
//				
//				g.setGm_no(rs.getString("gm_no"));
//				g.setGm_g_no(rs.getString("gm_g_no"));
//				g.setGm_l_no("gm_l_no");
//				g.setGm_pw(rs.getString("gm_pw"));
//				g.setGm_grade(rs.getString("gm_grade"));
//				g.setGm_date(rs.getString("gm_date"));
//				g.setGm_menu(rs.getString("gm_menu"));
//				g.setGm_review(rs.getString("gm_review"));
//				g.setGm_pic(rs.getString("gm_pic"));
//				gourmets.add(g);
//			}
//			request.setAttribute("gourmets", gourmets);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DBManager.close(con, pstmt, rs);
//		}
//		
//		
//	}

	}

	public static void delReview(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "delete sj_gourmet_review where gm_no=?";
	
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			String no = request.getParameter("no");
			pstmt.setString(1, no);
			
			if (pstmt.executeUpdate() == 1) {
				System.out.println("삭제 성공!");
				request.setAttribute("r", "삭제 성공!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
		}
		
	}

	public static void getGourmet(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8"); // post �슂泥� �떆 �븳湲� �븞源⑥�寃� �븯�뒗 踰�
			
			String input = "애월";
			System.out.println(input);
			input = URLEncoder.encode(input, "utf-8");
			System.out.println(input);
			String select = "name";
			
			String url = "https://api.visitjeju.net/vsjApi/contents/searchList?apiKey=h4pgnhsr49ndslpf&locale=kr&category=c4&pag=&title=%EC%95%A0%EC%9B%94"; 
			System.out.println(url);
			
			System.out.println(url);
			
			URL u = new URL(url);
			HttpsURLConnection huc = (HttpsURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			System.out.println("isr" + isr);

			JSONParser jp = new JSONParser();
			JSONObject restaurant = (JSONObject) jp.parse(isr);
			System.out.println("restaurant :" + restaurant);	 
//			JSONObject items = (JSONObject) restaurant.get("items");
//			System.out.println("items :" + items);	 
//			JSONObject repPhoto = (JSONObject) items.get("repPhoto");
//			System.out.println("repPhoto :" + repPhoto);	 
//			JSONObject photoid = (JSONObject) repPhoto.get("photoid");
//			System.out.println("photoid :" + photoid);	 
			JSONArray data = (JSONArray) restaurant.get("items");
			System.out.println(data);
			
			System.out.println(data.size());
			ArrayList<GourmetInfo2> gourmetInfos = new ArrayList<GourmetInfo2>();
			String id = "";
			String name = "";
			String tel = "";
			String addr = "";
			String menu = "";
			String img = "";
			
			String reviewSql = "select * from sj_gourmet_review where gm_store = ?";
			String reviewSql2 = "select * from jh_account where a_id=?";
			Connection con = DBManager.connect();
			PreparedStatement pstmt = null;
			PreparedStatement pstmt2 = null;
			ResultSet rs = null;
			Gourmet g = null;
			ArrayList<Gourmet> gourmets = new ArrayList<Gourmet>();
			for (int i = 0; i < 10; i++) {
				
				System.out.println("이게 ㅑ 임" + i);
				GourmetInfo2 gourmetInfo = new GourmetInfo2();
				try {
					JSONObject info = (JSONObject) data.get(i);
					
				
				JSONObject repPhoto = (JSONObject) info.get("repPhoto");
//				System.out.println("repPhoto :" + repPhoto);	 
				JSONObject photoid = (JSONObject) repPhoto.get("photoid");
//				System.out.println("photoid :" + photoid);	 
				
				id = (String) info.get("contentsid");
				name = (String) info.get("title");
//				System.out.println("-----------");
//				System.out.println(name);
				tel = (String) info.get("phoneno");
//				System.out.println(tel);
				addr = (String) info.get("roadaddress");
//				System.out.println(addr);
				menu = (String) info.get("alltag");
//				System.out.println(menu);
				img = (String) photoid.get("imgpath");
//				System.out.println(img);
//				System.out.println("------------");

				} catch (IndexOutOfBoundsException e) {
					break;
				}
				gourmetInfo.setId(id);
				gourmetInfo.setName(name); 
				gourmetInfo.setTel(tel);
				gourmetInfo.setAddr(addr); 
				gourmetInfo.setMenu(menu);
				gourmetInfo.setImg(img);
				
				
				pstmt = con.prepareStatement(reviewSql);
				pstmt.setString(1, id);
				
				rs = pstmt.executeQuery();
				System.out.println(id);
				while (rs.next()) {
					g = new Gourmet();
					
					g.setGm_no(rs.getString("gm_no"));
					g.setGm_g_no(rs.getString("gm_store"));
					pstmt2 = con.prepareStatement(reviewSql2);
					/*
					 * String name2 = rs.getString("gm_user"); pstmt2.setString(1, name2);
					 */
					/* g.setGm_l_no("rs.getString("a_name")); */
					g.setGm_l_no(rs.getString("gm_user"));
					g.setGm_pw(rs.getString("gm_pw"));
					g.setGm_grade(rs.getString("gm_grade"));
					g.setGm_date(rs.getString("gm_date"));
					g.setGm_menu(rs.getString("gm_menu"));
					g.setGm_review(rs.getString("gm_review"));
					g.setGm_pic(rs.getString("gm_pic"));
					gourmets.add(g);
					System.out.println(g);
				}
				gourmetInfo.setReviews(gourmets);
				gourmetInfos.add(gourmetInfo);
			}
			request.setAttribute("gourmetInfos", gourmetInfos);
			request.setAttribute("input", input);
			request.setAttribute("select", select);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}


		
		
		
		
		
		
		
		
		
	}
	

	
	public static void gourmetJP (HttpServletRequest request) {
        String clientId = "3lFmzsOXfAGQFCakLmWQ";//애플리케이션 클라이언트 아이디값";
        String clientSecret = "BSgrXS8Wea";//애플리케이션 클라이언트 시크릿값";

        String apiURL = "https://openapi.naver.com/v1/papago/n2mt";
        String text;
        try {
            text = URLEncoder.encode("안녕하세요. 오늘 기분은 어떻습니까?", "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("인코딩 실패", e);
        }

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("X-Naver-Client-Id", clientId);
        requestHeaders.put("X-Naver-Client-Secret", clientSecret);

        String responseBody = post(apiURL, requestHeaders, text);

        System.out.println(responseBody);
    }

    private static String post(String apiUrl, Map<String, String> requestHeaders, String text){
        HttpURLConnection con = connect(apiUrl);
        String postParams = "source=ko&target=jp&text=" + text;
        try {
            con.setRequestMethod("POST");
            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
                con.setRequestProperty(header.getKey(), header.getValue());
            }

            con.setDoOutput(true);
            try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
                wr.write(postParams.getBytes());
                wr.flush();
            }

            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 응답
                return readBody(con.getInputStream());
            } else {  // 에러 응답
                return readBody(con.getErrorStream());
            }
        } catch (Exception e) {
            throw new RuntimeException("API 요청과 응답 실패", e);
        } finally {
            con.disconnect();
        }
    }

    private static HttpURLConnection connect(String apiUrl){
        try {
            URL url = new URL(apiUrl);
            return (HttpURLConnection)url.openConnection();
        } catch (MalformedURLException e) {
            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
        } catch (Exception e) {
            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
        }
    }

    private static String readBody(InputStream body){
        InputStreamReader streamReader = new InputStreamReader(body);

        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
            StringBuilder responseBody = new StringBuilder();

            String line;
            while ((line = lineReader.readLine()) != null) {
                responseBody.append(line);
            }

            return responseBody.toString();
        } catch (Exception e) {
            throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
        }
    }

	public static void searchGourmetJP(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8"); // post �슂泥� �떆 �븳湲� �븞源⑥�寃� �븯�뒗 踰�
			
			String input = "";
			System.out.println(input);
			input = URLEncoder.encode(input, "utf-8");
			System.out.println(input);
			String select = "name";
			
			String url = "https://api.visitjeju.net/vsjApi/contents/searchList?apiKey=h4pgnhsr49ndslpf&locale=jp&category=c4"; 
			System.out.println(url);
			
			System.out.println(url);
			
			URL u = new URL(url);
			HttpsURLConnection huc = (HttpsURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			System.out.println("isr" + isr);

			JSONParser jp = new JSONParser();
			JSONObject restaurant = (JSONObject) jp.parse(isr);
			System.out.println("restaurant :" + restaurant);	 
//			JSONObject items = (JSONObject) restaurant.get("items");
//			System.out.println("items :" + items);	 
//			JSONObject repPhoto = (JSONObject) items.get("repPhoto");
//			System.out.println("repPhoto :" + repPhoto);	 
//			JSONObject photoid = (JSONObject) repPhoto.get("photoid");
//			System.out.println("photoid :" + photoid);	 
			JSONArray data = (JSONArray) restaurant.get("items");
			System.out.println(data);
			
			System.out.println(data.size());
			ArrayList<GourmetInfo2> gourmetInfos = new ArrayList<GourmetInfo2>();
			String id = "";
			String name = "";
			String tel = "";
			String addr = "";
			String menu = "";
			String img = "";
			
			String reviewSql = "select * from sj_gourmet_review where gm_store = ?";
			String reviewSql2 = "select * from jh_account where a_id=?";
			Connection con = DBManager.connect();
			PreparedStatement pstmt = null;
			PreparedStatement pstmt2 = null;
			ResultSet rs = null;
			Gourmet g = null;
			ArrayList<Gourmet> gourmets = new ArrayList<Gourmet>();
			for (int i = 0; i < 10; i++) {
				
				System.out.println("이게 ㅑ 임" + i);
				GourmetInfo2 gourmetInfo = new GourmetInfo2();
				try {
					JSONObject info = (JSONObject) data.get(i);
					
				
				JSONObject repPhoto = (JSONObject) info.get("repPhoto");
//				System.out.println("repPhoto :" + repPhoto);	 
				JSONObject photoid = (JSONObject) repPhoto.get("photoid");
//				System.out.println("photoid :" + photoid);	 
				
				id = (String) info.get("contentsid");
				name = (String) info.get("title");
//				System.out.println("-----------");
//				System.out.println(name);
				tel = (String) info.get("phoneno");
//				System.out.println(tel);
				addr = (String) info.get("roadaddress");
//				System.out.println(addr);
				menu = (String) info.get("alltag");
//				System.out.println(menu);
				img = (String) photoid.get("imgpath");
//				System.out.println(img);
//				System.out.println("------------");

				} catch (IndexOutOfBoundsException e) {
					break;
				}
				gourmetInfo.setId(id);
				gourmetInfo.setName(name); 
				gourmetInfo.setTel(tel);
				gourmetInfo.setAddr(addr); 
				gourmetInfo.setMenu(menu);
				gourmetInfo.setImg(img);
				
				
				pstmt = con.prepareStatement(reviewSql);
				pstmt.setString(1, id);
				
				rs = pstmt.executeQuery();
				System.out.println(id);
				while (rs.next()) {
					g = new Gourmet();
					
					g.setGm_no(rs.getString("gm_no"));
					g.setGm_g_no(rs.getString("gm_store"));
					pstmt2 = con.prepareStatement(reviewSql2);
					/*
					 * String name2 = rs.getString("gm_user"); pstmt2.setString(1, name2);
					 */
					/* g.setGm_l_no("rs.getString("a_name")); */
					g.setGm_l_no(rs.getString("gm_user"));
					g.setGm_pw(rs.getString("gm_pw"));
					g.setGm_grade(rs.getString("gm_grade"));
					g.setGm_date(rs.getString("gm_date"));
					g.setGm_menu(rs.getString("gm_menu"));
					g.setGm_review(rs.getString("gm_review"));
					g.setGm_pic(rs.getString("gm_pic"));
					gourmets.add(g);
					System.out.println(g);
				}
				gourmetInfo.setReviews(gourmets);
				gourmetInfos.add(gourmetInfo);
			}
			request.setAttribute("gourmetInfos", gourmetInfos);
			request.setAttribute("input", input);
			request.setAttribute("select", select);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	
		
		
	}	
	
}