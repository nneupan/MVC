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
@Table(name = "employee")
public class Employee {

	private int empid;
	private String name;
	private String email;
	private String password;
	private String address;
	private String mobile;

	@Id
	@GeneratedValue
	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	@Column(length = 60)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", address=" + address + ", mobile=" + mobile + "]";
	}

}
