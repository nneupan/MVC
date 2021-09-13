package com.learning.service;
/**
 * 
 * @author nilkantha
 *
 */
public class StudentDto {
	private String name;
	private String email;
	private String password;
	private String address;
	private String mobile;

	private int studentId;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "StudentEntity [name=" + name + ", email=" + email + ", password=" + password + ", address=" + address
				+ ", mobile=" + mobile + ", studentId=" + studentId + "]";
	}
	
}
