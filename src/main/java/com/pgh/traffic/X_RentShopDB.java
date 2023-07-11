package com.pgh.traffic;

//DB 넣는 용도로 만든 bean(사용X)

public class X_RentShopDB {
	private String no;
	private String placeName;
	private String addressJibun;
	private String addressDoro;
	private double longitude;
	private double latitude;
	private String placeUrl;
	private double grade_avg;
	private int grade_cnt;

	public X_RentShopDB() {
		// TODO Auto-generated constructor stub
	}
	
	
	public X_RentShopDB(String placeName, String addressJibun, String addressDoro, double longitude, double latitude,
			String placeUrl) {
		super();
		this.placeName = placeName;
		this.addressJibun = addressJibun;
		this.addressDoro = addressDoro;
		this.longitude = longitude;
		this.latitude = latitude;
		this.placeUrl = placeUrl;
	}

	public X_RentShopDB(String no, String placeName, String addressJibun, String addressDoro, double longitude,
			double latitude, String placeUrl, double grade_avg, int grade_cnt) {
		super();
		this.no = no;
		this.placeName = placeName;
		this.addressJibun = addressJibun;
		this.addressDoro = addressDoro;
		this.longitude = longitude;
		this.latitude = latitude;
		this.placeUrl = placeUrl;
		this.grade_avg = grade_avg;
		this.grade_cnt = grade_cnt;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public double getGrade_avg() {
		return grade_avg;
	}

	public void setGrade_avg(double grade_avg) {
		this.grade_avg = grade_avg;
	}

	public int getGrade_cnt() {
		return grade_cnt;
	}

	public void setGrade_cnt(int grade_cnt) {
		this.grade_cnt = grade_cnt;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public String getAddressJibun() {
		return addressJibun;
	}

	public void setAddressJibun(String addressJibun) {
		this.addressJibun = addressJibun;
	}

	public String getAddressDoro() {
		return addressDoro;
	}

	public void setAddressDoro(String addressDoro) {
		this.addressDoro = addressDoro;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public String getPlaceUrl() {
		return placeUrl;
	}

	public void setPlaceUrl(String placeUrl) {
		this.placeUrl = placeUrl;
	}

}
