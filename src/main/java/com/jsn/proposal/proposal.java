package com.jsn.proposal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.jh.login.Account;
import com.jsn.main.DBManeger;
import com.jsn.main.JsnReview;

public class proposal {
	private static ArrayList<Suggest> proposals;

	public static void seeAllList(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;

		String sql = "select * from freeboard_table order by t_date";
		String usersql = "select * from account_tbl where id = ?";
		try {
			proposals = new ArrayList<Suggest>();
			con = DBManeger.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String no = rs.getString("t_no");
				String type = rs.getString("t_type");
				String user = rs.getString("t_user");
				String date = rs.getString("t_date");
				String grade = rs.getString("t_grade");
				String content = rs.getString("t_content");
				pstmt2 = con.prepareStatement(usersql);
				pstmt2.setString(1, user);
				rs2 = pstmt2.executeQuery();
				rs2.next();
				String username = rs2.getString("name");

				proposals.add(new Suggest(no, type, username, date, grade, content));
			}
			request.setAttribute("proposal", proposals);

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBManeger.close(con, pstmt, rs);
		}
	}

	public static void PagingC(int page, HttpServletRequest req) {
		int cnt = 5; // 한페이지당 보여줄 개수
		int total = proposals.size(); // 총 데이터 개수
		int pageCount = (int) Math.ceil((double) total / cnt); // 총 페이지수

		System.out.println(cnt);
		System.out.println(total);
		System.out.println(pageCount);

		int start = total - (cnt * (page - 1));

		System.out.println(start);

		int end = (page == pageCount) ? -1 : start - (cnt + 1);

		System.out.println(end);

		ArrayList<Suggest> items = new ArrayList<Suggest>();

		for (int i = start - 1; i > end; i--) {
			items.add(proposals.get(i));
		}

		req.setAttribute("curPageNo", page);
		req.setAttribute("PageCount", pageCount);

		req.setAttribute("proposal", items);
	}

	public static void regProposal(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		Account account = (Account) request.getSession().getAttribute("account");

		String sql = "insert into freeboard_table values (jsn_freeboard_seq.nextval, ?, ?, sysdate, 0, ?)";
		try {
			String type = request.getParameter("type");
			String user = account.getId();
			String content = request.getParameter("content");

			con = DBManeger.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, type);
			pstmt.setString(2, user);
			pstmt.setString(3, content);

			if (pstmt.executeUpdate() == 1) {
				System.out.println("등록 완료");
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBManeger.close(con, pstmt, null);
		}
	}

	public static void seeList(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		String inputtype = request.getParameter("type");
		String sql = "select * from freeboard_table where t_type = ? order by t_date";
		String usersql = "select * from account_tbl where id = ?";
		try {
			proposals = new ArrayList<Suggest>();
			con = DBManeger.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, inputtype);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String no = rs.getString("t_no");
				String type = rs.getString("t_type");
				String user = rs.getString("t_user");
				String date = rs.getString("t_date");
				String grade = rs.getString("t_grade");
				String content = rs.getString("t_content");
				pstmt2 = con.prepareStatement(usersql);
				pstmt2.setString(1, user);
				rs2 = pstmt2.executeQuery();
				rs2.next();
				String username = rs2.getString("name");

				proposals.add(new Suggest(no, type, username, date, grade, content));
			}
			request.setAttribute("proposal", proposals);

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBManeger.close(con, pstmt, rs);
		}
	}

	public static void gradeup(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;

		String sql = "update freeboard_table set t_grade = ? where t_no = ?";
		try {
			int grade = Integer.parseInt(request.getParameter("grade"));
			String no = request.getParameter("no");

			con = DBManeger.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, grade+1);
			pstmt.setString(2, no);

			if (pstmt.executeUpdate() == 1) {
				System.out.println("따봉 업");
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBManeger.close(con, pstmt, null);
		}

	}

}
