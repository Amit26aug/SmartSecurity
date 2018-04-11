package com.smartsecurity.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smartsecurity.controller.VisitController;

/**
 * Servlet implementation class VisitDisplayAll
 */
@WebServlet("/VisitDisplayAll")
public class VisitDisplayAll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VisitDisplayAll() {
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
			ResultSet rs = VisitController.DisplayAll();
			if (rs.next()) {
				out.println("<table border = 1>");
				out.println("<caption>List Of Visits</caption>");
				out.println(
						"<tr><th>Sno</th><th>Visitor ID</th><th>Visit RFID</th><th>Visiting Department ID</th>"
						+ "<th>Visit Purpose</th><th>Visit Date</th>"
						+ "<th>Visit Checkin Time</th><th>Visit Checkout Time</th><th>Visit Status</th></tr>");
				int sn = 1;
				do {
					out.println("<tr><td>" + sn + "</td><td>" + rs.getString(2) + "</td><td>" + rs.getString(3)
							+ "</td><td>" + rs.getString(4) + "</td><td>" + rs.getString(5) + "</td><td>"
							+ rs.getString(6) + "</td><td>" + rs.getString(7) + "</td><td>" + rs.getString(8)
							+ "</td><td>" + rs.getString(9) + "</td><td><a href=VisitEditDelete?transactionid="
							+ rs.getString(1) + ">Edit/Delete</a></td>");
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
