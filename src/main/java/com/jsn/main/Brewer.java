package com.jsn.main;

public class Brewer {
	private String b_no;
	private String b_name;
	private String b_addr;
	
	public Brewer() {
		// TODO Auto-generated constructor stub
	}

	public Brewer(String b_no, String b_name, String b_addr) {
		super();
		this.b_no = b_no;
		this.b_name = b_name;
		this.b_addr = b_addr;
	}

	public String getB_no() {
		return b_no;
	}

	public void setB_no(String b_no) {
		this.b_no = b_no;
	}

	public String getB_name() {
		return b_name;
	}

	public void setB_name(String b_name) {
		this.b_name = b_name;
	}

	public String getB_addr() {
		return b_addr;
	}

	public void setB_addr(String b_addr) {
		this.b_addr = b_addr;
	}
	
	
}
