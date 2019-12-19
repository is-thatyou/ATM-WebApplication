package com.atm.servlet;

import java.io.IOException;
//import java.io.PrintWriter;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atm.service.*;


@WebServlet("/CreditServlet")
public class CreditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CreditServlet() {
        // TODO Auto-generated constructor stub
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		double creditAmount;
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		int accountNo = (int) session.getAttribute("ACCOUNTNO");
		// getting account number from Menu.jsp
		String stringAmount = request.getParameter("amount");
	
		creditAmount = Double.parseDouble(stringAmount);
		
		UserMethods methods = new ServiceImplementation();
		methods.creditTrans(accountNo,creditAmount);
		System.out.println("Everything is fine till here in CreditServlet");
		
		out.print("Transaction Sucessful");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Successful.jsp");
		dispatcher.include(request, response);
	}

}
