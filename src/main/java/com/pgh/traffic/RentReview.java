package com.pgh.traffic;

import java.util.Date;

public class RentReview {
	private int rentReviewNo;
	private int rentShopNo;
	private String rentId;
	private int rentGrade;
	private Date rentDate;
	private String rentCar;
	private String rentReview;
	private String rentImg;
	
	public RentReview() {
		// TODO Auto-generated constructor stub
	}

	public RentReview(int rentReviewNo, int rentShopNo, String rentId, int rentGrade, Date rentDate, String rentCar,
			String rentReview, String rentImg) {
		super();
		this.rentReviewNo = rentReviewNo;
		this.rentShopNo = rentShopNo;
		this.rentId = rentId;
		this.rentGrade = rentGrade;
		this.rentDate = rentDate;
		this.rentCar = rentCar;
		this.rentReview = rentReview;
		this.rentImg = rentImg;
	}

	public int getRentReviewNo() {
		return rentReviewNo;
	}

	public void setRentReviewNo(int rentReviewNo) {
		this.rentReviewNo = rentReviewNo;
	}

	public int getRentShopNo() {
		return rentShopNo;
	}

	public void setRentShopNo(int rentShopNo) {
		this.rentShopNo = rentShopNo;
	}

	public String getRentId() {
		return rentId;
	}

	public void setRentId(String rentId) {
		this.rentId = rentId;
	}

	public int getRentGrade() {
		return rentGrade;
	}

	public void setRentGrade(int rentGrade) {
		this.rentGrade = rentGrade;
	}

	public Date getRentDate() {
		return rentDate;
	}

	public void setRentDate(Date rentDate) {
		this.rentDate = rentDate;
	}

	public String getRentCar() {
		return rentCar;
	}

	public void setRentCar(String rentCar) {
		this.rentCar = rentCar;
	}

	public String getRentReview() {
		return rentReview;
	}

	public void setRentReview(String rentReview) {
		this.rentReview = rentReview;
	}

	public String getRentImg() {
		return rentImg;
	}

	public void setRentImg(String rentImg) {
		this.rentImg = rentImg;
	}
	
}
