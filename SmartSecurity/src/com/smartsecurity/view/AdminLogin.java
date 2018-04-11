package com.smartsecurity.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smartsecurity.contract.SmartSecurityContract.AdminEntry;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet implements AdminEntry {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String htmlFile = 
				  "<html>"
				+ "<body style='font-family: Arial'>"
				+ "	<form action='AdminAuthenticate' method='post'>"
				+ "	<table>"
				+ "		<caption><b>Admin Login</b></caption>"
				+ "		<tr>"
				+ "			<td><b>Admin ID: </b></td>"
				+ "			<td><input type='text' name='"+COLUMN_ADMIN_ID+"' size='45'></td>"
				+ "		</tr>"
				+ "		<tr>"
				+ "			<td><b>Admin Password: </b></td>"
				+ "			<td><input type='password' name='"+COLUMN_ADMIN_PASSWORD+"' size='45'></td>"
				+ "		</tr>"
				+ "	</table>"
				+ "	<br>"
				+ "	<input type='submit' value='Login'>&nbsp;&nbsp;"
				+ "	<input type='reset'>"
				+ "	<br>"
				+ "</form>"
				+ "</body>"
				+ "</html>";
		
		out.println(htmlFile);
		out.flush();
	}

}
