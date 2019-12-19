package com.atm.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atm.service.ServiceImplementation;
import com.atm.service.UserMethods;

@WebServlet("/DebitServlet")
public class DebitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public DebitServlet() {
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("Inside Debit Servlet");
		int accountNo;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		accountNo = (int) session.getAttribute("ACCOUNTNO");
		// getting account number from Menu.jsp
		Double amount =Double.parseDouble(request.getParameter("amount"));
		//getting amount to withdraw from Debit.jsp
		UserMethods methods = new ServiceImplementation();
		if(methods.checkMinBalance(accountNo, amount))
		{
			methods.debitTrans(accountNo, amount);
			System.out.println("inside True Block of Debit Servlet");
			{
				
			out.println("<html><body>"+"Please Collect Your Cash"+ "<br>" + "Thank-You For Using ABC Bank"+ "</body></html>");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Successful.jsp");
			dispatcher.include(request, response);
			}
		}
		else
		{
			out.println("Insufficent Balancen Available.... Last Transaction Is Canceled ");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Error.jsp");
			dispatcher.include(request, response);
		}
	}

}
