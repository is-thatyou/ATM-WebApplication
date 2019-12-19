package com.atm.service;

import java.util.ArrayList;
import com.atm.entity.Customer;

public interface UserMethods {

	public double checkBalance(int accountNo);
	public void creditTrans( int accountNo , double amount);
	public boolean debitTrans(int accountNo , double amount);
	public boolean checkMinBalance(int accountNo , double amount);
	public ArrayList<Customer> userDetails(int accountNo);
	public boolean authenticate(int accountNo , int pass);
}