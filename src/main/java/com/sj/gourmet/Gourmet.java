package com.sj.gourmet;

public class Gourmet {
	private String gm_no;
	private String gm_g_no;
	private String gm_l_no;
	private String gm_pw;
	private String gm_grade;
	private String gm_date;
	private String gm_menu;
	private String gm_review;
	private String gm_pic;

	public Gourmet() {
		// TODO Auto-generated constructor stub
	}

	public String getGm_no() {
		return gm_no;
	}

	public void setGm_no(String gm_no) {
		this.gm_no = gm_no;
	}

	public String getGm_g_no() {
		return gm_g_no;
	}

	public void setGm_g_no(String gm_g_no) {
		this.gm_g_no = gm_g_no;
	}

	public String getGm_l_no() {
		return gm_l_no;
	}

	public void setGm_l_no(String gm_l_no) {
		this.gm_l_no = gm_l_no;
	}

	public String getGm_pw() {
		return gm_pw;
	}

	public void setGm_pw(String gm_pw) {
		this.gm_pw = gm_pw;
	}

	public String getGm_grade() {
		return gm_grade;
	}

	public void setGm_grade(String gm_grade) {
		this.gm_grade = gm_grade;
	}

	public String getGm_date() {
		return gm_date;
	}

	public void setGm_date(String gm_date) {
		this.gm_date = gm_date;
	}

	public String getGm_menu() {
		return gm_menu;
	}

	public void setGm_menu(String gm_menu) {
		this.gm_menu = gm_menu;
	}

	public String getGm_review() {
		return gm_review;
	}

	public void setGm_review(String gm_review) {
		this.gm_review = gm_review;
	}

	public String getGm_pic() {
		return gm_pic;
	}

	public void setGm_pic(String gm_pic) {
		this.gm_pic = gm_pic;
	}

	public Gourmet(String gm_no, String gm_g_no, String gm_l_no, String gm_pw, String gm_grade, String gm_date,
			String gm_menu, String gm_review, String gm_pic) {
		super();
		this.gm_no = gm_no;
		this.gm_g_no = gm_g_no;
		this.gm_l_no = gm_l_no;
		this.gm_pw = gm_pw;
		this.gm_grade = gm_grade;
		this.gm_date = gm_date;
		this.gm_menu = gm_menu;
		this.gm_review = gm_review;
		this.gm_pic = gm_pic;
	}

	@Override
	public String toString() {
		return "Gourmet [gm_no=" + gm_no + ", gm_g_no=" + gm_g_no + ", gm_l_no=" + gm_l_no + ", gm_pw=" + gm_pw
				+ ", gm_grade=" + gm_grade + ", gm_date=" + gm_date + ", gm_menu=" + gm_menu + ", gm_review="
				+ gm_review + ", gm_pic=" + gm_pic + "]";
	}
	
	
}
