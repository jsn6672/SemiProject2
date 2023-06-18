package com.jh.login;

import javax.servlet.http.HttpServletRequest;

import com.jh.account.Account;

public class AccountDAO {

	public static void loginCheck(HttpServletRequest request) {
		Account account = (Account) request.getSession().getAttribute("account");

		if (account == null) {
			request.setAttribute("loginPage", "login.jsp");
		} else {
			request.setAttribute("loginPage", "loginOK.jsp");
		}
	}

	public static void signup(HttpServletRequest request) {

	}

}
