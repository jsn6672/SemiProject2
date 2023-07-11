package com.pgh.traffic;

public class RentShop {
	private String placeNo;
	private String placeName;
	private String addressJibun;
	private String addressDoro;
	private double longitude;
	private double latitude;
	private String placeUrl;
	private double gradeAvg;
	private int gradeCnt;

	public RentShop() {
		// TODO Auto-generated constructor stub
	}

	public RentShop(String placeNo, String placeName, String addressJibun, String addressDoro, double longitude,
			double latitude, String placeUrl, double gradeAvg, int gradeCnt) {
		super();
		this.placeNo = placeNo;
		this.placeName = placeName;
		this.addressJibun = addressJibun;
		this.addressDoro = addressDoro;
		this.longitude = longitude;
		this.latitude = latitude;
		this.placeUrl = placeUrl;
		this.gradeAvg = gradeAvg;
		this.gradeCnt = gradeCnt;
	}

	public String getPlaceNo() {
		return placeNo;
	}

	public void setPlaceNo(String placeNo) {
		this.placeNo = placeNo;
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

	public double getGradeAvg() {
		return gradeAvg;
	}

	public void setGradeAvg(double gradeAvg) {
		this.gradeAvg = gradeAvg;
	}

	public int getGradeCnt() {
		return gradeCnt;
	}

	public void setGradeCnt(int gradeCnt) {
		this.gradeCnt = gradeCnt;
	}

	@Override
	public String toString() {
		return "RentShop [placeNo=" + placeNo + ", placeName=" + placeName + ", addressJibun=" + addressJibun
				+ ", addressDoro=" + addressDoro + ", longitude=" + longitude + ", latitude=" + latitude + ", placeUrl="
				+ placeUrl + ", gradeAvg=" + gradeAvg + ", gradeCnt=" + gradeCnt + "]";
	}

}
