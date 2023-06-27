package com.jsn.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class drinkSession {

	public static void KoreanPage(HttpServletRequest request) {
		HttpSession hs = request.getSession();
		hs.setAttribute("country", "korean");
		
	}
	
	public static void ChangeCountry(HttpServletRequest request) {
		
		String country = (String) request.getSession().getAttribute("country");
		
		if (country.equals("korean")) {
			country = "japanese";
		} else {
			country = "korean";
		}
		
		HttpSession hs = request.getSession();
		hs.setAttribute("country", country);
		
	}

	public static void SearchResult(HttpServletRequest request) {
		String type = request.getParameter("type");
		String search = request.getParameter("name");
		HttpSession hs = request.getSession();
		hs.setAttribute("drinktype", type);
		hs.setAttribute("drinksearch", search);
		
	}
}
