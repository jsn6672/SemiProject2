package com.semi.jh.login;

public class Account {

	private String id;
	private String pw;
	private String name;
	private String gender;
	private String birth;
	private String addr;
	private	String question;

	public Account() {
		// TODO Auto-generated constructor stub
	}

	public String getQuestion() {
		return question;
	}

	public Account(String question) {
		super();
		this.question = question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public Account(String id, String pw, String name, String gender, String birth, String addr) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.gender = gender;
		this.birth = birth;
		this.addr = addr;
	}
	
	
}
