package com.hm.room;

public class HotelReviewInfo {
	private String cid;
	private String hotelname;

	public HotelReviewInfo() {
		// TODO Auto-generated constructor stub
	}

	public HotelReviewInfo(String cid, String hotelname) {
		super();
		this.cid = cid;
		this.hotelname = hotelname;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getHotelname() {
		return hotelname;
	}

	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}

	@Override
	public String toString() {
		return "HotelReviewInfo [cid=" + cid + ", hotelname=" + hotelname + "]";
	}
	
	
	
}
