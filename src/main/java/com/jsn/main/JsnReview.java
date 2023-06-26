package com.jsn.main;

public class JsnReview {
	private String r_no;
	private String r_drink;
	private String r_user;
	private String r_starpoint;
	private String r_review;
	private String r_img;

	public JsnReview() {
		// TODO Auto-generated constructor stub
	}

	public JsnReview(String r_no, String r_drink, String r_user, String r_starpoint, String r_review, String r_img) {
		super();
		this.r_no = r_no;
		this.r_drink = r_drink;
		this.r_user = r_user;
		this.r_starpoint = r_starpoint;
		this.r_review = r_review;
		this.r_img = r_img;
	}

	public String getR_img() {
		return r_img;
	}

	public void setR_img(String r_img) {
		this.r_img = r_img;
	}

	public String getR_starpoint() {
		return r_starpoint;
	}

	public void setR_starpoint(String r_starpoint) {
		this.r_starpoint = r_starpoint;
	}

	public String getR_user() {
		return r_user;
	}

	public void setR_user(String r_user) {
		this.r_user = r_user;
	}

	public String getR_no() {
		return r_no;
	}

	public void setR_no(String r_no) {
		this.r_no = r_no;
	}

	public String getR_drink() {
		return r_drink;
	}

	public void setR_drink(String r_drink) {
		this.r_drink = r_drink;
	}

	public String getR_review() {
		return r_review;
	}

	public void setR_review(String r_review) {
		this.r_review = r_review;
	}

}
