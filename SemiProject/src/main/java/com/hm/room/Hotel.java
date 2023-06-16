package com.hm.room;

public class Hotel {
		private String r_title;
		private String r_address;
		private String r_roadaddress;
		private String r_introduction;
		private double r_latitude;
		private double r_longitude;
		private String r_phoneno;
		private String r_imgpath;
		private String r_thumnailpath;
		private String r_tag;
		
		public Hotel() {

		}

		public Hotel(String r_title, String r_address, String r_roadaddress, String r_introduction, double r_latitude,
				double r_longitude, String r_phoneno, String r_imgpath, String r_thumnailpath, String r_tag) {
			super();
			this.r_title = r_title;
			this.r_address = r_address;
			this.r_roadaddress = r_roadaddress;
			this.r_introduction = r_introduction;
			this.r_latitude = r_latitude;
			this.r_longitude = r_longitude;
			this.r_phoneno = r_phoneno;
			this.r_imgpath = r_imgpath;
			this.r_thumnailpath = r_thumnailpath;
			this.r_tag = r_tag;
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

		public double getR_latitude() {
			return r_latitude;
		}

		public void setR_latitude(double r_latitude) {
			this.r_latitude = r_latitude;
		}

		public double getR_longitude() {
			return r_longitude;
		}

		public void setR_longitude(double r_longitude) {
			this.r_longitude = r_longitude;
		}

		public String getR_phoneno() {
			return r_phoneno;
		}

		public void setR_phoneno(String r_phoneno) {
			this.r_phoneno = r_phoneno;
		}

		public String getR_imgpath() {
			return r_imgpath;
		}

		public void setR_imgpath(String r_imgpath) {
			this.r_imgpath = r_imgpath;
		}

		public String getR_thumnailpath() {
			return r_thumnailpath;
		}

		public void setR_thumnailpath(String r_thumnailpath) {
			this.r_thumnailpath = r_thumnailpath;
		}

		public String getR_tag() {
			return r_tag;
		}

		public void setR_tag(String r_tag) {
			this.r_tag = r_tag;
		}

		
		
}