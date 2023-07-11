package com.ih.tour;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jh.login.AccountDAO;


@WebServlet("/TourReviewC")
public class TourReviewC extends HttpServlet {
	private ReviewTDAO RDAO = null;
     public TourReviewC() {
    	RDAO = new ReviewTDAO();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccountDAO.logintourCheck(request);
		String r_contentsid = request.getParameter("r_contentsid");
		System.out.println(r_contentsid);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(getJSON(r_contentsid, request));
	}
		
	
	
		public String getJSON(String r_contentsid, HttpServletRequest request) {
			
			System.out.println(r_contentsid);
			if(r_contentsid == null) r_contentsid = "";
			StringBuffer result = new StringBuffer("");
			result.append("{\"result\":[");
			
			ArrayList<Reviews> revieList = RDAO.search(r_contentsid, request);
			System.out.println(revieList);
			for(int i = 0; i < revieList.size(); i++) {
				result.append("{\"no\":\"" + revieList.get(i).getR_no() + "\","); //"글번호 " -> 이 안에꺼 지우기 "" 은 남겨두기
				result.append("\"name\":\"" + revieList.get(i).getR_name() + "\",");
				result.append("\"title\":\"" + revieList.get(i).getR_title() + "\",");
				//result.append("\"content\":\"" + revieList.get(i).getR_content() + "\",");
				result.append("\"review\":\"" + revieList.get(i).getR_review() + "\",");
				result.append("\"starpoint\":\"" + revieList.get(i).getR_starpoint() + "\"}");
//				result.append("\"img\":\"" + revieList.get(i).getR_img() + "\"}");
				if (revieList.size() != 1 && i != revieList.size() - 1) {
					result.append(",");
				}

			}
			result.append("]}");
			
			System.out.println(result);
			return result.toString();
			
		
		
	}

}
