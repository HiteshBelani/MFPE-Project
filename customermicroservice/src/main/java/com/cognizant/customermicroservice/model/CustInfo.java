package com.cognizant.customermicroservice.model;

public class CustInfo {
	
	private int id;
	private String name;
	private String emailId;
	private String phoneNo;
	private String address;
	private String userName;
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public CustInfo(int id, String name, String emailId, String phoneNo, String address, String userName,
			String password) {
		super();
		this.id = id;
		this.name = name;
		this.emailId = emailId;
		this.phoneNo = phoneNo;
		this.address = address;
		this.userName = userName;
		this.password = password;
	}
	public CustInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CustInfo [id=" + id + ", name=" + name + ", emailId=" + emailId + ", phoneNo=" + phoneNo + ", address="
				+ address + ", userName=" + userName + ", password=" + password + "]";
	}
	
	
	
}
