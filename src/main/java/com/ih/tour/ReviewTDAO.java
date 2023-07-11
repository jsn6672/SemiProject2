package com.ih.tour;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;

import com.jh.login.Account;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;



//public class ReviewTDAO {
//	private static DBManager db = DBManager.DB;
//	private static Connection con = null;
//	public ReviewTDAO() {
//		try {
//			con = db.connect();
//		} catch (SQLException e) {
//			
//			e.printStackTrace();
//		}
//	}
//	
//	
//	
//	public static void regReview(HttpServletRequest request) {
//    	String path = request.getServletContext().getRealPath("fileFolder");
//        PreparedStatement pstmt = null;
//        
//        String sql = "insert into TourR_test values(TourR_test_seq.nextval, ?, ?, ?, ?, ?, ?)";
//        
//        try {
//        	pstmt = con.prepareStatement(sql);
//        	
//        	MultipartRequest mr = new MultipartRequest(
//    				request,
//    				path,
//    				30*1024*1024,
//    				"utf-8",
//    				new DefaultFileRenamePolicy());
//            request.setCharacterEncoding("utf-8");
//            
//            
//            
//            String name = mr.getParameter("reviewName");
//            String title = mr.getParameter("reviewTitle");
//            String content = mr.getParameter("reviewContent");
//            String point = mr.getParameter("reviewPoint");  // I assume this is a number
//            String review = mr.getParameter("review");
//            String img = mr.getFilesystemName("reviewImg");
//            
//            System.out.println(name);
//            System.out.println(title);
//            System.out.println(content);
//            System.out.println(point);
//            System.out.println(review);
//            System.out.println(img);
//            
//            pstmt.setString(1, name);
//            pstmt.setString(2, title);
//            pstmt.setString(3, content);
//            pstmt.setDouble(4, Double.parseDouble(point)); // Set this as a double, you may need to parse it as a double
//            pstmt.setString(5, review);
//            pstmt.setString(6, img);
//            
//            if(pstmt.executeUpdate() == 1) {
//                System.out.println("등록성공");
//                request.setAttribute("result", con);
//            }
//            
//        } catch (Exception e) {
//            request.setAttribute("result", "db server error...");
//            e.printStackTrace();
//        } finally {
//            db.close(con, pstmt, null);
//        }
//    }
//    
//    
//    
//    public ArrayList<Reviews> search(String r_name){
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//        String sql = "select * from TourR_test where r_name like '%'||?||'%'";
//        ArrayList<Reviews> reviewList = new ArrayList<Reviews>();
//        try {
//        	pstmt = con.prepareStatement(sql);
//        	pstmt.setString(1, r_name);
//        	rs = pstmt.executeQuery();
//        	while (rs.next()) {
//        	    Reviews review = new Reviews();
//        	    
//        	    review.setR_name(rs.getString("r_name"));
//        	    review.setR_title(rs.getString("r_title"));
//        	    review.setR_content(rs.getString("r_content"));
//        	    review.setR_review(rs.getString("r_review"));
//        	    review.setR_starpoint(rs.getBigDecimal("r_starpoint").doubleValue());
//        	    review.setR_img(rs.getString("r_img"));
//        	    
//        	    reviewList.add(review);
//        	}
//        	
//        	
//        	
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			//DBManager.close(con, pstmt, rs);
//		}
//        
//        
//        return reviewList;
//        
//    	
//    }
//}


public class ReviewTDAO {
	private static DBManager db = DBManager.DB;
	
	public ReviewTDAO() {
		// No need to create a connection in the constructor.
	}
	
