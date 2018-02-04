package com.smartsecurity.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smartsecurity.contract.SmartSecurityContract.VisitorEntry;

/**
 * Servlet implementation class VisitorView
 */
@WebServlet("/VisitorView")
public class VisitorView extends HttpServlet implements VisitorEntry {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VisitorView() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String htmlFile = 
				  "<script src='asset/jquery-3.2.1.min.js'></script>"
				+ "<script src='asset/statecity.js'></script>"
				+ "<html>"
				+ "<body style='font-family: Arial'>"
				+ "	<form action='VisitorSubmit' method='post' enctype='multipart/form-data'>"
				+ "	<table>"
				+ "		<caption><b>Visitor Registration</b></caption>"
				+ "		<tr>"
				+ "			<td><b>Employee ID: </b></td>"
				+ "			<td><input type='text' name='"+ COLUMN_VISITOR_EMPLOYEE_ID+"' size='45'></td>"
				+ "		</tr>"
				+ "		<tr>"
				+ "			<td><b>Visitor Name: </b></td>"
				+ "			<td><input type='text' name='"+ COLUMN_VISITOR_NAME+"' size='45'></td>"
				+ "		</tr>"
				+ "		<tr>"
				+ "			<td><b>Address: </b></td>"
				+ "			<td><textarea name='"+ COLUMN_VISITOR_ADDRESS+"' rows='3' cols='45'></textarea></td>"
				+ "		</tr>"
				+ "		<tr>"
				+ "			<td><b>State: </b></td>"
				+ "			<td><select name='"+COLUMN_VISITOR_STATE+"' id='state'></select></td>"
				+ "		</tr>"
				+ "		<tr>"
				+ "			<td><b>City: </b></td>"
				+ "			<td><select name='"+COLUMN_VISITOR_CITY+"' id='city'></select></td>"
				+ "		</tr>"
				+ "		<tr>"
				+ "			<td><b>Mobile No.: </b></td>"
				+ "			<td><input type='text' name='"+COLUMN_VISITOR_MOBILE+"' size='45'></td>"
				+ "		</tr>"
				+ "		<tr>"
				+ "			<td><b>Email ID: </b></td>"
				+ "			<td><input type='text' name='"+COLUMN_VISITOR_EMAIL_ID+"' size='45'></td>"
				+ "		</tr>"
				+ "		<tr>"
				+ "			<td><b>Identification No.: </b></td>"
				+ "			<td><input type='text' name='"+ COLUMN_VISITOR_IDENTIFICATION_NO+"' size='45'></td>"
				+ "		</tr>"
				+ "		<tr>"
				+ "			<td><b>Identification Type: </b></td>"
				+ "			<td><input type='text' name='"+ COLUMN_VISITOR_IDENTIFICATION_TYPE+"' size=45></td>"
				+ "		</tr>"
				+ "		<tr>"
				+ "			<td><b>Photograph: </b></td>"
				+ "			<td><input type='file' name='"+ COLUMN_VISITOR_PICTURE+"'></td>"
				+ "		</tr>"
				+ "	</table>"
				+ "	<br>"
				+ "	<input type='submit'>&nbsp;&nbsp;"
				+ "	<input type='reset'>"
				+ "	<br>"
				+ "</form>"
				+ "</body>"
				+ "</html>";
		
		out.println(htmlFile);
		out.flush();
	}

}
