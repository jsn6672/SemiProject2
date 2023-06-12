package com.jsn.main;

public class Bean {
	private int num;
	private String name;
	private String addr;
	private String drinkType;
	
	public Bean() {
		// TODO Auto-generated constructor stub
	}

	public Bean(int num, String name, String addr, String drinkType) {
		super();
		this.num = num;
		this.name = name;
		this.addr = addr;
		this.drinkType = drinkType;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getDrinkType() {
		return drinkType;
	}

	public void setDrinkType(String drinkType) {
		this.drinkType = drinkType;
	}
	
	
	
}
