package com.douzon.jdbc.hr.vo;

public class EmployeeVo {
	private long no;
	private String first_name;
	private String last_name;
	private String email;
	private String phone;
	private String hire_date;
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
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
	public String getHire_date() {
		return hire_date;
	}
	public void setHire_date(String hire_date) {
		this.hire_date = hire_date;
	}
	@Override
	public String toString() {
		return "사원정보[사원번호=" + no + ", 이름=" + first_name + last_name + ", email=" + email
				+ ", phone=" + phone + ", 입사일=" + hire_date + "]";
	}
	
	
}
