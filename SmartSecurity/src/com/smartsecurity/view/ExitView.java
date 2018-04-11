package com.smartsecurity.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smartsecurity.contract.SmartSecurityContract.ExitEntry;

/**
 * Servlet implementation class ExitView
 */
@WebServlet("/ExitView")
public class ExitView extends HttpServlet implements ExitEntry {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExitView() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String htmlFile = 
				  "<html>"
				+ "<body style='font-family: Arial'>"
				+ "	<form action='ExitSubmit' method='post'>"
				+ "	<table>"
				+ "		<caption><b>Visitor Exit</b></caption>"
				+ "		<tr>"
				+ "			<td><b>RFID: </b></td>"
				+ "			<td><input type='text' name='"+ COLUMN_EXIT_RFID+"' size='45'></td>"
				+ "		</tr>"
				+ "		<tr>"
				+ "			<td><b>Exit Date: </b></td>"
				+ "			<td><input type='date' name='"+ COLUMN_EXIT_DATE+"'></td>"
				+ "		</tr>"
				+ "		<tr>"
				+ "			<td><b>Exit Time: </b></td>"
				+ "			<td><input type='time' name='"+ COLUMN_EXIT_TIME+"'></td>"
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
