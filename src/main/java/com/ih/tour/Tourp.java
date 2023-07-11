package com.ih.tour;

public class Tourp {
	private String r_contentsid;
	private String r_title; 
	private String r_address;
	private String r_roadaddress;
	private String r_introduction;
	private String r_phoneno;
	private String r_alltag;
	private String r_imgpath;
	private int r_tourcount;
	private double r_gradeavg;
	
	public Tourp() {
		
	}

	public Tourp(String r_contentsid, String r_title, String r_address, String r_roadaddress, String r_introduction,
			String r_phoneno, String r_alltag, String r_imgpath, int r_tourcount, double r_gradeavg) {
		super();
		this.r_contentsid = r_contentsid;
		this.r_title = r_title;
		this.r_address = r_address;
		this.r_roadaddress = r_roadaddress;
		this.r_introduction = r_introduction;
		this.r_phoneno = r_phoneno;
		this.r_alltag = r_alltag;
		this.r_imgpath = r_imgpath;
		this.r_tourcount = r_tourcount;
		this.r_gradeavg = r_gradeavg;
	}

	public String getR_contentsid() {
		return r_contentsid;
	}

	public void setR_contentsid(String r_contentsid) {
		this.r_contentsid = r_contentsid;
	}

	public String getR_title() {
		return r_title;
	}

	public void setR_title(String r_title) {
		this.r_title = r_title;
	}

	public String getR_address() {
		return r_address;
	}

	public void setR_address(String r_address) {
		this.r_address = r_address;
	}

	public String getR_roadaddress() {
		return r_roadaddress;
	}

	public void setR_roadaddress(String r_roadaddress) {
		this.r_roadaddress = r_roadaddress;
	}

	public String getR_introduction() {
		return r_introduction;
	}

	public void setR_introduction(String r_introduction) {
		this.r_introduction = r_introduction;
	}

	public String getR_phoneno() {
		return r_phoneno;
	}

	public void setR_phoneno(String r_phoneno) {
		this.r_phoneno = r_phoneno;
	}

	public String getR_alltag() {
		return r_alltag;
	}

	public void setR_alltag(String r_alltag) {
		this.r_alltag = r_alltag;
	}

	public String getR_imgpath() {
		return r_imgpath;
	}

	public void setR_imgpath(String r_imgpath) {
		this.r_imgpath = r_imgpath;
	}

	public int getR_tourcount() {
		return r_tourcount;
	}

	public void setR_tourcount(int r_tourcount) {
		this.r_tourcount = r_tourcount;
	}

	public double getR_gradeavg() {
		return r_gradeavg;
	}

	public void setR_gradeavg(double r_gradeavg) {
		this.r_gradeavg = r_gradeavg;
	}

	@Override
	public String toString() {
		return "Tourp [r_contentsid=" + r_contentsid + ", r_title=" + r_title + ", r_address=" + r_address
				+ ", r_roadaddress=" + r_roadaddress + ", r_introduction=" + r_introduction + ", r_phoneno=" + r_phoneno
				+ ", r_alltag=" + r_alltag + ", r_imgpath=" + r_imgpath + ", r_tourcount=" + r_tourcount
				+ ", r_gradeavg=" + r_gradeavg + "]";
	}

	
	
	
	
}
