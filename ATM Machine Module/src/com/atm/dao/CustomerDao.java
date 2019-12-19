package com.atm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.atm.entity.Customer;
import com.atm.helper.JDBCConnection;
public class CustomerDao {
	
	private Connection connection = null;
	private PreparedStatement statement = null;
	private ResultSet resultset = null;
	
	public boolean validatekUser(int accountNo , int pass) throws SQLException, ClassNotFoundException
	{
		boolean b = false ;
		final String dbquery = "select Account_No,pin from Account_info where Account_No=" + accountNo; 
		connection=JDBCConnection.createConnection();
		statement = connection.prepareStatement(dbquery);
		resultset = statement.executeQuery();
		Integer pswd=0;
				while(resultset.next()) {
					pswd = resultset.getInt("pin");
				}
				System.out.println(pswd);
			if(pswd==pass)
			{
				System.out.println("Valid User Can Proceed ");
				b=true;
			}
			else
			{
				System.out.println("Invalid Account Number or Password");
			}
		System.out.println(b);
		return b;
	}
	
	public ArrayList<Customer> customerDetails(int accountNo) throws ClassNotFoundException , SQLException
	{
		final String query ="select Cust_Name,Account_No from Customer where Account_no=" + accountNo;
		connection = JDBCConnection.createConnection();
		statement = connection.prepareStatement(query);
		resultset = statement.executeQuery();
		ArrayList<Customer> detalisList = new ArrayList<Customer>();
		
		while(resultset.next())
		{
			Customer entity = new Customer();
			entity.setName(resultset.getString(1));
			entity.setAccount_No(resultset.getInt(2));
			detalisList.add(entity);
		}
		resultset.close();
		JDBCConnection.closeConnection();
		return detalisList;
		
	}
	

}
