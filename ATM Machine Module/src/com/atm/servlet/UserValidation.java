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

@WebServlet("/UserValidation")
public class UserValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		UserMethods methods = new ServiceImplementation();
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		int accNo = Integer.parseInt(request.getParameter("accountNo"));
		int pass = Integer.parseInt(request.getParameter("pass"));
		System.out.println(accNo);
		System.out.println(pass);
		System.out.println("working till here userValidation");
		if (methods.authenticate(accNo, pass)) {
			System.out.println("Inside if Block");
			session.setAttribute("ACCOUNTNO",accNo);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/MainMenu.jsp");
			dispatcher.forward(request, response);

		}

		else {
			System.out.println("inside else block");
			out.println("Invalid Account Number or Password from UserValidation ");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Validate.jsp");
			dispatcher.include(request, response);
		}
	}

}
