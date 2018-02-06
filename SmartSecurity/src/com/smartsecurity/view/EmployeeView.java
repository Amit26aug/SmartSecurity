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
		
		out.println("<html>"
				+ "<form action='EmployeeSubmit' method='post' enctype='multipart/form-data'>"
				+ "<table>"
				+ "<caption><b><i>Employee Registration</i></b></caption>"
				
				+ "<tr><td><b><i>Employee Name:</i></b></td>"
				+ "<td><input type=text name=ename size=30></td></tr>"
				
				+ "<tr><td><b><i>Employee DOB:</i></b></td>"
				+ "<td><input type=date name=edob size=30></td></tr>"
				
				+ "<tr><td><b><i>Employee Gender:</i></b></td>"
				+ "<td><input type=text name=egender size=30></td></tr>"
				
				+ "<tr><td><b><i>Employee Corresponding Address:</i></b></td>"
				+ "<td><input type=text name=ecoraddress size=30></td></tr>"
				
				+ "<tr><td><b><i>Employee Corresponding State:</i></b></td>"
				+ "<td><input type=text name=ecorstate size=30></td></tr>"
				
				+ "<tr><td><b><i>Employee Corresponding City:</i></b></td>"
				+ "<td><input type=text name=ecorcity size=30></td></tr>"
				
				+ "<tr><td><b><i>Employee Permanent Address:</i></b></td>"
				+ "<td><input type=text name=eperaddress size=30></td></tr>"
				
				+ "<tr><td><b><i>Employee Permanent State:</i></b></td>"
				+ "<td><input type=text name=eperstate size=30></td></tr>"
				
				+ "<tr><td><b><i>Employee Permanent City:</i></b></td>"
				+ "<td><input type=text name=epercity size=30></td></tr>"
				
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
				+ "</form></html>");
		
		out.flush();
	}

}
