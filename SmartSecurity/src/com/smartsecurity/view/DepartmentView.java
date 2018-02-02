package com.smartsecurity.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smartsecurity.contract.SmartSecurityContract.DepartmentEntry;

/**
 * Servlet implementation class DepartmentView
 */
@WebServlet("/DepartmentView")
public class DepartmentView extends HttpServlet implements DepartmentEntry {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String htmlFile = 
				  "<html>"
				+ "<body style='font-family: Arial'>"
				+ "	<form action='DepartmentSubmit' method='post' enctype='multipart/form-data'>"
				+ "	<table>"
				+ "		<caption><b>Add Department</b></caption>"
				+ "		<tr>"
				+ "			<td><b>Department Name: </b></td>"
				+ "			<td><input type='text' name='"+ COLUMN_DEP_NAME+"' size=45></td>"
				+ "		</tr>"
				+ "		<tr>"
				+ "			<td><b>Department Logo: </b></td>"
				+ "			<td><input type='file' name='"+ COLUMN_DEP_LOGO+"'></td>"
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
