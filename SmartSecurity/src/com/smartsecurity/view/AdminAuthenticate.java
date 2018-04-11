package com.smartsecurity.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smartsecurity.contract.SmartSecurityContract.AdminEntry;
import com.smartsecurity.controller.AdminCntroller;
import com.smartsecurity.model.Admin;

/**
 * Servlet implementation class AdminAuthenticate
 */
@WebServlet("/AdminAuthenticate")
public class AdminAuthenticate extends HttpServlet implements AdminEntry {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminAuthenticate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		
		String adminId= request.getParameter(COLUMN_ADMIN_ID).trim();
		String adminPassword= request.getParameter(COLUMN_ADMIN_PASSWORD);
		
		Admin a= AdminCntroller.authenticateAdmin(adminId, adminPassword);
		
		if(a==null){
			System.out.println("Invalid Id/Password");
			out.println("<html>"
					+ "  <body style='font-family: Arial'>"
					+ "		<b>Invalid Id or Password</b>"
					+ "		<br><b>Try Again</b>"
					+ "	 </body>"
					+ "	 </html>");
			
		} else {
			HttpSession session= request.getSession();
			session.putValue("ADMINSESSION", a);
			session.putValue("SESSIONLOGINTIME", new java.util.Date().toString());
			
			response.sendRedirect("AdminHome");
		}
	}

}
