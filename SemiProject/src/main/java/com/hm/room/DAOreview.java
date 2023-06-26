package com.hm.room;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.hm.main.DBManager2;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class DAOreview {

	private static ArrayList<Review> reviews;

	public static void regReview(HttpServletRequest request) {
			
		String path = request.getServletContext().getRealPath("img");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into hotelR_test values(hotelR_test_seq.nextval,?,?,?,?,?,?)";

		try {
			MultipartRequest mr = new MultipartRequest(request, path, 30 * 1024 * 1024, "utf-8",
					new DefaultFileRenamePolicy());
			

			con = DBManager2.connect();
			pstmt = con.prepareStatement(sql);

			String username = mr.getParameter("reg_username");
			String content = mr.getParameter("reg_content");
			String contentname = mr.getParameter("reg_contentname");
			double starpoint = Double.parseDouble(mr.getParameter("reg_starpoint"));
			String text = mr.getParameter("reg_text");
			String img = mr.getFilesystemName("reg_img");
			
			System.out.println(username);
			System.out.println(content);
			System.out.println(contentname);
			System.out.println(starpoint);
			System.out.println(text);
			System.out.println(img);

			pstmt.setString(1, username);
			pstmt.setString(2, content);
			pstmt.setString(3, contentname);
			pstmt.setDouble(4, starpoint);
			pstmt.setString(5, text);
			pstmt.setString(6, img);

			if (pstmt.executeUpdate() == 1) {
				System.out.println("등록 성공");
				request.setAttribute("r", "등록 성공");
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "db server error");

		} finally {
			DBManager2.close(con, pstmt, null);
		}

	}

	public static void DeleteReview(HttpServletRequest request) {

		String sql = "delete hotelR_test where r_no=?";
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DBManager2.connect();
			pstmt = con.prepareStatement(sql);

			if (pstmt.executeUpdate() == 1) {
				System.out.println("삭제 완료");
				request.setAttribute("r", "삭제 완료");

			}

		} catch (Exception e) {
			e.printStackTrace();
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

			reviews = new ArrayList<Review>();

			while (rs.next()) {

				int no = rs.getInt("r_no");
				String username = rs.getString("r_username");
				String content = rs.getString("r_content");
				String contentname = rs.getString("r_contentname");
				double starpoint = rs.getDouble("r_starpoint");
				String review = rs.getString("r_text");
				String img = rs.getString("r_img");
				reviews.add(new Review(no, username, content, contentname, starpoint, review, img));
			}
			request.setAttribute("r", reviews);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager2.close(con, pstmt, rs);
		}

	}

}
