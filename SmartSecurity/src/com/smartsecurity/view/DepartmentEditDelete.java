package com.smartsecurity.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smartsecurity.contract.SmartSecurityContract.DepartmentEntry;
import com.smartsecurity.controller.DepartmentController;
import com.smartsecurity.model.Department;

/**
 * Servlet implementation class DepartmentEditDelete
 */
@WebServlet("/DepartmentEditDelete")
public class DepartmentEditDelete extends HttpServlet implements DepartmentEntry {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DepartmentEditDelete() {
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
		
		Department d= DepartmentController.getDepartmentById(request.getParameter(COLUMN_DEP_ID));
		
		String htmlFile = 
				  "<html>"
				+ "<body style='font-family: Arial'>"
				+ "	<form action='DepartmentFinalEditDelete' method='post' enctype='multipart/form-data'>"
				+ " <input type=hidden name='"+ COLUMN_DEP_ID+"' value='"+ d.getDepartmentId()+"'>"
				+ "	<table>"
				+ "		<caption><b>Edit Department Details</b></caption>"
				+ "		<tr>"
				+ "			<td><b>Department Name: </b></td>"
				+ "			<td><input type='text' name='"+ COLUMN_DEP_NAME+"' value='"+ d.getDepartmentName()+"' size=45></td>"
				+ "		</tr>"
				+ "	</table>"
				+ " <br>"
				+ "	<input type='submit' value='Update' name='butt'><br><br>"
				+ " <table border=1>"
				+ "		<tr>"
				+ "			<td><b>Department Logo: </b></td>"
				+ "			<td><img src='picture/"+ d.getDepartmentLogo()+"' width=90 height=90></td>"
				+ "		</tr>"
				+ "		<tr>"
				+ "			<td><b>Update Department Logo: </b></td>"
				+ "			<td><input type='file' name='"+ COLUMN_DEP_LOGO+"'></td>"
				+ "		</tr>"
				+ "	</table>"
				+ "	<br>"
				+ "	<input type='submit' value='Update Logo' name='butt'>"
				+ "	<br>"
				+ "</form>"
				+ "</body>"
				+ "</html>";
		
		out.println(htmlFile);
		out.flush();
	}

}
