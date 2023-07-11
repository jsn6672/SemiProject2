package com.jsn.proposal;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jh.login.AccountDAO;

@WebServlet("/RegProposalC")
public class RegProposalC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		proposal.regProposal(request);
		proposal.seeAllList(request);
		proposal.PagingC(1, request);
		AccountDAO.logincontentCheck(request);
		request.setAttribute("contentPage", "proposallist.jsp");
		request.setAttribute("listPage", "getallproposal.jsp");
		request.getRequestDispatcher("jsn/freeboardjsp/freeboard.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
