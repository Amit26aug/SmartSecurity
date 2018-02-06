package com.smartsecurity.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smartsecurity.controller.EmployeeController;
import com.smartsecurity.model.Employee;

/**
 * Servlet implementation class EmployeeEditDelete
 */
@WebServlet("/EmployeeEditDelete")

public class EmployeeEditDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeEditDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Employee E = EmployeeController.getEmployeeById(Integer.parseInt(request.getParameter("eid")));
		PrintWriter out=response.getWriter();
		
		out.println("<html>"
				+ "<form action='EmployeeFinalEditDelete' method=post enctype='multipart/form-data'>"
				+ "<input type=hidden value="+E.getEmployeeId()+" name=eid>"
				+ "<table cellspacing=10><tr>"
				+ "<td>"
				+ "<table>"
				+ "<caption><b><i>Employee Registration</i></b></caption>"
				+ "<tr><td><b><i>Employee Name:</i></b></td>"
				+ "<td><input type=text name=ename value='"+E.getEmployeeName()+"' size=30></td></tr>"
				
				+ "<tr><td><b><i>Employee DOB:</i></b></td>"
				+ "<td><input type=date name=edob value='"+E.getEmployeeDOB()+"' size=30></td></tr>"
				
				+ "<tr><td><b><i>Employee Gender:</i></b></td>"
				+ "<td><input type=text name=egender value='"+E.getEmployeeGender()+"' size=30></td></tr>"
				
				+ "<tr><td><b><i>Employee Coressponding Address:</i></b></td>"
				+ "<td><input type=text name=ecoraddress value='"+E.getEmployeeCorAddress()+"' size=30></td></tr>"
				
				+ "<tr><td><b><i>Employee Coressponding State:</i></b></td>"
				+ "<td><input type=text name=ecorstate value='"+E.getEmployeeCorState()+"' size=30></td></tr>"
				
				+ "<tr><td><b><i>Employee Coressponding City:</i></b></td>"
				+ "<td><input type=text name=ecorcity value='"+E.getEmployeeCorCity()+"' size=30></td></tr>"
				
				+ "<tr><td><b><i>Employee Permanent Address:</i></b></td>"
				+ "<td><input type=text name=eperaddress value='"+E.getEmployeePerAddress()+"' size=30></td></tr>"
				
				+ "<tr><td><b><i>Employee Permanent State:</i></b></td>"
				+ "<td><input type=text name=eperstate value='"+E.getEmployeePerState()+"' size=30></td></tr>"
				
				+ "<tr><td><b><i>Employee Permanent City:</i></b></td>"
				+ "<td><input type=text name=epercity value='"+E.getEmployeePerCity()+"' size=30></td></tr>"
				
				+ "<tr><td><b><i>Employee Department:</i></b></td>"
				+ "<td><input type=text name=edepartment value='"+E.getEmployeeDepartment()+"' size=30></td></tr>"
				
				+ "<tr><td><b><i>Employee Qualification:</i></b></td>"
				+ "<td><input type=text name=equalification value='"+E.getEmployeeQualification()+"' size=30></td></tr>"
				
				+ "<tr><td><b><i>Employee Designation:</i></b></td>"
				+ "<td><input type=text name=edesignation value='"+E.getEmployeeDesignation()+"' size=30></td></tr>"
				
				+ "<tr><td><b><i>Employee Mobile:</i></b></td>"
				+ "<td><input type=text name=emobile value='"+E.getEmployeeMobile()+"' size=30></td></tr>"
				
				+ "<tr><td><b><i>Employee Email:</i></b></td>"
				+ "<td><input type=text name=eemail value='"+E.getEmployeeEmail()+"' size=30></td></tr>"
				+ "</table><br>"
				
				+ "<input type=submit value=Update name=btn>&nbsp;&nbsp;<input type=submit value=Delete name=btn></br>"
				+ "</td><td valign=top>"
				+ "<b><i>Employee Photo:</i></b><input type=file name=ephoto><br><br>"
				+ "<img src=picture/employee/"+E.getEmployeePhoto()+" width=60 height=60><br><br>"
				+ "<input type=submit name=btn value='Update Picture'>"
				+ "</form></html>");
	}

}
