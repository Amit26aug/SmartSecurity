package com.smartsecurity.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeView
 */
@WebServlet("/EmployeeView")
public class EmployeeView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		out.println(
				  "<script src='asset/jquery-3.2.1.min.js'></script>"
				+ "<script src='asset/statecity.js'></script>"
				+ "<html>"
				+ "<body style='font-family: Arial'>"
				+ "<form action='EmployeeSubmit' method='post' enctype='multipart/form-data'>"
				+ "<table>"
				+ "<caption><b><i>Employee Registration</i></b></caption>"
				
				+ "<tr><td><b><i>Employee Name:</i></b></td>"
				+ "<td><input type=text name=ename size=30></td></tr>"
				
				+ "<tr><td><b><i>Employee DOB:</i></b></td>"
				+ "<td><input type=date name=edob size=30></td></tr>"
				
				+ "<tr><td><b><i>Employee Gender:</i></b></td>"
				+ "<td><select name=egender><option>Male</option><option>Female</option><option>Other</option></select></td></tr>"
				
				+ "<tr><td><b><i>Employee Correspondance Address:</i></b></td>"
				+ "<td><textarea name='ecoraddress' rows='3' cols='45'></textarea></td></tr>"
				
				+ "<tr><td><b><i>Employee Correspondance State:</i></b></td>"
				+ "<td><select name=ecorstate id=state></select></td></tr>"
				
				+ "<tr><td><b><i>Employee Correspondance City:</i></b></td>"
				+ "<td><select name=ecorcity id=city></select></td></tr>"
				
				+ "<tr><td><b><i>Employee Permanent Address:</i></b></td>"
				+ "<td><textarea name='eperaddress' rows='3' cols='45'></textarea></td></tr>"
				
				+ "<tr><td><b><i>Employee Permanent State:</i></b></td>"
				+ "<td><select name=eperstate id=state2></select></td></tr>"
				
				+ "<tr><td><b><i>Employee Permanent City:</i></b></td>"
				+ "<td><select name=epercity id=city2></select></td></tr>"
				
				+ "<tr><td><b><i>Employee Department:</i></b></td>"
				+ "<td><input type=text name=edepartment size=30></td></tr>"
				
				+ "<tr><td><b><i>Employee Qualification:</i></b></td>"
				+ "<td><input type=text name=equalification size=30></td></tr>"
				
				+ "<tr><td><b><i>Employee Designation:</i></b></td>"
				+ "<td><input type=text name=edesignation size=30></td></tr>"
				
				+ "<tr><td><b><i>Employee Mobile:</i></b></td>"
				+ "<td><input type=number name=emobile size=30></td></tr>"
				
				+ "<tr><td><b><i>Employee Email:</i></b></td>"
				+ "<td><input type=text name=eemail size=30></td></tr>"
				
				+ "<tr><td><b><i>Employee Photo:</i></b></td>"
				+ "<td><input type=file name=ephoto></td></tr>"
				+ "</table><br>"
				+ "<input type=submit>&nbsp;&nbsp;<input type=reset></br>"
				+ "</body>"
				+ "</form></html>");
		
		out.flush();
	}

}
