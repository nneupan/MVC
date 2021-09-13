package com.learning.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 
 * @author nilkantha
 *
 */
@Entity
@Table(name = "student")
public class StudentEntity {

	private int studentId;
	private String name;
	private String email;
	private String password;
	private String address;
	private String mobile;

	@Id
	@GeneratedValue
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	@Column(nullable = true)

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(nullable = false)
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
