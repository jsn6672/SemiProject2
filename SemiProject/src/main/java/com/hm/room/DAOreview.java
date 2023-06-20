package com.hm.room;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;

import com.hm.main.DBManager;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class DAOreview {

	public static void regReview(HttpServletRequest request) {

		String path = request.getServletContext().getRealPath("img");

		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into hotelR_test values(hotelR_test_seq.nextval,?,?,?,?,?,?)";

		try {
			MultipartRequest mr = new MultipartRequest(request, path, 30 * 1024 * 1024, "utf-8",
					new DefaultFileRenamePolicy());

			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);

			String username = mr.getParameter("r_username");
			String content = mr.getParameter("r_contnet");
			String contentname = mr.getParameter("r_contnetname");
			String title = mr.getParameter("r_title");
			double starpoint = Double.parseDouble(mr.getParameter("r_starpoint"));
			String review = mr.getParameter("r_review");
			String img = mr.getFilesystemName("r_img");

			pstmt.setString(1, username);
			pstmt.setString(2, content);
			pstmt.setString(3, contentname);
			pstmt.setString(4, title);
			pstmt.setDouble(5, starpoint);
			pstmt.setString(6, img);

			if (pstmt.executeUpdate() == 1) {
				System.out.println("등록 성공");
				request.setAttribute("r", "등록완료");

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
		}

	}

	public static void DeleteReview(HttpServletRequest request) {
			
		String sql = "delete hotelR_test where r_no=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = DBManager.connect();
			pstmt= con.prepareStatement(sql);
			
			if (pstmt.executeUpdate() == 1) {
				System.out.println("삭제 완료");
				request.setAttribute("r", "삭제 완료");
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, null);
		}
			
	}

}
