package com.smartsecurity.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smartsecurity.controller.EmployeeController;

/**
 * Servlet implementation class EmployeeDisplayAll
 */
@WebServlet("/EmployeeDisplayAll")
public class EmployeeDisplayAll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeDisplayAll() {
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
		try {
			out.println("<html>");
			ResultSet rs = EmployeeController.getAllEmployees();
			if (rs.next()) {
				out.println("<table border = 1>");
				out.println("<caption>List Of Employees</caption>");
				out.println(
						"<tr><th>Sno</th><th>Employee ID</th><th>Name</th><th>DOB</th><th>Corresponding Address</th>"
						+ "<th>Permanent Address</th><th>Department</th><th>Qualification</th>"
						+ "<th>Designation</th><th>Contact</th><th>Photo</th></tr>");
				int sn = 1;
				do {
					out.println("<tr><td>" + sn + "</td><td>" + rs.getString(1) + "</td><td>" + rs.getString(2) + "<br>"
							+ rs.getString(4) + "</td><td>" + rs.getString(3) + "</td><td>" + rs.getString(5) + "<br>"
							+ rs.getString(6) + "<br>" + rs.getString(7) + "</td><td>" + rs.getString(8) + "<br>"
							+ rs.getString(9) + "<br>" + rs.getString(10) + "</td><td>" + rs.getString(11) + "</td><td>"
							+ rs.getString(12) + "</td><td>" + rs.getString(13) + "</td><td>" + rs.getString(14)
							+ "<br>" + rs.getString(15) + "</td><td><img src=picture/employee/" + rs.getString(16)
							+ " height=50 width=70></td><td><a href=EmployeeEditDelete?eid=" + rs.getString(1)
							+ ">Edit/Delete</a></td>");
					sn++;
				} while (rs.next());
				out.print("</table>");

			} else {
				out.println("Record Not Found");
			}
			out.print("</html>");
			out.flush();

		} catch (Exception e) {
			out.println(e);
		}
	}

}
