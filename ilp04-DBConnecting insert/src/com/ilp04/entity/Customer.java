package com.ilp04.entity;

public class Customer {
	private int customercode;
	private String customer_firstname;
	private String customer_lastname;
	private String address;
	private long phonenumber;
	private long aadhaarno;
	public Customer(int customercode, String customer_firstname, String customer_lastname, String address,
			long phonenumber, long aadhaarno) {
		super();
		this.customercode = customercode;
		this.customer_firstname = customer_firstname;
		this.customer_lastname = customer_lastname;
		this.address = address;
		this.phonenumber = phonenumber;
		this.aadhaarno = aadhaarno;
	}
	public Customer(String customer_firstname, String customer_lastname, String address, long phonenumber,
			long aadhaarno) {
		this.customer_firstname = customer_firstname;
		this.customer_lastname = customer_lastname;
		this.address = address;
		this.phonenumber = phonenumber;
		this.aadhaarno = aadhaarno;
	}
	public int getCustomercode() {
		return customercode;
	}
	public void setCustomercode(int customercode) {
		this.customercode = customercode;
	}
	public String getCustomer_firstname() {
		return customer_firstname;
	}
	public void setCustomer_firstname(String customer_firstname) {
		this.customer_firstname = customer_firstname;
	}
	public String getCustomer_lastname() {
		return customer_lastname;
	}
	public void setCustomer_lastname(String customer_lastname) {
		this.customer_lastname = customer_lastname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}
	public long getAadhaarno() {
		return aadhaarno;
	}
	public void setAadhaarno(long aadhaarno) {
		this.aadhaarno = aadhaarno;
	}
	
}
