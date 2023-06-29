package com.hm.room;

public class Review {
	private int r_no;
	private String r_cid;
	private String l_id;
	private String r_hotelname;
	private double r_grade;
	private String r_text;
	private String r_img;
	private String r_date;

	public Review() {

	}

	public Review(int r_no, String r_cid, String l_id, String r_hotelname, double r_grade, String r_text, String r_img,
			String r_date) {
		super();
		this.r_no = r_no;
		this.r_cid = r_cid;
		this.l_id = l_id;
		this.r_hotelname = r_hotelname;
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

	public String getL_id() {
		return l_id;
	}

	public void setL_id(String l_id) {
		this.l_id = l_id;
	}

	public String getR_hotelname() {
		return r_hotelname;
	}

	public void setR_hotelname(String r_hotelname) {
		this.r_hotelname = r_hotelname;
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

	public String getR_date() {
		return r_date;
	}

	public void setR_date(String r_date) {
		this.r_date = r_date;
	}

}