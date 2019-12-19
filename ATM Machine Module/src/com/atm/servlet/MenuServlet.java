package com.atm.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/MenuServlet")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		HttpSession session =request.getSession();
		int MenuAccountNo = (int) session.getAttribute("ACCOUNTNO");
		// Getting Account Number From MAinMenuJsp using Session object.

		//HttpSession session = request.getSession();
		String option = (String) request.getParameter("option");
		System.out.println("Account Number From Menu Servlet "+ MenuAccountNo);
		
		if("Deposit".equals(option))
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Credit.jsp");
			dispatcher.forward(request, response);
			
		}
		else if("Withdraw".equals(option))
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Debit.jsp");
			session.setAttribute("ACCOUNTNO", MenuAccountNo);
			dispatcher.forward(request, response);
				
		}
		
		else if("BalanceEnquiry".equals(option))
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("/BalanceEnquiry");
			session.setAttribute("ACCOUNTNO", MenuAccountNo);
			dispatcher.forward(request, response);
			
		}
		else
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("/MainMenu.jsp");
			session.setAttribute("ACCOUNTNO", MenuAccountNo);
			dispatcher.forward(request, response);
			

		}
		
		
	}

}
