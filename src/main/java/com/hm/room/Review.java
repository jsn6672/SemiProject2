package com.hm.room;

import java.util.Date;

public class Review {
	private int r_no;		
	private String r_cid;
	private String r_name;
	private String r_title;
	private String r_reviewname;
	private double r_grade;
	private String r_text;
	private String r_img;
	private Date r_date;

	public Review() {

	}

	public Review(int r_no, String r_cid, String r_name, String r_title, String r_reviewname, double r_grade,
			String r_text, String r_img, Date r_date) {
		super();
		this.r_no = r_no;
		this.r_cid = r_cid;
		this.r_name = r_name;
		this.r_title = r_title;
		this.r_reviewname = r_reviewname;
		this.r_grade = r_grade;
		this.r_text = r_text;
		this.r_img = r_img;
		this.r_date = r_date;
	}

	public int getR_no() {
		return r_no;
	}

	public void setR_no(int r_no) {
		this.r_no = r_no;
	}

	public String getR_cid() {
		return r_cid;
	}

	public void setR_cid(String r_cid) {
		this.r_cid = r_cid;
	}

	public String getR_name() {
		return r_name;
	}

	public void setR_name(String r_name) {
		this.r_name = r_name;
	}

	public String getR_title() {
		return r_title;
	}

	public void setR_title(String r_title) {
		this.r_title = r_title;
	}

	public String getR_reviewname() {
		return r_reviewname;
	}

	public void setR_reviewname(String r_reviewname) {
		this.r_reviewname = r_reviewname;
	}

	public double getR_grade() {
		return r_grade;
	}

	public void setR_grade(double r_grade) {
		this.r_grade = r_grade;
	}

	public String getR_text() {
		return r_text;
	}

	public void setR_text(String r_text) {
		this.r_text = r_text;
	}

	public String getR_img() {
		return r_img;
	}

	public void setR_img(String r_img) {
		this.r_img = r_img;
	}

	public Date getR_date() {
		return r_date;
	}

	public void setR_date(Date r_date) {
		this.r_date = r_date;
	}

}