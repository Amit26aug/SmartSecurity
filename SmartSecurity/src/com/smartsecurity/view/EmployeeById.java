package com.smartsecurity.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeById
 */
@WebServlet("/EmployeeById")
public class EmployeeById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeById() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		out.println("<html>"
				+ "<form action='EmployeeEditDelete'>"
				+ "<table>"
				+ "<caption><b>Search Employee</b></caption>"
				+ "<tr><td><b>Employee ID:</b></td><td><input type=text name=eid size=30></td><td><input type=submit></td></tr>"
				+ "</table></form></html>");
		out.flush();
	}

}
