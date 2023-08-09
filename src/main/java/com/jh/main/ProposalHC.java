package com.jh.main;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jh.login.AccountDAO;

@WebServlet("/ProposalHC")
public class ProposalHC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		proposal.seeAllList(request);
//		이건 테스트용이다

		ArrayList<Suggest> proposals = new ArrayList<Suggest>();
		
		proposals.add(new Suggest("1", "렌터카", "양재순", "230703", "찜카가 없어요", "5", "찜카가 보고싶어요 찜카를 살려내주세요 제발"));
		proposals.add(new Suggest("2", "홈", "정재환", "230702", "지각 ㄴㄴ", "15", "근데 우리조 아닐때는 지각 안하면 좀 서운할지도"));
		proposals.add(new Suggest("3", "홈", "정재환", "230702", "지각 ㄴㄴ", "15", "근데 우리조 아닐때는 지각 안하면 좀 서운할지도"));
		proposals.add(new Suggest("2", "홈", "정재환", "230702", "지각 ㄴㄴ", "15", "근데 우리조 아닐때는 지각 안하면 좀 서운할지도"));
		proposals.add(new Suggest("2", "홈", "정재환", "230702", "지각 ㄴㄴ", "15", "근데 우리조 아닐때는 지각 안하면 좀 서운할지도"));
		
		request.setAttribute("proposal", proposals);
		
		AccountDAO.loginCheck(request);
		request.setAttribute("contentPage", "proposallist.jsp");
		request.setAttribute("listPage", "getallproposal.jsp");
		request.getRequestDispatcher("freeboard.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
