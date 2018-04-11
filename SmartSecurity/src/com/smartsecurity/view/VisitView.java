package com.smartsecurity.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VisitView
 */
@WebServlet("/VisitView")
public class VisitView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisitView() {
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
				+ "<form action='VisitSubmit' method='post'>"
				+ "<table>"
				+ "<caption><b><i>Visit Information</i></b></caption>"
				
				+ "<tr><td><b><i>Visitor ID:</i></b></td>"
				+ "<td><input type=text name=vid size=30></td></tr>"
				
				+ "<tr><td><b><i>Visit RFID:</i></b></td>"
				+ "<td><input type=text name=vrfid size=30></td></tr>"
				
				+ "<tr><td><b><i>Visiting Department ID:</i></b></td>"
				+ "<td><input type=text name=vdepartmentid size=30></td></tr>"
				
				+ "<tr><td><b><i>Visit Purpose:</i></b></td>"
				+ "<td><input type=text name=vpurpose size=30></td></tr>"
				
				+ "<tr><td><b><i>Visit Date:</i></b></td>"
				+ "<td><input type=date name=vdate></td></tr>"
				
				+ "<tr><td><b><i>Visit Checkin Time:</i></b></td>"
				+ "<td><input type=time name=vcheckin ></td></tr>"
				
				+ "<tr><td><b><i>Visit Checkout Time:</i></b></td>"
				+ "<td><input type=time name=vcheckout ></td></tr>"
				
				+ "<tr><td><b><i>Visit Status:</i></b></td>"
				+ "<td><input type=radio name=vstatus value=in>In<input type=radio name=vstatus value=out>Out</td></tr>"
				+ "</table><br>"
				+ "<input type=submit>&nbsp;&nbsp;<input type=reset></br>"
				+ "</form></html>");
		
		out.flush();
	}

}
