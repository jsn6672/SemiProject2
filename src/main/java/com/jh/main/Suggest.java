package com.jh.main;

public class Suggest {
	private String t_no;
	private String t_type;
	private String t_user;
	private String t_date;
	private String t_title;
	private String t_grade;
	private String t_content;

	public Suggest() {
		// TODO Auto-generated constructor stub
	}

	public Suggest(String t_no, String t_type, String t_user, String t_date, String t_title, String t_grade,
			String t_content) {
		super();
		this.t_no = t_no;
		this.t_type = t_type;
		this.t_user = t_user;
		this.t_date = t_date;
		this.t_title = t_title;
		this.t_grade = t_grade;
		this.t_content = t_content;
	}

	public String getT_no() {
		return t_no;
	}

	public void setT_no(String t_no) {
		this.t_no = t_no;
	}

	public String getT_type() {
		return t_type;
	}

	public void setT_type(String t_type) {
		this.t_type = t_type;
	}

	public String getT_user() {
		return t_user;
	}

	public void setT_user(String t_user) {
		this.t_user = t_user;
	}

	public String getT_date() {
		return t_date;
	}

	public void setT_date(String t_date) {
		this.t_date = t_date;
	}

	public String getT_title() {
		return t_title;
	}

	public void setT_title(String t_title) {
		this.t_title = t_title;
	}

	public String getT_grade() {
		return t_grade;
	}

	public void setT_grade(String t_grade) {
		this.t_grade = t_grade;
	}

	public String getT_content() {
		return t_content;
	}

	public void setT_content(String t_content) {
		this.t_content = t_content;
	}

}