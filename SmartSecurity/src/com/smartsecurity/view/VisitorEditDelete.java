package com.smartsecurity.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smartsecurity.contract.SmartSecurityContract.VisitorEntry;
import com.smartsecurity.controller.VisitorController;
import com.smartsecurity.model.Visitor;

/**
 * Servlet implementation class VisitorEditDelete
 */
@WebServlet("/VisitorEditDelete")
public class VisitorEditDelete extends HttpServlet implements VisitorEntry {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VisitorEditDelete() {
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
		
		Visitor v= VisitorController.getVisitorById(request.getParameter(COLUMN_VISITOR_ID));
		
		String[] state= v.getVisitorState().split(",");
		String[] city= v.getVisitorCity().split(",");
		
		String htmlFile = 
				  "<script src='asset/jquery-3.2.1.min.js'></script>"
				+ "<script src='asset/statecity.js'></script>"
				+ "<html>"
				+ "<body style='font-family: Arial'>"
				+ "	<form action='VisitorFinalEditDelete' method='post' enctype='multipart/form-data'>"
				+ "	<table>"
				+ "		<caption><b>Update Visitor Details</b></caption>"
				+ "		<tr>"
				+ "			<td><b>Visitor ID: </b></td>"
				+ "			<td><input type='text' readonly=true name='"+ COLUMN_VISITOR_ID+"' value='"+ v.getVisitorId()+"' size='45'></td>"
				+ "		</tr>"
				+ "		<tr>"
				+ "			<td><b>Employee ID: </b></td>"
				+ "			<td><input type='text' name='"+ COLUMN_VISITOR_EMPLOYEE_ID+"' value='"+ v.getVisitorEmployeeId()+"' size='45'></td>"
				+ "		</tr>"
				+ "		<tr>"
				+ "			<td><b>Visitor Name: </b></td>"
				+ "			<td><input type='text' name='"+ COLUMN_VISITOR_NAME+"' value='"+ v.getVisitorName()+"' size='45'></td>"
				+ "		</tr>"
				+ "		<tr>"
				+ "			<td><b>Address: </b></td>"
				+ "			<td><textarea name='"+ COLUMN_VISITOR_ADDRESS+"' rows='3' cols='45'>"+ v.getVisitorAddress()+"</textarea></td>"
				+ "		</tr>"
				+ "		<tr>"
				+ "			<td><b>State: </b></td>"
				+ "			<td><select name='"+COLUMN_VISITOR_STATE+"' id='state'><option  value='"+ state[0]+ "'>"+ state[1]+"</option></select></td>"
				+ "		</tr>"
				+ "		<tr>"
				+ "			<td><b>City: </b></td>"
				+ "			<td><select name='"+COLUMN_VISITOR_CITY+"' id='city'><option  value='"+ city[0]+ "'>"+ city[1]+"</option></select></td>"
				+ "		</tr>"
				+ "		<tr>"
				+ "			<td><b>Mobile No.: </b></td>"
				+ "			<td><input type='text' name='"+COLUMN_VISITOR_MOBILE+"' value='"+ v.getVisitorMobile()+"' size='45'></td>"
				+ "		</tr>"
				+ "		<tr>"
				+ "			<td><b>Email ID: </b></td>"
				+ "			<td><input type='text' name='"+COLUMN_VISITOR_EMAIL_ID+"' value='"+ v.getVisitorEmailId()+"' size='45'></td>"
				+ "		</tr>"
				+ "		<tr>"
				+ "			<td><b>Identification No.: </b></td>"
				+ "			<td><input type='text' name='"+ COLUMN_VISITOR_IDENTIFICATION_NO+"' value='"+ v.getVisitorIdentificationNo()+"' size='45'></td>"
				+ "		</tr>"
				+ "		<tr>"
				+ "			<td><b>Identification Type: </b></td>"
				+ "			<td><input type='text' name='"+ COLUMN_VISITOR_IDENTIFICATION_TYPE+"' value='"+ v.getVisitorIdentificationType()+"' size=45></td>"
				+ "		</tr>"
				+ "	</table>"
				+ "	<br>"
				+ "	<input type='submit' value='Update' name='butt'>&nbsp;&nbsp;"
				+ "	<br><br>"
				+ " <table border=1>"
				+ "		<caption><b>Update Visitor Photograph</b></caption>"
				+ "		<tr>"
				+ "			<td><b>Photograph: </b></td>"
				+ "			<td><img src=picture/visitor/"+ v.getVisitorPicture()+" width=100 height=100></td>"
				+ "		</tr>"
				+ "		<tr>"
				+ "			<td><b>Photograph: </b></td>"
				+ "			<td><input type='file' name='"+ COLUMN_VISITOR_PICTURE+"'></td>"
				+ "		</tr>"
				+ " </table>"
				+ " <br>"
				+ " <input type='submit' value='Update Photograph' name='butt'><br><br>"
				+ " <input type='submit' value='Delete Visitor' name='butt'>"
				+ "</form>"
				+ "</body>"
				+ "</html>";
		
		out.println(htmlFile);
		out.flush();
	}

}
