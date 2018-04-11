package com.smartsecurity.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smartsecurity.contract.SmartSecurityContract.AdminEntry;
import com.smartsecurity.model.Admin;

/**
 * Servlet implementation class AdminHome
 */
@WebServlet("/AdminHome")
public class AdminHome extends HttpServlet implements AdminEntry {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminHome() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("deprecation")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession ses = request.getSession();
		PrintWriter out = response.getWriter();
		out.println("<html>"
				+ "<body style='font-family: Arial'>");
		Admin A;
		try {
			A = (Admin)ses.getValue("ADMINSESSION");
			String loginTime = (String)ses.getValue("SESSIONLOGINTIME");
			String navbar="<h4>Admin Id:"+A.getAdminId()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+A.getAdminName()
			+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+loginTime
			+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src=picture/"+A.getAdminPicture()
			+" width=40 height=40>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
			+ "<a href=AdminLogout>Logout</a></h4><hr color=Green>";
			out.println(navbar);
			
		} catch (Exception e) {
			out.println(e);
			response.sendRedirect("AdminLogin");
		}
		
		out.println("<table>"
				+ "<tr>"
				+ "<td valign=top>"
				+ "<a href=EmployeeView target=frame>Add Employee</a><br>"
				+ "<a href=EmployeeDisplayAll target=frame>Display Employees</a><br>"
				+ "<a href=EmployeeById target=frame>Edit Delete</a><br>"
				+ "</td>"
				+ "<td valign=top>"
				+ "<iframe name=frame width=400% height=700 frameborder=0></iframe>"
				+ "</td></tr></table></body></html>");
		out.flush();
	}

}
