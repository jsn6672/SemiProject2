package com.semi.jh.login;

import javax.servlet.http.HttpServletRequest;

public class AccountDAO {

	public static void loginCheck(HttpServletRequest request) {
		Account account = (Account) request.getSession().getAttribute("account");
		
		
	}

	
}
