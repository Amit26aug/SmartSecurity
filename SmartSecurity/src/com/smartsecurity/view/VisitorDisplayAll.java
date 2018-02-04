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

import com.smartsecurity.contract.SmartSecurityContract.VisitorEntry;
import com.smartsecurity.controller.VisitorController;

/**
 * Servlet implementation class VisitorDisplayAll
 */
@WebServlet("/VisitorDisplayAll")
public class VisitorDisplayAll extends HttpServlet implements VisitorEntry {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VisitorDisplayAll() {
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
		out.println("<html>"
				+ "<body style='font-family: Arial'>");
		
		ResultSet rs= VisitorController.getAllVisitors();
		
		try {
			if(rs.next()){
				out.println("<table border=1>"
						+ "		<caption><b> List Of Visitors </b></caption>");
				out.println("<tr>"
						+ "<th> Serial No. </th>"
						+ "<th> Visitor ID </th>"
						+ "<th> Host Employee </th>"
						+ "<th> Visitor Name </th>"
						+ "<th> Address </th>"
						+ "<th> Contact Details </th>"
						+ "<th> Identification </th>"
						+ "<th> Photograph </th>"
						+ "<th> Update </th>"
						+ "</tr>");
				int sn = 1;
				do {
					out.println("<tr>"
							+ "<td>" + sn + "</td>"
							+ "<td>" + rs.getString(2)+ "</td>"
							+ "<td>" + rs.getString(1)+ "</td>"
							+ "<td>" + rs.getString(3)+ "</td>"
							+ "<td>" + rs.getString(4)+ "<br>"+ rs.getString(5)+ ", "+ rs.getString(6) + "</td>"
							+ "<td>" + "Mobile: "+ rs.getString(7)+ "<br>Email: "+ rs.getString(8) + "</td>"
							+ "<td>" + "ID No.: "+ rs.getString(9)+ "<br>ID Type: "+ rs.getString(10)+ "</td>"
							+ "<td>" + "<a href=picture/visitor/"+ rs.getString(11)+ ">"
											+ "<img src=picture/visitor/" + rs.getString(11)+ " width=90 height=90></a></td>"
							+ "<td>" + "<a href=VisitorEditDelete?"+ COLUMN_VISITOR_ID+ "="+ rs.getString(2).trim()+ "> Edit/Delete </a></td>"
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
			System.out.println("Exception in VisitorDisplayAll.doGet(): "+ e);
			out.println(e);
		}
	}

}
