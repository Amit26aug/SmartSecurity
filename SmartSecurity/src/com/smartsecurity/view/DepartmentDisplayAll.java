package com.smartsecurity.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smartsecurity.contract.SmartSecurityContract.DepartmentEntry;
import com.smartsecurity.controller.DepartmentController;

/**
 * Servlet implementation class DepartmentDisplayAll
 */
@WebServlet("/DepartmentDisplayAll")
public class DepartmentDisplayAll extends HttpServlet implements DepartmentEntry {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentDisplayAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out= response.getWriter();
		out.println("<html>"
				+ "<body style='font-family: Arial'>");
		
		ResultSet rs= DepartmentController.getAllDepartments();
		
		try {
			if(rs.next()){
				out.println("<table border=1>"
						+ "		<caption><b> List Of Departments </b></caption>");
				out.println("<tr>"
						+ "<th> Serial No. </th>"
						+ "<th> Department ID </th>"
						+ "<th> Department Name </th>"
						+ "<th> Logo </th>"
						+ "<th> Update </th>"
						+ "</tr>");
				int sn = 1;
				do {
					out.println("<tr>"
							+ "<td>" + sn + "</td>"
							+ "<td>" + rs.getString(1)+ "</td>"
							+ "<td>" + rs.getString(2)+ "</td>"
							+ "<td>" + "<a href=picture/"+ rs.getString(3)+ ">"
											+ "<img src=picture/" + rs.getString(3)+ " width=90 height=90></a></td>"
							+ "<td>" + "<a href=DepartmentEditDelete?"+ COLUMN_DEP_ID+ "="+ rs.getString(1).trim()+ "> Edit/Delete </a></td>"
							+ "</tr>");
					sn++;

				} while (rs.next());
				
				out.print("</table>");				
			}
			else {
				out.println("<b> Records Not Found </b>");
			}
			
			out.println("</body>"
					+ "</html>");
			
		} catch (SQLException e) {
			System.out.println("Exception in DepartmentDisplayAll.doGet(): "+ e);
			out.println(e);
		}
	}

}
