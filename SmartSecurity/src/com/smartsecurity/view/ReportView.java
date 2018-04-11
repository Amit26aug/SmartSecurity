package com.smartsecurity.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReportView
 */
@WebServlet("/ReportView")
public class ReportView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReportView() {
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
		PrintWriter out= response.getWriter();
		
		String htmlFile= 
				  "<script src='asset/jquery-3.2.1.min.js'></script>"
				+ "<script src='asset/report.js'></script>"
				+ "<html>"
				+ "		<body style='font-family: Arial'>"
				+ "			<table cellspacing=3>"
				+ "				<tr>"
				+ "					<th>Date From</th>"
				+ "					<th></th>"
				+ "					<th>Date To</th>"
				+ "				</tr>"
				+ "				<tr>"
				+ "					<td><input type=date id=fdate name=fdate></td>"
				+ "					<td></td>"
				+ "					<td><input type=date id=tdate name=tdate></td>"
				+ "				</tr>"
				+ "				<tr> </tr><tr> </tr>"
				+ "				<tr>"
				+ "					<td><b>Search: </b></td>"
				+ "					<td><input type=radio id=all    name=search value=0 checked> All</td>"
				+ "					<td><input type=radio id=byname name=search value=1> By Name </td>"
				+ "					<td><input type=radio id=bydept name=search value=2> By Conc. Dept. </td>"
				+ "					<td><input type=text  id=searchtext name=searchtext placeholder='Search here...' readonly=true></td>"
				+ "				</tr>"
				+ "				<tr>"
				+ "					<td><b>Status: </b></td>"
				+ "					<td><input type=radio id=cin  name=status value=1 checked> Checked In</td>"
				+ "					<td><input type=radio id=cout name=status value=0> Checked Out</td>"
				+ "				</tr>"
				+ "			</table><br>"
				+ "			<input type=button name=searchbutt value=Search id=searchbutt>"
				+ "			<div id=count></div>"
				+ "			<div id=result></div>"
				+ "		</body>"
				+ "</html>";
		
		out.println(htmlFile);
		
	}

}
