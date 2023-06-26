package com.jsn.main;

public class Drink {
	private String t_no;
	private String t_name;
	private String t_level;
	private String t_volume;
	private String t_material;
	private String t_market;
	private double t_avgscore;
	private String t_img;

	public Drink() {
		// TODO Auto-generated constructor stub
	}

	public Drink(String t_no, String t_name, String t_level, String t_volume, String t_material, String t_market,
			double t_avgscore, String t_img) {
		super();
		this.t_no = t_no;
		this.t_name = t_name;
		this.t_level = t_level;
		this.t_volume = t_volume;
		this.t_material = t_material;
		this.t_market = t_market;
		this.t_avgscore = t_avgscore;
		this.t_img = t_img;
	}

	public String getT_img() {
		return t_img;
	}

	public void setT_img(String t_img) {
		this.t_img = t_img;
	}

	public double getT_avgscore() {
		return t_avgscore;
	}

	public void setT_avgscore(double t_avgscore) {
		this.t_avgscore = t_avgscore;
	}

	public String getT_no() {
		return t_no;
	}

	public void setT_no(String t_no) {
		this.t_no = t_no;
	}

	public String getT_name() {
		return t_name;
	}

	public void setT_name(String t_name) {
		this.t_name = t_name;
	}

	public String getT_level() {
		return t_level;
	}

	public void setT_level(String t_level) {
		this.t_level = t_level;
	}

	public String getT_volume() {
		return t_volume;
	}

	public void setT_volume(String t_volume) {
		this.t_volume = t_volume;
	}

	public String getT_material() {
		return t_material;
	}

	public void setT_material(String t_material) {
		this.t_material = t_material;
	}

	public String getT_market() {
		return t_market;
	}

	public void setT_market(String t_market) {
		this.t_market = t_market;
	}

}
