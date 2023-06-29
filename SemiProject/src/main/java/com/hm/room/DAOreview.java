package com.hm.room;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

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

			String sql = "insert into hotelR_test values(hotelR_test_seq.nextval,?,?,?,?,?,?,?)";

			String id1 = "hmin0701";

			con = DBManager2.connect();
			pstmt = con.prepareStatement(sql);

			String pk = mr.getParameter("hm_r_pk");
			String id = id1;
			String hotelname = mr.getParameter("hm_r_title");
			String grade = mr.getParameter("hm_reviewGrade");
			String text = mr.getParameter("hm_r_text");
			String img = mr.getFilesystemName("hm_r_pic");

			System.out.println(pk);
			System.out.println(id);
			System.out.println(hotelname);
			System.out.println(grade);
			System.out.println(text);
			System.out.println(img);

			// 현재 날짜와 시간을 가져옴
			Timestamp currentDate = new Timestamp(System.currentTimeMillis());

			pstmt.setString(1, pk);
			pstmt.setString(2, id);
			pstmt.setString(3, hotelname);
			pstmt.setString(4, grade);
			pstmt.setString(5, text);
			pstmt.setString(6, img);
			pstmt.setTimestamp(7, currentDate); // 현재 날짜와 시간을 설정

			if (pstmt.executeUpdate() == 1) {
				System.out.println("등록 성공");
				request.setAttribute("r", "등록 성공");
				request.setAttribute("no", pk);
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
		String sql = "select * from hotelR_test where r_cid = ?";

		String cid = (String) request.getAttribute("r_cid");
		try {
			con = DBManager2.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cid);
			rs = pstmt.executeQuery();
			Review r = null;
			

			reviews = new ArrayList<Review>();
			while (rs.next()) {
				String id = "hmin0701";
				String hotelname = rs.getString("r_hotelname");
				double grade = rs.getDouble("r_grade");
				String text = rs.getString("r_text");
				String img = rs.getString("r_img");
				String date = rs.getString("r_date");
				
				r= new Review(no ,cid, id, hotelname, grade, text, img, date);
						
						
				System.out.println(hotelname);
				System.out.println(date);
				

			}
			request.setAttribute("r", reviews);
			System.out.println("조회완료");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager2.close(con, pstmt, rs);
		}

	}

}
