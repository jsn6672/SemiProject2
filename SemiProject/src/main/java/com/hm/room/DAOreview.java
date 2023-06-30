package com.hm.room;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sound.sampled.AudioFileFormat.Type;
import javax.xml.crypto.Data;

import com.hm.main.DBManager2;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class DAOreview {

	private static ArrayList<Review> reviews;

	public static void regReview(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			String path = request.getServletContext().getRealPath("img");

			MultipartRequest mr = new MultipartRequest(request, path, 30 * 1024 * 1024, "utf-8",
					new DefaultFileRenamePolicy());

			String sql = "insert into hotelR_test values(hotelR_test_seq.nextval,?,?,?,?,?,?,?,sysdate)";

			String id1 = "hmin0701";

			con = DBManager2.connect();
			pstmt = con.prepareStatement(sql);

			String cid = mr.getParameter("hm_r_cid");
			String id = id1;
			String title = mr.getParameter("hm_r_title");
			String reviewname = mr.getParameter("hm_r_reviewname");
			String grade = mr.getParameter("hm_reviewGrade");
			String text = mr.getParameter("hm_r_text");
			String img = mr.getFilesystemName("hm_r_pic");

			System.out.println(cid);
			System.out.println(id);
			System.out.println(title);
			System.out.println(reviewname);
			System.out.println(grade);
			System.out.println(text);
			System.out.println(img);

			pstmt.setString(1, cid);
			pstmt.setString(2, id);
			pstmt.setString(3, title);
			pstmt.setString(4, reviewname);
			pstmt.setString(5, grade);
			pstmt.setString(6, text);
			pstmt.setString(7, img);

			if (pstmt.executeUpdate() == 1) {
				System.out.println("등록 성공");
				request.setAttribute("r", "등록 성공");
				request.setAttribute("no", cid);
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "db server error");
		} finally {
			DBManager2.close(con, pstmt, null);
		}

	}

	public static void getAllReview(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from hotelR_test";

		try {
			con = DBManager2.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			Review r = null;
			
			reviews = new ArrayList<Review>();
			while (rs.next()) {
				int no = rs.getInt("r_no");
				String cid = rs.getString("r_cid");
				String id = "hmin0701";
				String title = rs.getString("r_title");
				String reviewname = rs.getString("r_reviewname");
				double grade = rs.getDouble("r_grade");
				String text = rs.getString("r_text");
				String img = rs.getString("r_img");
				Date date = rs.getDate("r_date");

				System.out.println(no);
				System.out.println(cid);
				System.out.println(id);
				System.out.println(title);
				System.out.println(reviewname);
				System.out.println(text);
				System.out.println(img);
				System.out.println(date);
				
				r = new Review(no, cid, id, title, reviewname, grade, text, img, date);
				reviews.add(r);
			}
			request.setAttribute("reviews", reviews);
			System.out.println("조회완료");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager2.close(con, pstmt, rs);
		}

	}

	public static void getReview(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String search = request.getParameter("titleSearch");
		System.out.println(search);
		String sql = "select * from hotelR_test where r_title LIKE '%' || ? || '%'";

		try {
			
			con = DBManager2.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + search + "%");
			rs = pstmt.executeQuery();
			Review r = null;

			
			 reviews = new ArrayList<Review>();
		
			while(rs.next()) {
			int no = rs.getInt("r_no");
			String cid = rs.getString("r_cid");
			String id = "hmin0701";
			String title = rs.getString("r_title");
			String reviewname = rs.getString("r_reviewname");
			double grade = rs.getDouble("r_grade");
			String text = rs.getString("r_text");
			String img = rs.getString("r_img");
			Date date = rs.getDate("r_date");

			System.out.println(no);
			System.out.println(cid);
			System.out.println(id);
			System.out.println(title);
			System.out.println(reviewname);
			System.out.println(text);
			System.out.println(img);
			System.out.println(date);
			
			reviews.add(new Review(no, cid, id, title, reviewname, grade, text, img, date));
			request.setAttribute("reviews", reviews);
			}
		} catch (Exception e) {

		} finally {
			DBManager2.close(con, pstmt, rs);
		}
		
	}

	public static void deleteReview(HttpServletRequest request) {

		Connection con =null;
		PreparedStatement pstmt = null;
		String sql = "delete from hotelR_test where r_no = ?";
		try {
				con =DBManager2.connect();
				pstmt = con.prepareStatement(sql);
				
				String no = request.getParameter("deleteReview");
				pstmt.setString(1, no);
				
				if (pstmt.executeUpdate() == 1) {
					System.out.println("삭제 성공!");
				}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBManager2.close(con, pstmt, null);
		}
		
		
		
	}

}