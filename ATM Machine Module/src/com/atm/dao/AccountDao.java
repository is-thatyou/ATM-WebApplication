package com.atm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.atm.helper.JDBCConnection;

public class AccountDao {
	private Connection connection =null;
	private PreparedStatement statement = null;
	private ResultSet resultset = null;
	
	
	public double checkBalance(int accountNo) throws ClassNotFoundException, SQLException
	{	 double balance=0;
		String balCheck = "select Balance from Account_info where Account_no="+ accountNo;
		connection = JDBCConnection.createConnection();
		statement = connection.prepareStatement(balCheck);
		resultset = statement.executeQuery();
		while(resultset.next())
		{
			balance =(double)resultset.getInt(1);
		}
		resultset.close();
		JDBCConnection.closeConnection();
	    return balance;
	}
	
	public void creditTrans( int accountNo , double amount) throws ClassNotFoundException, SQLException
	{

		connection = JDBCConnection.createConnection();
		String creditBal = "update Account_info set Balance ="+" Balance+" + amount +" where Account_no="+accountNo;
		statement = connection.prepareStatement(creditBal);
		statement.executeUpdate();
		JDBCConnection.closeConnection();
		System.out.println("Everything is fine till here in Dao");
	}
		
	
	public boolean debitTrans( int accountNo , double amount) throws ClassNotFoundException, SQLException
	{
		boolean flag = false;		
		connection = JDBCConnection.createConnection();
			String debitBal = "update Account_info set Balance ="+" Balance -" + amount +" where Account_no="+accountNo;
			statement = connection.prepareStatement(debitBal);
			statement.executeUpdate();		
			JDBCConnection.closeConnection();
			flag = true;
		System.out.println(flag + "From Dao");
		return flag;
		
	}
	
	public boolean minBalance(int accountNo,double amount) throws ClassNotFoundException, SQLException
	{
		double minBalance=0;
		boolean flag = true;
		final String balance ="select Balance from Account_info where Account_No=" + accountNo;
			connection = JDBCConnection.createConnection();
			statement = connection.prepareStatement(balance);
			resultset = statement.executeQuery();
			while(resultset.next())
			{
				minBalance = (double)resultset.getInt(1);
			}
			if(minBalance < amount)
			{
				flag = false;
			}
			resultset.close();
			JDBCConnection.closeConnection();
		return flag;
		
	}
	

}
