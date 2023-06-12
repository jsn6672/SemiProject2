package com.jsn.main;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class BrewerDAO {

	public static void brewer(HttpServletRequest request) {
		
		
		
		ArrayList<Bean> b = new ArrayList<Bean>();
		
		b.add(new Bean(1, "제주곶감", "서귀포시", "탁주"));
		b.add(new Bean(2, "제주감자", "제주시", "청주"));
		
		
		
		request.setAttribute("drink", b);
		
	}

}
