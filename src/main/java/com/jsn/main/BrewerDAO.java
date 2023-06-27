package com.jsn.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BrewerDAO {
	private static ArrayList<JsnReview> r;
	private static ArrayList<Drink> d;

	public static void brewer(HttpServletRequest request) {

		Connection con = null;
		Connection con2 = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		String sql = "select * from jsn_traditional_drink order by t_avgscore desc";
		String brwsql = "select * from jsn_brewer where b_no = ?";
		try {
			con = DBManeger.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			d = new ArrayList<Drink>();
			while (rs.next()) {
				String no = rs.getString("t_no");
				String name = rs.getString("t_name");
				String level = rs.getString("t_level");
				String volume = rs.getString("t_volume");
				String material = rs.getString("t_material");
				String marketnum = rs.getString("t_market");
				Double avgscore = rs.getDouble("t_avgscore");
				String img = rs.getString("t_img");

				con2 = DBManeger.connect();
				pstmt2 = con2.prepareStatement(brwsql);
				pstmt2.setString(1, marketnum);
				rs2 = pstmt2.executeQuery();

				rs2.next();
				String market = rs2.getString("b_name");
				d.add(new Drink(no, name, level, volume, material, market, avgscore, img));
			}

			request.setAttribute("drink", d);

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBManeger.close(con, pstmt, rs);
			DBManeger.close(con2, pstmt2, rs2);
		}

	}

	public static void seedrink(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String num = request.getParameter("no");
		if (num == null) {
			num = (String) request.getAttribute("no");
		}
		String drinksql = "select * from jsn_traditional_drink where t_no = ?";
		String brewsql = "select * from jsn_brewer where b_no = (select t_market"
				+ "   from jsn_traditional_drink where t_no = ?)";
		try {
			con = DBManeger.connect();
			pstmt = con.prepareStatement(drinksql);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();

			rs.next();
			String no = rs.getString("t_no");
			String name = rs.getString("t_name");
			String level = rs.getString("t_level");
			String volume = rs.getString("t_volume");
			String material = rs.getString("t_material");
			String market = rs.getString("t_market");
			Double avgscore = rs.getDouble("t_avgscore");
			String img = rs.getString("t_img");

			Drink d = new Drink(no, name, level, volume, material, market, avgscore, img);

			request.setAttribute("drink_detail", d);
			pstmt.close();
			rs.close();
			pstmt = con.prepareStatement(brewsql);
			pstmt.setString(1, market);
			rs = pstmt.executeQuery();

			rs.next();
			no = rs.getString("b_no");
			name = rs.getString("b_name");
			String addr = rs.getString("b_addr");

			Brewer b = new Brewer(no, name, addr);

			request.setAttribute("brewer", b);
			request.setAttribute("kraddr", addr);

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBManeger.close(con, pstmt, rs);
		}

	}

	public static void CreateReview(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String path = request.getServletContext().getRealPath("jsn/imgfile");

		String sql = "insert into jsn_drink_review values (jsn_review_seq.nextval, ?, ?, ?, sysdate, ?, ?)";
		try {

			MultipartRequest mr = new MultipartRequest(request, path, 30 * 1024 * 1024, "utf-8",
					new DefaultFileRenamePolicy());
			System.out.println(path);
			String no = mr.getParameter("no");
			String user = "1";
			String review = mr.getParameter("review");
			String starpoint = mr.getParameter("starpoint");
			String img = mr.getFilesystemName("review_img");

			System.out.println(img);
			if (img == null) {
				img = "no_pic.jpg";
			}
			System.out.println(img);
			System.out.println("---------");
			con = DBManeger.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, no);
			pstmt.setString(2, user);
			pstmt.setString(3, starpoint);
			pstmt.setString(4, review);
			pstmt.setString(5, img);

			if (pstmt.executeUpdate() == 1) {
				System.out.println("등록 완료");

				String avgsql = "select * from jsn_traditional_drink where t_no = ?";

				pstmt = con.prepareStatement(avgsql);
				pstmt.setString(1, no);
				rs = pstmt.executeQuery();

				rs.next();
				double avg = rs.getDouble("t_avgscore");
				int cnt = rs.getInt("t_cntreview");
				cnt++;

				int point = Integer.parseInt(starpoint);
				avg = ((avg * (cnt - 1)) + point) / cnt;

				String updateavgsql = "update jsn_traditional_drink set t_avgscore = ?, t_cntreview = ? where t_no = ?";

				pstmt = con.prepareStatement(updateavgsql);
				pstmt.setDouble(1, avg);
				pstmt.setInt(2, cnt);
				pstmt.setString(3, no);

				if (pstmt.executeUpdate() == 1) {
					System.out.println("평균값 수정완료");
					request.setAttribute("no", no);
					request.setAttribute("listp", mr.getParameter("listp"));
				}

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("error");
		} finally {
			DBManeger.close(con, pstmt, rs);
		}

	}

	public static void ReadReview(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from jsn_drink_review where r_drink = ? order by r_date";

		try {
			String num = request.getParameter("no");
			if (num == null) {
				num = (String) request.getAttribute("no");
			}
			con = DBManeger.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();

			r = new ArrayList<JsnReview>();
			while (rs.next()) {
				String no = rs.getString("r_no");
				String drink = rs.getString("r_drink");
				String user = rs.getString("r_user");
				String starpoint = rs.getString("r_starpoint");
				String review = JsnPapago.translationkr(rs.getString("r_review"));
				String img = rs.getString("r_img");

				r.add(new JsnReview(no, drink, user, starpoint, review, img));
			}

			request.setAttribute("review", r);

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBManeger.close(con, pstmt, rs);
		}

	}

	public static void brewerJp(HttpServletRequest request) {
		Connection con = null;
		Connection con2 = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		String sql = "select * from jsn_traditional_drink order by t_avgscore desc";
		String brwsql = "select * from jsn_brewer where b_no = ?";
		try {
			con = DBManeger.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			d = new ArrayList<Drink>();
			while (rs.next()) {
				String no = rs.getString("t_no");
				String name = JsnPapago.translation(rs.getString("t_name"));
				String level = rs.getString("t_level");
				String volume = rs.getString("t_volume");
				String material = JsnPapago.translation(rs.getString("t_material"));
				String marketnum = rs.getString("t_market");
				Double avgscore = rs.getDouble("t_avgscore");
				String img = rs.getString("t_img");

				con2 = DBManeger.connect();
				pstmt2 = con2.prepareStatement(brwsql);
				pstmt2.setString(1, marketnum);
				rs2 = pstmt2.executeQuery();

				rs2.next();
				String market = JsnPapago.translation(rs2.getString("b_name"));
				d.add(new Drink(no, name, level, volume, material, market, avgscore, img));
			}

			request.setAttribute("drink", d);

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBManeger.close(con, pstmt, rs);
			DBManeger.close(con2, pstmt2, rs2);
		}

	}

	public static void seedrinkJp(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String num = request.getParameter("no");
		if (num == null) {
			num = (String) request.getAttribute("no");
		}
		String drinksql = "select * from jsn_traditional_drink where t_no = ?";
		String brewsql = "select * from jsn_brewer where b_no = (select t_market"
				+ "   from jsn_traditional_drink where t_no = ?)";
		try {
			con = DBManeger.connect();
			pstmt = con.prepareStatement(drinksql);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();

			rs.next();
			String no = rs.getString("t_no");
			String name = JsnPapago.translation(rs.getString("t_name"));
			String level = rs.getString("t_level");
			String volume = rs.getString("t_volume");
			String material = JsnPapago.translation(rs.getString("t_material"));
			String market = rs.getString("t_market");
			Double avgscore = rs.getDouble("t_avgscore");
			String img = rs.getString("t_img");

			Drink d = new Drink(no, name, level, volume, material, market, avgscore, img);

			request.setAttribute("drink_detail", d);
			pstmt = con.prepareStatement(brewsql);
			pstmt.setString(1, market);
			rs = pstmt.executeQuery();

			rs.next();
			no = rs.getString("b_no");
			name = JsnPapago.translation(rs.getString("b_name"));
			String addr = JsnPapago.translation(rs.getString("b_addr"));

			Brewer b = new Brewer(no, name, addr);

			request.setAttribute("brewer", b);
			request.setAttribute("kraddr", rs.getString("b_addr"));

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBManeger.close(con, pstmt, rs);
		}

	}

	public static void ReadReviewJp(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from jsn_drink_review where r_drink = ? order by r_date";
		try {
//			String path = request.getServletContext().getRealPath("jsn/imgfile");
//			MultipartRequest mr = new MultipartRequest(request, path, 30 * 1024 * 1024, "utf-8",
//					new DefaultFileRenamePolicy());			
//			String num = mr.getParameter("no");
			String num = request.getParameter("no");
			if (num == null) {
				num = (String) request.getAttribute("no");
			}
			con = DBManeger.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();

			r = new ArrayList<JsnReview>();
			while (rs.next()) {
				String no = rs.getString("r_no");
				String drink = rs.getString("r_drink");
				String user = rs.getString("r_user");
				String starpoint = rs.getString("r_starpoint");
				String review = JsnPapago.translation(rs.getString("r_review"));
				String img = rs.getString("r_img");

				r.add(new JsnReview(no, drink, user, starpoint, review, img));
			}

			request.setAttribute("review", r);

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBManeger.close(con, pstmt, rs);
		}

	}

	public static void reviewPaging(int page, HttpServletRequest req) {

		int cnt = 3; // 한페이지당 보여줄 개수
		int total = r.size(); // 총 데이터 개수
		int pageCount = (int) Math.ceil((double) total / cnt); // 총 페이지수

		System.out.println(cnt);
		System.out.println(total);
		System.out.println(pageCount);

		int start = total - (cnt * (page - 1));

		System.out.println(start);

		int end = (page == pageCount) ? -1 : start - (cnt + 1);

		System.out.println(end);

		ArrayList<JsnReview> items = new ArrayList<JsnReview>();

		for (int i = start - 1; i > end; i--) {
			items.add(r.get(i));
		}

		req.setAttribute("curReviewPageNo", page);
		req.setAttribute("reviewPageCount", pageCount);

		req.setAttribute("review", items);
	}

	public static void listPaging(int page, HttpServletRequest req) {

		int cnt = 2; // 한페이지당 보여줄 개수
		int total = d.size(); // 총 데이터 개수
		int pageCount = (int) Math.ceil((double) total / cnt); // 총 페이지수

		System.out.println(cnt);
		System.out.println(total);
		System.out.println(pageCount);

		int start = (page - 1) * cnt + 1;

		System.out.println(start);
		int end = (page == pageCount) ? total : start + cnt - 1;

		System.out.println(end);

		ArrayList<Drink> items = new ArrayList<Drink>();

		for (int i = start - 1; i < end; i++) {
			items.add(d.get(i));
		}

		req.setAttribute("curListPageNo", page);
		req.setAttribute("listPageCount", pageCount);

		req.setAttribute("drink", items);
	}

	public static void brewerHC(HttpServletRequest request) {

		Connection con = null;
		Connection con2 = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		String sql = "select * from jsn_traditional_drink order by t_avgscore desc";
		String brwsql = "select * from jsn_brewer where b_no = ?";
		try {
			con = DBManeger.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			String no1 = "";
			int cnt = 0;
			d = new ArrayList<Drink>();
			while (rs.next()) {
				cnt++;
				String no = rs.getString("t_no");
				String name = rs.getString("t_name");
				String level = rs.getString("t_level");
				String volume = rs.getString("t_volume");
				String material = rs.getString("t_material");
				String marketnum = rs.getString("t_market");
				Double avgscore = rs.getDouble("t_avgscore");
				String img = rs.getString("t_img");

				if (cnt == 1) {
					no1 = no;
				}
				con2 = DBManeger.connect();
				pstmt2 = con2.prepareStatement(brwsql);
				pstmt2.setString(1, marketnum);
				rs2 = pstmt2.executeQuery();

				rs2.next();
				String market = rs2.getString("b_name");

				d.add(new Drink(no, name, level, volume, material, market, avgscore, img));
			}
			request.setAttribute("drink", d);
			request.setAttribute("no", no1);

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBManeger.close(con, pstmt, rs);
			DBManeger.close(con2, pstmt2, rs2);
		}

	}

	public static void brewerSearch(HttpServletRequest request) {
		Connection con = null;
		Connection con2 = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		String drinksql = "select * from jsn_traditional_drink where t_name like '%'||?||'%' order by t_avgscore desc";
		String brewersql = "select * from jsn_traditional_drink where t_market = (select b_no from jsn_brewer where b_name like '%'||?||'%') order by t_avgscore DESC";
		String brwsql = "select * from jsn_brewer where b_no = ?";
		try {
			con = DBManeger.connect();
			String type = request.getParameter("type");
			String search = request.getParameter("name");
			System.out.println(type);
			if (type.equals("drinkname")) {
				pstmt = con.prepareStatement(drinksql);
				System.out.println(2);
			} else {
				pstmt = con.prepareStatement(brewersql);
				System.out.println(3);
			}
			pstmt.setString(1, search);

			System.out.println("--------");
			System.out.println(search);
			System.out.println("--------");
			rs = pstmt.executeQuery();

			String no1 = "";
			int cnt = 0;
			d = new ArrayList<Drink>();
			while (rs.next()) {
				cnt++;
				String no = rs.getString("t_no");
				String name = rs.getString("t_name");
				String level = rs.getString("t_level");
				String volume = rs.getString("t_volume");
				String material = rs.getString("t_material");
				String marketnum = rs.getString("t_market");
				Double avgscore = rs.getDouble("t_avgscore");
				String img = rs.getString("t_img");

				System.out.println(no + name + level);

				if (cnt == 1) {
					no1 = no;
				}
				con2 = DBManeger.connect();
				pstmt2 = con2.prepareStatement(brwsql);
				pstmt2.setString(1, marketnum);
				rs2 = pstmt2.executeQuery();

				rs2.next();
				String market = rs2.getString("b_name");

				d.add(new Drink(no, name, level, volume, material, market, avgscore, img));
			}
			request.setAttribute("drink", d);
			request.setAttribute("no", no1);
			if (cnt == 0) {
				request.setAttribute("notfound", "검색 결과가 없습니다");
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBManeger.close(con, pstmt, rs);
			DBManeger.close(con2, pstmt2, rs2);
		}

	}

	public static void brewerHCJp(HttpServletRequest request) {

		Connection con = null;
		Connection con2 = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		String sql = "select * from jsn_traditional_drink order by t_avgscore desc";
		String brwsql = "select * from jsn_brewer where b_no = ?";
		try {
			con = DBManeger.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			String no1 = "";
			int cnt = 0;
			d = new ArrayList<Drink>();
			while (rs.next()) {
				cnt++;
				String no = rs.getString("t_no");
				String name = JsnPapago.translation(rs.getString("t_name"));
				String level = rs.getString("t_level");
				String volume = rs.getString("t_volume");
				String material = JsnPapago.translation(rs.getString("t_material"));
				String marketnum = rs.getString("t_market");
				Double avgscore = rs.getDouble("t_avgscore");
				String img = rs.getString("t_img");

				if (cnt == 1) {
					no1 = no;
				}
				con2 = DBManeger.connect();
				pstmt2 = con2.prepareStatement(brwsql);
				pstmt2.setString(1, marketnum);
				rs2 = pstmt2.executeQuery();

				rs2.next();
				String market = JsnPapago.translation(rs2.getString("b_name"));

				d.add(new Drink(no, name, level, volume, material, market, avgscore, img));
			}
			request.setAttribute("drink", d);
			request.setAttribute("no", no1);

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBManeger.close(con, pstmt, rs);
			DBManeger.close(con2, pstmt2, rs2);
		}

	}

	public static void brewerSearchJp(HttpServletRequest request) {
		Connection con = null;
		Connection con2 = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		String drinksql = "select * from jsn_traditional_drink where t_name like '%'||?||'%' order by t_avgscore desc";
		String brewersql = "select * from jsn_traditional_drink where t_market = (select b_no from jsn_brewer where b_name like '%?%') order by t_avgscore";
		String brwsql = "select * from jsn_brewer where b_no = ?";
		try {
			pstmt = null;
			con = DBManeger.connect();
			String type = request.getParameter("type");
			String search = JsnPapago.translationkr(request.getParameter("name"));
			System.out.println(type);
			if (type.equals("drinkname")) {
				pstmt = con.prepareStatement(drinksql);
				pstmt.setString(1, search);
			} else {
				pstmt = con.prepareStatement(brewersql);
				pstmt.setString(1, search);
			}

			System.out.println("--------");
			System.out.println(search);
			System.out.println("--------");
			rs = pstmt.executeQuery();

			String no1 = "";
			int cnt = 0;
			d = new ArrayList<Drink>();
			while (rs.next()) {
				cnt++;
				String no = rs.getString("t_no");
				String name = JsnPapago.translation(rs.getString("t_name"));
				String level = rs.getString("t_level");
				String volume = rs.getString("t_volume");
				String material = JsnPapago.translation(rs.getString("t_material"));
				String marketnum = rs.getString("t_market");
				Double avgscore = rs.getDouble("t_avgscore");
				String img = rs.getString("t_img");

				if (cnt == 1) {
					no1 = no;
				}
				con2 = DBManeger.connect();
				pstmt2 = con2.prepareStatement(brwsql);
				pstmt2.setString(1, marketnum);
				rs2 = pstmt2.executeQuery();

				rs2.next();
				String market = JsnPapago.translation(rs2.getString("b_name"));

				d.add(new Drink(no, name, level, volume, material, market, avgscore, img));
			}
			request.setAttribute("drink", d);
			request.setAttribute("no", no1);

			if (cnt == 0) {
				request.setAttribute("notfound", "검색 결과가 없습니다");
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBManeger.close(con, pstmt, rs);
			DBManeger.close(con2, pstmt2, rs2);
		}

	}

	public static void SearchbrewerResult(HttpServletRequest request) {
		Connection con = null;
		Connection con2 = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		String drinksql = "select * from jsn_traditional_drink where t_name like '%'||?||'%' order by t_avgscore desc";
		String brewersql = "select * from jsn_traditional_drink where t_market = (select b_no from jsn_brewer where b_name like '%'||?||'%') order by t_avgscore DESC";
		String brwsql = "select * from jsn_brewer where b_no = ?";
		try {
			con = DBManeger.connect();

			String type = (String) request.getSession().getAttribute("drinktype");
			String search = (String) request.getSession().getAttribute("drinksearch");
			System.out.println(type);
			if (type.equals("drinkname")) {
				pstmt = con.prepareStatement(drinksql);
				System.out.println(2);
			} else {
				pstmt = con.prepareStatement(brewersql);
				System.out.println(3);
			}
			pstmt.setString(1, search);

			System.out.println("--------");
			System.out.println(search);
			System.out.println("--------");
			rs = pstmt.executeQuery();

			String no1 = "";
			int cnt = 0;
			d = new ArrayList<Drink>();
			while (rs.next()) {
				cnt++;
				String no = rs.getString("t_no");
				String name = rs.getString("t_name");
				String level = rs.getString("t_level");
				String volume = rs.getString("t_volume");
				String material = rs.getString("t_material");
				String marketnum = rs.getString("t_market");
				Double avgscore = rs.getDouble("t_avgscore");
				String img = rs.getString("t_img");

				System.out.println(no + name + level);

				if (cnt == 1) {
					no1 = no;
				}
				con2 = DBManeger.connect();
				pstmt2 = con2.prepareStatement(brwsql);
				pstmt2.setString(1, marketnum);
				rs2 = pstmt2.executeQuery();

				rs2.next();
				String market = rs2.getString("b_name");

				d.add(new Drink(no, name, level, volume, material, market, avgscore, img));
			}
			request.setAttribute("drink", d);
			request.setAttribute("no", no1);
			if (cnt == 0) {
				request.setAttribute("notfound", "검색 결과가 없습니다");
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBManeger.close(con, pstmt, rs);
			DBManeger.close(con2, pstmt2, rs2);
		}
	}

	public static void SearchbrewerResultJp(HttpServletRequest request) {
		Connection con = null;
		Connection con2 = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		String drinksql = "select * from jsn_traditional_drink where t_name like '%'||?||'%' order by t_avgscore desc";
		String brewersql = "select * from jsn_traditional_drink where t_market = (select b_no from jsn_brewer where b_name like '%'||?||'%') order by t_avgscore DESC";
		String brwsql = "select * from jsn_brewer where b_no = ?";
		try {
			con = DBManeger.connect();

			String type = (String) request.getSession().getAttribute("drinktype");
			String search = JsnPapago.translationkr((String) request.getSession().getAttribute("drinksearch"));
			System.out.println(type);
			if (type.equals("drinkname")) {
				pstmt = con.prepareStatement(drinksql);
				System.out.println(2);
			} else {
				pstmt = con.prepareStatement(brewersql);
				System.out.println(3);
			}
			pstmt.setString(1, search);

			System.out.println("--------");
			System.out.println(search);
			System.out.println("--------");
			rs = pstmt.executeQuery();

			String no1 = "";
			int cnt = 0;
			d = new ArrayList<Drink>();
			while (rs.next()) {
				cnt++;
				String no = rs.getString("t_no");
				String name = JsnPapago.translation(rs.getString("t_name"));
				String level = rs.getString("t_level");
				String volume = rs.getString("t_volume");
				String material = JsnPapago.translation(rs.getString("t_material"));
				String marketnum = rs.getString("t_market");
				Double avgscore = rs.getDouble("t_avgscore");
				String img = rs.getString("t_img");

				System.out.println(no + name + level);

				if (cnt == 1) {
					no1 = no;
				}
				con2 = DBManeger.connect();
				pstmt2 = con2.prepareStatement(brwsql);
				pstmt2.setString(1, marketnum);
				rs2 = pstmt2.executeQuery();

				rs2.next();
				String market = JsnPapago.translation(rs2.getString("b_name"));

				d.add(new Drink(no, name, level, volume, material, market, avgscore, img));
			}
			request.setAttribute("drink", d);
			request.setAttribute("no", no1);
			if (cnt == 0) {
				request.setAttribute("notfound", "검색 결과가 없습니다");
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBManeger.close(con, pstmt, rs);
			DBManeger.close(con2, pstmt2, rs2);
		}

	}

}
