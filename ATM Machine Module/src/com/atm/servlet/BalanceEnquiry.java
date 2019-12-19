package com.atm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atm.entity.*;
import com.atm.service.*;

@WebServlet("/BalanceEnquiry")
public class BalanceEnquiry extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("Inside BalanceEnquiry Servlet ");
		double balance;
		
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		//PrintWriter out = response.getWriter();
		int accountNo = (int) session.getAttribute("ACCOUNTNO");
		//Getting account number from Menu.jsp
		UserMethods methods = new ServiceImplementation();
		balance = methods.checkBalance(accountNo);
		
		ArrayList<Customer> allDetails = new ArrayList<>();
		allDetails = methods.userDetails(accountNo);

		session.setAttribute("BALANCE", balance);
		session.setAttribute("DETAILS", allDetails);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Balance.jsp");
		dispatcher.forward(request, response);

	}

}
