package com.ih.tour;

public class Reviews {
    private int r_no;
    private String r_name;
    private String r_title;
    private String r_review;
    private double r_starpoint;
	private String user_id;
	private String d_contentsId;
	
	public Reviews() {
		// TODO Auto-generated constructor stub
	}

	public Reviews(int r_no, String r_name, String r_title, String r_review, double r_starpoint, String user_id,
			String d_contentsId) {
		super();
		this.r_no = r_no;
		this.r_name = r_name;
		this.r_title = r_title;
		this.r_review = r_review;
		this.r_starpoint = r_starpoint;
		this.user_id = user_id;
		this.d_contentsId = d_contentsId;
	}

	public int getR_no() {
		return r_no;
	}

	public void setR_no(int r_no) {
		this.r_no = r_no;
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

	public String getR_review() {
		return r_review;
	}

	public void setR_review(String r_review) {
		this.r_review = r_review;
	}

	public double getR_starpoint() {
		return r_starpoint;
	}

	public void setR_starpoint(double r_starpoint) {
		this.r_starpoint = r_starpoint;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getD_contentsId() {
		return d_contentsId;
	}

	public void setD_contentsId(String d_contentsId) {
		this.d_contentsId = d_contentsId;
	}
    
	
}
