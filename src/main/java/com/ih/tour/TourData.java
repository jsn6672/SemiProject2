package com.ih.tour;

public class TourData {
	private String d_contentsid;
	private String d_title; 
	private String d_address;
	private String d_roadaddress;
	private String d_introduction;
	private String d_phoneno;
	private String d_alltag;
	private String d_imgpath;
	private int d_tourcount;
	private double d_gradeavg;
	
	public TourData() {
		// TODO Auto-generated constructor stub
	}

	public String getD_contentsid() {
		return d_contentsid;
	}

	public void setD_contentsid(String d_contentsid) {
		this.d_contentsid = d_contentsid;
	}

	public String getD_title() {
		return d_title;
	}

	public void setD_title(String d_title) {
		this.d_title = d_title;
	}

	public String getD_address() {
		return d_address;
	}

	public void setD_address(String d_address) {
		this.d_address = d_address;
	}

	public String getD_roadaddress() {
		return d_roadaddress;
	}

	public void setD_roadaddress(String d_roadaddress) {
		this.d_roadaddress = d_roadaddress;
	}

	public String getD_introduction() {
		return d_introduction;
	}

	public void setD_introduction(String d_introduction) {
		this.d_introduction = d_introduction;
	}

	public String getD_phoneno() {
		return d_phoneno;
	}

	public void setD_phoneno(String d_phoneno) {
		this.d_phoneno = d_phoneno;
	}

	public String getD_alltag() {
		return d_alltag;
	}

	public void setD_alltag(String d_alltag) {
		this.d_alltag = d_alltag;
	}

	public String getD_imgpath() {
		return d_imgpath;
	}

	public void setD_imgpath(String d_imgpath) {
		this.d_imgpath = d_imgpath;
	}

	public int getD_tourcount() {
		return d_tourcount;
	}

	public void setD_tourcount(int d_tourcount) {
		this.d_tourcount = d_tourcount;
	}

	public double getD_gradeavg() {
		return d_gradeavg;
	}

	public void setD_gradeavg(double d_gradeavg) {
		this.d_gradeavg = d_gradeavg;
	}

	public TourData(String d_contentsid, String d_title, String d_address, String d_roadaddress, String d_introduction,
			String d_phoneno, String d_alltag, String d_imgpath, int d_tourcount, double d_gradeavg) {
		super();
		this.d_contentsid = d_contentsid;
		this.d_title = d_title;
		this.d_address = d_address;
		this.d_roadaddress = d_roadaddress;
		this.d_introduction = d_introduction;
		this.d_phoneno = d_phoneno;
		this.d_alltag = d_alltag;
		this.d_imgpath = d_imgpath;
		this.d_tourcount = d_tourcount;
		this.d_gradeavg = d_gradeavg;
	}

	@Override
	public String toString() {
		return "TourData [d_contentsid=" + d_contentsid + ", d_title=" + d_title + ", d_address=" + d_address
				+ ", d_roadaddress=" + d_roadaddress + ", d_introduction=" + d_introduction + ", d_phoneno=" + d_phoneno
				+ ", d_alltag=" + d_alltag + ", d_imgpath=" + d_imgpath + ", d_tourcount=" + d_tourcount
				+ ", d_gradeavg=" + d_gradeavg + "]";
	}
	
	
	
	
	
}

