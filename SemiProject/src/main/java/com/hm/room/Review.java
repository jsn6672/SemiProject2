package com.hm.room;

public class Review {
	private int r_no;
	private String r_username;
	private String r_content;
	private String r_contentname;
	private double r_starpoint;
	private String r_review;
	private String r_img;

	public Review() {
		// TODO Auto-generated constructor stub
	}

	public Review(int r_no, String r_username, String r_content, String r_contentname, double r_starpoint,
			String r_review, String r_img) {
		super();
		this.r_no = r_no;
		this.r_username = r_username;
		this.r_content = r_content;
		this.r_contentname = r_contentname;
		this.r_starpoint = r_starpoint;
		this.r_review = r_review;
		this.r_img = r_img;
	}

	public int getR_no() {
		return r_no;
	}

	public void setR_no(int r_no) {
		this.r_no = r_no;
	}

	public String getR_username() {
		return r_username;
	}

	public void setR_username(String r_username) {
		this.r_username = r_username;
	}

	public String getR_content() {
		return r_content;
	}

	public void setR_content(String r_content) {
		this.r_content = r_content;
	}

	public String getR_contentname() {
		return r_contentname;
	}

	public void setR_contentname(String r_contentname) {
		this.r_contentname = r_contentname;
	}

	public double getR_starpoint() {
		return r_starpoint;
	}

	public void setR_starpoint(double r_starpoint) {
		this.r_starpoint = r_starpoint;
	}

	public String getR_review() {
		return r_review;
	}

	public void setR_review(String r_review) {
		this.r_review = r_review;
	}

	public String getR_img() {
		return r_img;
	}

	public void setR_img(String r_img) {
		this.r_img = r_img;
	}
	
}	
	