	public static void regReview(HttpServletRequest request) {

    	Connection con = null;
        PreparedStatement pstmt = null;
   
        String sql = "INSERT INTO ih_review VALUES (ih_review_seq.nextval, ?, ?, ?, ?, ?, ?)";
        
        try {
        	con = db.connect();
        	pstmt = con.prepareStatement(sql);
        	

        	Account a = (Account) request.getSession().getAttribute("account");
        	String id = a.getId();
            String name = request.getParameter("r_name");
            String title = request.getParameter("r_title");
            String point = request.getParameter("r_starpoint");  
            String review = request.getParameter("r_review");
            String contentsid = request.getParameter("r_contentsId");
            
            
            System.out.println(id);
            System.out.println(name);
            System.out.println(title);
            System.out.println(review);
            System.out.println(point);
            System.out.println(contentsid);
         
            pstmt.setString(1, name);
            pstmt.setString(2, title);
            pstmt.setDouble(3, Double.parseDouble(point)); // Set this as a double, you may need to parse it as a double
            pstmt.setString(4, review);
            pstmt.setString(5, id);
            pstmt.setString(6, contentsid);
            
            if(pstmt.executeUpdate() == 1) {
                System.out.println("등록성공");
                request.setAttribute("result", con);
            }
            
        } catch (Exception e) {
            request.setAttribute("result", "db server error...");
            e.printStackTrace();
        } finally {
            db.close(con, pstmt, null);
        }
    }
	
	
	
	
    
    public ArrayList<Reviews> search(String r_contentsid, HttpServletRequest request){

    	 
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
       System.out.println(r_contentsid);
        String sql = "select * from ih_review where d_contentsid = ?";
        ArrayList<Reviews> reviewList = new ArrayList<Reviews>();
        try {
        	con = db.connect();
        	pstmt = con.prepareStatement(sql);
        	pstmt.setString(1, r_contentsid);
        	rs = pstmt.executeQuery();
        	Account a = (Account) request.getSession().getAttribute("account");
        	while (rs.next()) {
        	    Reviews review = new Reviews();
        	    
        	    review.setR_no(rs.getInt("r_no"));
        	    review.setR_name(rs.getString("r_name"));
        	    review.setR_title(rs.getString("r_title"));
        	    review.setR_review(rs.getString("r_review"));
        	    review.setR_starpoint(rs.getBigDecimal("r_starpoint").doubleValue());
        	    review.setUser_id(rs.getString("user_id"));
        	    review.setD_contentsId(rs.getString("d_contentsId"));
        	    reviewList.add(review);
        	}
        	
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.close(con, pstmt, rs);
		}
        
        return reviewList;
    }

    public static ArrayList<Reviews> getReview(HttpServletRequest request) {
    	String r_title = request.getParameter("r_title");
    	System.out.println(r_title);
		Connection con = null;
        PreparedStatement pstmt = null;
        //PreparedStatement pstmt2 = null;
        ResultSet rs = null;
        //ResultSet rs2 = null;
        String sql = "select * from ih_test where r_title like '%'||?||'%'";
        //string sql2 = "select 8 from sh_account where a_id = ?";
        ArrayList<Reviews> reviewList = new ArrayList<Reviews>();
        try {
        	con = db.connect();
        	pstmt = con.prepareStatement(sql);
        	pstmt.setString(1, r_title);
        	rs = pstmt.executeQuery();
        	
        	while (rs.next()) {
        	    Reviews review = new Reviews();
        	    //string userid = rs.getString("r_name");
        	    //pstmt2 = con.prepareStatement(sql2);
        	    //pstmt2.setString(1, userid);
        	    //rs2 = pstmt2.executeQuery();
        	    //rs2.next();
        	    //string name = rs2.getString("a_nickname");
        	    Account a = (Account) request.getSession().getAttribute("account");
        	    review.setR_no(rs.getInt("r_no"));
        	    review.setR_name(rs.getString("r_name"));
        	    //review.setR_name(name);
        	    review.setR_title(rs.getString("r_title"));
        	    review.setR_review(rs.getString("r_review"));
        	    review.setR_starpoint(rs.getBigDecimal("r_starpoint").doubleValue());
        	    review.setUser_id(a.getId());
        	    review.setD_contentsId(rs.getString("d_contentsId"));
        	    reviewList.add(review);
        	}
        	
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.close(con, pstmt, rs);
		}
        
        return reviewList;
	}

	public void delReview(HttpServletRequest request) {
		 Connection con = null;
	        PreparedStatement pstmt = null;
	        String sql = "delete from ih_review where r_no = ?";
	        try {
	        	con = db.connect();
	        	pstmt = con.prepareStatement(sql);
	        	pstmt.setString(1, request.getParameter("r_no"));
	        	if(pstmt.executeUpdate()==1) {
	        		System.out.println("삭제성공");
	        	}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				db.close(con, pstmt, null);
			}		
	}
	
	
	
	
	
	
	
}



