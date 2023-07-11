package com.sj.gourmet;

import java.util.ArrayList;

public class GourmetInfo2 {
	private String id;
	private String name; // �긽�샇紐�
	private String tel; // �쟾�솕踰덊샇
	private String menu; // 硫붾돱
	private String addr; // 二쇱냼
	private String img;
	private ArrayList<Gourmet> reviews;
		
	public GourmetInfo2() {
		// TODO Auto-generated constructor stub
	}

	public GourmetInfo2(String id, String name, String tel, String menu, String addr, String img,
			ArrayList<Gourmet> reviews) {
		super();
		this.id = id;
		this.name = name;
		this.tel = tel;
		this.menu = menu;
		this.addr = addr;
		this.img = img;
		this.reviews = reviews;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public ArrayList<Gourmet> getReviews() {
		return reviews;
	}

	public void setReviews(ArrayList<Gourmet> reviews) {
		this.reviews = reviews;
	}

	
	}
	