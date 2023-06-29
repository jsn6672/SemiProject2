package com.sj.gourmet;

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
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.jstl.sql.Result;

import org.apache.jasper.compiler.NewlineReductionServletWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

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

			String select = request.getParameter("select");
			System.out.println(select);
			String url = ""; 
			System.out.println(url);
			if (select.equals("name")) {
				url = "https://api.visitjeju.net/vsjApi/contents/searchList?apiKey=h4pgnhsr49ndslpf&locale=kr&category=c4&pag&title=" + input;
			} else if (select.equals("location")) {
				url = "https://api.visitjeju.net/vsjApi/contents/searchList?apiKey=h4pgnhsr49ndslpf&locale=kr&category=c4&pag&alltag=" + input;
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
			Connection con = DBManager.connect();
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			Gourmet g = null;
			for (int i = 0; i < data.size(); i++) {
				ArrayList<Gourmet> gourmets = new ArrayList<Gourmet>();
				System.out.println(i);
				GourmetInfo2 gourmetInfo = new GourmetInfo2();
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
					
					g.setGm_l_no("gm_user");
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
		
		String sql = "insert into sj_gourmet_review values (gm_no_seq.nextval, ?, 0, ?, ?, sysdate, ?, ?, 0)";
		try {

			
			  String savePath="C:\\student\\"; File isDir = new File(savePath);
			  if(!isDir.isDirectory()){ System.out.println("디렉토리가 없습니다. 디렉토리를 새로 생성합니다.");
			  isDir.mkdir(); } System.out.println(savePath);
			 

		    
			 MultipartRequest mr = new MultipartRequest(request, savePath, 30*1024*1024,
			 "utf-8", new DefaultFileRenamePolicy());
			 
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
			
			String id = mr.getParameter("sj-r_id");
			System.out.println(id);
			/* String user = request.getParameter("gm_l_no"); */
			String pw = mr.getParameter("sj-r_pw");
			String grade = mr.getParameter("sj-reviewGrade");
			String menu = mr.getParameter("sj-r_menu");
			String review = mr.getParameter("sj-r_text");
//			String pic = request.getParameter("sj-r_pic");
			
			System.out.println(id);
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
