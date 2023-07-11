package com.pgh.traffic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class RentShopDAO {
	private static ArrayList<RentShop> rentShops;

	public static void allRentShop(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from rentshop_data order by shop_grade_avg desc";

		try {
//			String search = request.getParameter("search");
//			request.setAttribute("search", search);
//			System.out.println(search);
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			rentShops = new ArrayList<RentShop>();
			RentShop r = null;

			int cnt = 0;
			String num = null;

			while (rs.next()) {
				cnt++;
				String placeNo = rs.getString("shop_no");
				String placeName = rs.getString("shop_placename");
				String addressJibun = rs.getString("shop_jibun");
				String addressDoro = rs.getString("shop_doro");
				double longitude = rs.getDouble("shop_longitude");
				double latitude = rs.getDouble("shop_latitude");
				double gradeAvg = rs.getDouble("shop_grade_avg");
				String placeUrl = rs.getString("shop_url");
				int gradeCnt = rs.getInt("shop_grade_cnt");
				r = new RentShop(placeNo, placeName, addressJibun, addressDoro, longitude, latitude, placeUrl, gradeAvg,
						gradeCnt);
				rentShops.add(r);
				if (cnt == 1) {
					num = placeNo;
				}
				//System.out.println("여기서 확인해주세요" + placeNo + placeName + cnt);
			}
			System.out.println("--------------------------------");
			System.out.println(rentShops.size());
			request.setAttribute("rentShops", rentShops);
			String reviewno = (String) request.getAttribute("no");
			if (reviewno == null || reviewno.equals("null")) {
				request.setAttribute("no", num);				
			}
		} catch (Exception e) {
			System.out.println("db server error");
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	public static void searchRentShop(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		rentShops = new ArrayList<RentShop>();
		String shopColumn = null;
		String searchText = request.getParameter("searchText");
		System.out.println(searchText);
		int cnt = 0;
		String num = null;
		try {
			con = DBManager.connect();

			if (request.getParameter("searchOption").equals("placeName")) {
				shopColumn = "shop_placename";
				//System.out.println(shopColumn);
			} else if (request.getParameter("searchOption").equals("addressDoro")) {
				shopColumn = "shop_doro";
				//System.out.println(shopColumn);
			} else {
				shopColumn = "shop_jibun";
				//System.out.println(shopColumn);
			}
			String sql = "select * from rentshop_data where " + shopColumn
					+ " like '%'||?||'%' order by shop_grade_avg desc";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, searchText);
			//System.out.println(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				cnt++;
				String placeNo = rs.getString("shop_no");
				String placeName = rs.getString("shop_placename");
				String addressJibun = rs.getString("shop_jibun");
				String addressDoro = rs.getString("shop_doro");
				double longitude = rs.getDouble("shop_longitude");
				double latitude = rs.getDouble("shop_latitude");
				String placeUrl = rs.getString("shop_url");
				double gradeAvg = rs.getDouble("shop_grade_avg");
				int gradeCnt = rs.getInt("shop_grade_cnt");
				RentShop rentShop = new RentShop(placeNo, placeName, addressJibun, addressDoro, longitude, latitude,
						placeUrl, gradeAvg, gradeCnt);
				rentShops.add(rentShop);
				if (cnt == 1) {
					num = placeNo;
				}
			}

			request.setAttribute("rentShops", rentShops);
			request.setAttribute("no", num);
			request.setAttribute("shopColumn", shopColumn);
			request.setAttribute("searchText", searchText);
		} catch (Exception e) {
			System.out.println("searchdb server error");
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	public static void detailRentShop(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from rentshop_data where shop_no = ?";

		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			String no = request.getParameter("no");
			System.out.println("이건 파리미터임 ㅇㅇ" + no);
			if (no == null || no.equals("null")) {
				no = (String) request.getAttribute("no");
				System.out.println("여기까진 괜찮음 ㅇㅇ");
			}
			System.out.println(no + "adsfadsf");
			pstmt.setString(1, no);
			rs = pstmt.executeQuery();
			System.out.println(no);

			rs.next();
			String placeNo = rs.getString("shop_no");
			String placeName = rs.getString("shop_placename");
			String addressJibun = rs.getString("shop_jibun");
			String addressDoro = rs.getString("shop_doro");
			double longitude = rs.getDouble("shop_longitude");
			double latitude = rs.getDouble("shop_latitude");
			String placeUrl = rs.getString("shop_url");
			double gradeAvg = rs.getDouble("shop_grade_avg");
			int gradeCnt = rs.getInt("shop_grade_cnt");
			RentShop r = new RentShop(placeNo, placeName, addressJibun, addressDoro, longitude, latitude, placeUrl,
					gradeAvg, gradeCnt);

			request.setAttribute("r", r);
			System.out.println(rentShops);
		} catch (Exception e) {
			System.out.println("detaildb server error");
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		/*
		 * double latitude = Double.parseDouble(request.getParameter("lat")); double
		 * longitude = Double.parseDouble(request.getParameter("lng")); String placeName
		 * = request.getParameter("placeName"); System.out.println("���� : " +
		 * latitude); System.out.println(longitude); request.setAttribute("latitude",
		 * latitude); request.setAttribute("longitude", longitude);
		 * request.setAttribute("placeName", placeName);
		 */
	}

	public static void paging(int page, HttpServletRequest request) {
		int cnt = 15;
		int total = rentShops.size();
		int totalPage = (int) Math.ceil((double) total / cnt);
		System.out.println("--------------------------------2");
		System.out.println(total);

		int start = (page - 1) * cnt + 1;

		System.out.println(start + "start");
		int end = (page == totalPage) ? total : start + cnt - 1;

		System.out.println(end + "end");

		ArrayList<RentShop> shops = new ArrayList<RentShop>();

		for (int i = start - 1; i < end; i++) {
			shops.add(rentShops.get(i));
			//System.out.println(rentShops.get(i));
		}

		request.setAttribute("totalPage", totalPage);
		request.setAttribute("curPageNo", page);
		request.setAttribute("rentShops", shops);

	}

	public static void allSearchRentShop(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		rentShops = new ArrayList<RentShop>();
		String searchText = request.getParameter("searchText");
		String shopColumn = request.getParameter("shopColumn");
		System.out.println(searchText);
		int cnt = 0;
		String num = null;
		try {
			con = DBManager.connect();

			String sql = "select * from rentshop_data where " + shopColumn
					+ " like '%'||?||'%' order by shop_grade_avg desc";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, searchText);
			System.out.println(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				cnt++;
				String placeNo = rs.getString("shop_no");
				String placeName = rs.getString("shop_placename");
				String addressJibun = rs.getString("shop_jibun");
				String addressDoro = rs.getString("shop_doro");
				double longitude = rs.getDouble("shop_longitude");
				double latitude = rs.getDouble("shop_latitude");
				String placeUrl = rs.getString("shop_url");
				double gradeAvg = rs.getDouble("shop_grade_avg");
				int gradeCnt = rs.getInt("shop_grade_cnt");
				RentShop rentShop = new RentShop(placeNo, placeName, addressJibun, addressDoro, longitude, latitude,
						placeUrl, gradeAvg, gradeCnt);
				rentShops.add(rentShop);
				if (cnt == 1) {
					num = placeNo;
				}
			}

			request.setAttribute("rentShops", rentShops);
			request.setAttribute("no", num);
			request.setAttribute("shopColumn", shopColumn);
			request.setAttribute("searchText", searchText);
		} catch (Exception e) {
			System.out.println("searchdb server error");
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}
	
//	------------------JP 메소드-------------------------------
	public static void setDB() {

		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;

		try {
			String sql = "select * from rentshop_data order by shop_no";
			String insertsql = "insert into jp_rentshop_data values(?,?,?,?,?,?,?,?,?)";
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int cnt = 0;
			while (rs.next()) {
				cnt++;
				String no = rs.getString("shop_no");
				
				String placeName = rs.getString("shop_placename"); // 필
				String addressJibun = rs.getString("shop_jibun"); // 필
				String addressDoro = rs.getString("shop_doro"); // 필
				String longitude = rs.getString("shop_longitude");
				String latitude = rs.getString("shop_latitude");
				String url = rs.getString("shop_url");
				Double gradeAvg = rs.getDouble("shop_grade_avg");
				String gradeCnt = rs.getString("shop_grade_cnt");

				String placeNameJP = papago.translation(placeName);
				String addressJibunJP = papago.translation(addressJibun);
				String addressDoroJP = papago.translation(addressDoro);

				pstmt2 = con.prepareStatement(insertsql);
				
				pstmt2.setString(1, no);
				pstmt2.setString(2, placeNameJP);
				pstmt2.setString(3, addressJibunJP);
				pstmt2.setString(4, addressDoroJP);
				pstmt2.setString(5, longitude);
				pstmt2.setString(6, latitude);
				pstmt2.setString(7, url);
				pstmt2.setDouble(8, gradeAvg);
				pstmt2.setString(9, gradeCnt);
				
				if (pstmt2.executeUpdate() == 1) {
					System.out.println(cnt + "jp 등록 성공");
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, rs);
			DBManager.close(null, pstmt2, null);
		}

	}

	public static void allRentShopJP(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from jp_rentshop_data order by shop_grade_avg desc";

		try {
//			String search = request.getParameter("search");
//			request.setAttribute("search", search);
//			System.out.println(search);
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			rentShops = new ArrayList<RentShop>();
			RentShop r = null;

			int cnt = 0;
			String num = null;

			while (rs.next()) {
				cnt++;
				String placeNo = rs.getString("shop_no");
				String placeName = rs.getString("shop_placename");
				String addressJibun = rs.getString("shop_jibun");
				String addressDoro = rs.getString("shop_doro");
				double longitude = rs.getDouble("shop_longitude");
				double latitude = rs.getDouble("shop_latitude");
				double gradeAvg = rs.getDouble("shop_grade_avg");
				String placeUrl = rs.getString("shop_url");
				int gradeCnt = rs.getInt("shop_grade_cnt");
				r = new RentShop(placeNo, placeName, addressJibun, addressDoro, longitude, latitude, placeUrl, gradeAvg,
						gradeCnt);
				rentShops.add(r);
				if (cnt == 1) {
					num = placeNo;
				}
			}
			request.setAttribute("rentShops", rentShops);
			String reviewno = (String) request.getAttribute("no");
			if (reviewno == null || reviewno.equals("null")) {
				request.setAttribute("no", num);
			}
		} catch (Exception e) {
			System.out.println("db server error");
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	public static void detailRentShopJP(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from jp_rentshop_data where shop_no = ?";

		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			String no = request.getParameter("no");
			System.out.println("이건 파리미터임 ㅇㅇ" + no);
			if (no == null || no.equals("null")) {
				no = (String) request.getAttribute("no");
				System.out.println("여기까진 괜찮음 ㅇㅇ");
			}
			System.out.println(no + "adsfadsf");
			pstmt.setString(1, no);
			rs = pstmt.executeQuery();
			System.out.println(no);

			rs.next();
			String placeNo = rs.getString("shop_no");
			String placeName = rs.getString("shop_placename");
			String addressJibun = rs.getString("shop_jibun");
			String addressDoro = rs.getString("shop_doro");
			double longitude = rs.getDouble("shop_longitude");
			double latitude = rs.getDouble("shop_latitude");
			String placeUrl = rs.getString("shop_url");
			double gradeAvg = rs.getDouble("shop_grade_avg");
			int gradeCnt = rs.getInt("shop_grade_cnt");
			RentShop r = new RentShop(placeNo, placeName, addressJibun, addressDoro, longitude, latitude, placeUrl,
					gradeAvg, gradeCnt);

			request.setAttribute("r", r);
			System.out.println(rentShops);
		} catch (Exception e) {
			System.out.println("detaildb server error");
		} finally {
			DBManager.close(con, pstmt, rs);
		}		
	}

	public static void searchRentShopJP(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		rentShops = new ArrayList<RentShop>();
		String shopColumn = null;
		String searchText = request.getParameter("searchText");
		System.out.println(searchText);
		int cnt = 0;
		String num = null;
		try {
			con = DBManager.connect();

			if (request.getParameter("searchOption").equals("placeName")) {
				shopColumn = "shop_placename";
				//System.out.println(shopColumn);
			} else if (request.getParameter("searchOption").equals("addressDoro")) {
				shopColumn = "shop_doro";
				//System.out.println(shopColumn);
			} else {
				shopColumn = "shop_jibun";
				//System.out.println(shopColumn);
			}
			String sql = "select * from jp_rentshop_data where " + shopColumn
					+ " like '%'||?||'%' order by shop_grade_avg desc";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, searchText);
			//System.out.println(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				cnt++;
				String placeNo = rs.getString("shop_no");
				String placeName = rs.getString("shop_placename");
				String addressJibun = rs.getString("shop_jibun");
				String addressDoro = rs.getString("shop_doro");
				double longitude = rs.getDouble("shop_longitude");
				double latitude = rs.getDouble("shop_latitude");
				String placeUrl = rs.getString("shop_url");
				double gradeAvg = rs.getDouble("shop_grade_avg");
				int gradeCnt = rs.getInt("shop_grade_cnt");
				RentShop rentShop = new RentShop(placeNo, placeName, addressJibun, addressDoro, longitude, latitude,
						placeUrl, gradeAvg, gradeCnt);
				rentShops.add(rentShop);
				if (cnt == 1) {
					num = placeNo;
				}
			}

			request.setAttribute("rentShops", rentShops);
			request.setAttribute("no", num);
			request.setAttribute("shopColumn", shopColumn);
			request.setAttribute("searchText", searchText);
		} catch (Exception e) {
			System.out.println("searchdb server error");
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		
	}

}
