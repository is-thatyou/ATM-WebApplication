package com.atm.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.atm.dao.AccountDao;
import com.atm.dao.CustomerDao;
import com.atm.entity.Customer;




public class ServiceImplementation implements UserMethods {

	double balance;
	@Override
	public double checkBalance(int accountNo) {
		AccountDao account = new AccountDao();
		try {
			balance = account.checkBalance(accountNo);
		} catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		return balance;
	}

	@Override
	public void creditTrans(int accountNo, double amount) {
		AccountDao account = new AccountDao();
		try {
			account.creditTrans(accountNo, amount);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Everything is fine till here in ServiceImpl");
		
	}

	@Override
	public boolean debitTrans(int accountNo, double amount) {
		AccountDao account = new AccountDao();
		boolean flag = false;
		try {
			flag =account.debitTrans(accountNo, amount);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(flag + " from ServiceImpl");
		return flag;
		
	}

	@Override
	public boolean checkMinBalance(int accountNo, double amount) {
		AccountDao account = new AccountDao();
		boolean flag = false;
		try {
			flag=account.minBalance(accountNo, amount);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	@Override
	public boolean authenticate(int accountNo, int pass) {
		CustomerDao customer = new CustomerDao();
		boolean flag = false;
		try {
			flag=customer.validatekUser(accountNo, pass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(flag);
		return flag;
		
	}

	@Override
	public ArrayList<Customer> userDetails(int accountNo) {
		ArrayList<Customer> details = new ArrayList<>();
		CustomerDao dao = new CustomerDao();
		try {
			details=dao.customerDetails(accountNo);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return details;
	}

	

	
}
