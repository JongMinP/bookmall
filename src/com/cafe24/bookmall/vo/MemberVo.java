package com.cafe24.bookmall.vo;

public class MemberVo {
	private int no;
	private String email;
	private String phone;
	private String name;
	private String password;

	
	
	public MemberVo() {	}
	
	public MemberVo(int no, String email, String phone, String name, String password) {
		super();
		this.no = no;
		this.email = email;
		this.phone = phone;
		this.name = name;
		this.password = password;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "MemberVo [no=" + no + ", email=" + email + ", phone=" + phone + ", name=" + name + ", password="
				+ password + "]";
	}
	
	
	

}
