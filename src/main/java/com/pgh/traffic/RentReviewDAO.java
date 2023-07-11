package com.pgh.traffic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class RentReviewDAO {

	private static ArrayList<RentReview> rentReviews;

	public static void allReview(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from rent_review where rent_shop_no = ? order by rent_date";
		String no = request.getParameter("no");

		if (no == null) {
			no = (String) request.getAttribute("no");
		}

		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, no);

			rs = pstmt.executeQuery();

			rentReviews = new ArrayList<RentReview>();
			RentReview rv = null;

			while (rs.next()) {
				int rentReviewNo = rs.getInt("rent_review_no");
				int rentShopNo = rs.getInt("rent_shop_no");
				String rentId = rs.getString("rent_id");
				int rentGrade = rs.getInt("rent_grade");
				Date rentDate = rs.getDate("rent_date");
				String rentCar = rs.getString("rent_car");
				String rentReview = rs.getString("rent_review");
				String rentImg = rs.getString("rent_img");
				rv = new RentReview(rentReviewNo, rentShopNo, rentId, rentGrade, rentDate, rentCar, rentReview,
						rentImg);
				rentReviews.add(rv);
			}
			request.setAttribute("rentReviews", rentReviews);
		} catch (Exception e) {
			System.out.println("db server error");
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	public static void regRentReview(HttpServletRequest request) {
		String path = request.getServletContext().getRealPath("gh/gh_filefolder");

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// Account ac = (Account) request.getSession().getAttribute("account");

		// String id = ac.getId();

		String sql = "insert into rent_review values(rent_review_seq.nextval, ?, ?, ?, sysdate, ?, ?, ?)";
		String avgsql = "select * from rentshop_data where shop_no = ?";
		String updatesql = "update rentshop_data set shop_grade_avg = ?, shop_grade_cnt = ? where shop_no = ?";

		try {
			MultipartRequest mr = new MultipartRequest(request, path, 30 * 1024 * 1024, "utf-8",
					new DefaultFileRenamePolicy());
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);

			String rentShopNo = mr.getParameter("rentShopNo");// 가게 넘버 가져오는 법?
			// String rentId = id;
			String rentId = "호";
			int rentGrade = Integer.parseInt(mr.getParameter("rentGrade"));
			String rentCar = mr.getParameter("rentCar");
			String rentReview = mr.getParameter("rentReview");
			String rentImg = mr.getFilesystemName("rentImg");
			System.out.println(rentImg);
			System.out.println(rentGrade);
			pstmt.setString(1, rentShopNo);
			pstmt.setString(2, rentId);
			pstmt.setInt(3, rentGrade);
			pstmt.setString(4, rentCar);
			pstmt.setString(5, rentReview);
			pstmt.setString(6, rentImg);

			if (pstmt.executeUpdate() == 1) {
				System.out.println("등록 성공!");
				request.setAttribute("no", rentShopNo);
				System.out.println("어트리뷰트값은 이거야 ㅇㅇ" + rentShopNo);
				pstmt = con.prepareStatement(avgsql);
				pstmt.setString(1, rentShopNo);
				rs = pstmt.executeQuery();
				
				rs.next();
				double shopGradeAvg = rs.getDouble("shop_grade_avg");
				int shopGradeCnt = rs.getInt("shop_grade_cnt");

				Double newavg = ((shopGradeAvg * shopGradeCnt) + rentGrade) / (shopGradeCnt + 1);

				pstmt = con.prepareStatement(updatesql);
				pstmt.setDouble(1, newavg);
				pstmt.setInt(2, shopGradeCnt + 1);
				pstmt.setString(3, rentShopNo);

				if (pstmt.executeUpdate() == 1) {
					System.out.println("업댓 완료");
					
					String listp =  mr.getParameter("listp");
					request.setAttribute("listp", listp);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}

	public static void reviewPaging(int page, HttpServletRequest request) {
		int cnt = 3;
		int total = rentReviews.size();
		int totalPage = (int) Math.ceil((double) total / cnt);

		System.out.println(total);
		int start = total - (cnt * (page - 1));
		int end = (page == totalPage) ? -1 : start - (cnt + 1);

		System.out.println(start + "review");
		System.out.println(end + "review");
		ArrayList<RentReview> reviews = new ArrayList<RentReview>();
		for (int i = start - 1; i > end; i--) {
			reviews.add(rentReviews.get(i));
		}
		request.setAttribute("totalReviewPage", totalPage);
		request.setAttribute("curPageReviewNo", page);
		request.setAttribute("rentReviews", reviews);

	}
	
//	------------------JP 메소드-------------------------------
	public static void allReviewJP(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from rent_review where rent_shop_no = ? order by rent_date";
		String no = request.getParameter("no");
		System.out.println(no);
		int no2 = 0;
		if (no == null || no.equals("null")) {
			no = (String) request.getAttribute("no");
			System.out.println("여긴 리뷰 어트리뷰트다"+no);
		}
		no2 = Integer.parseInt(no);
		System.out.println("---------------------------");
		System.out.println(no2);

		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no2);

			rs = pstmt.executeQuery();

			rentReviews = new ArrayList<RentReview>();
			RentReview rv = null;

			while (rs.next()) {
				int rentReviewNo = rs.getInt("rent_review_no");
				int rentShopNo = rs.getInt("rent_shop_no");
				String rentId = rs.getString("rent_id");
				int rentGrade = rs.getInt("rent_grade");
				Date rentDate = rs.getDate("rent_date");
				String rentCar = papago.translation(rs.getString("rent_car"));
				String rentReview = papago.translation(rs.getString("rent_review"));
				String rentImg = rs.getString("rent_img");
				rv = new RentReview(rentReviewNo, rentShopNo, rentId, rentGrade, rentDate, rentCar, rentReview,
						rentImg);
				System.out.println("일본어" + rentCar);
				rentReviews.add(rv);
				System.out.println("********"+rv );
			}
			System.out.println(rentReviews + "~~~~~~~~~~~~~>");
			request.setAttribute("rentReviews", rentReviews);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("allReview db server error");
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}
	
	
	
	
	

}
