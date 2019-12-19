package com.atm.entity;

public class Customer {
	
	private int CustomerId;
	private String Name ;
	private int Account_No ;
	private int Phone_No ;
	private String Address ;
	private String Email ;
	private int Date_Of_Birth ;
	public int getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(int customerId) {
		CustomerId = customerId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getAccount_No() {
		return Account_No;
	}
	public void setAccount_No(int account_No) {
		Account_No = account_No;
	}
	public int getPhone_No() {
		return Phone_No;
	}
	public void setPhone_No(int phone_No) {
		Phone_No = phone_No;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public int getDate_Of_Birth() {
		return Date_Of_Birth;
	}
	public void setDate_Of_Birth(int date_Of_Birth) {
		Date_Of_Birth = date_Of_Birth;
	}

}
