package com.smartsecurity.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smartsecurity.controller.VisitController;
import com.smartsecurity.model.Visit;

/**
 * Servlet implementation class VisitEditDelete
 */
@WebServlet("/VisitEditDelete")
public class VisitEditDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisitEditDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Visit V = VisitController.DisplayByID(Integer.parseInt(request.getParameter("transactionid")));
		PrintWriter out=response.getWriter();
		
		out.println("<html>"
				+ "<form action='VisitFinalEditDelete' method=post>"
				+ "<input type=hidden value="+V.getVisitTransactionId()+" name=transactionid>"
				+ "<table cellspacing=10><tr>"
				+ "<td>"
				+ "<table>"
				+ "<caption><b><i>Visit Information</i></b></caption>"
				+ "<tr><td><b><i>Visitor ID:</i></b></td>"
				+ "<td><input type=text name=vid value='"+V.getVisitVisitorId()+"' size=30></td></tr>"
				
				+ "<tr><td><b><i>Visit RFID:</i></b></td>"
				+ "<td><input type=text name=vrfid value='"+V.getVisitRFID()+"' size=30></td></tr>"
			
				+ "<tr><td><b><i>Visiting Department ID:</i></b></td>"
				+ "<td><input type=text name=vdepartmentid value='"+V.getVisitDepartmentId()+"' size=30></td></tr>"
			
				+ "<tr><td><b><i>Visit Purpose:</i></b></td>"
				+ "<td><input type=text name=vpurpose value='"+V.getVisitPurpose()+"' size=30></td></tr>"
			
				+ "<tr><td><b><i>Visit Date:</i></b></td>"
				+ "<td><input type=text name=vdate value='"+V.getVisitDate()+"' size=30></td></tr>"
		
				+ "<tr><td><b><i>Visit Checkin Time:</i></b></td>"
				+ "<td><input type=text name=vcheckin value='"+V.getVisitCheckinTime()+"' size=30></td></tr>"
		
				+ "<tr><td><b><i>Visit Checkout Time:</i></b></td>"
				+ "<td><input type=text name=vcheckout value='"+V.getVisitCheckoutTime()+"' size=30></td></tr>"
		
				+ "<tr><td><b><i>Visit Status:</i></b></td>");
		
		if (V.getVisitStatus().equalsIgnoreCase("in")) {
			out.println("<td><input type=radio name=vstatus value='in' checked>In<input type=radio name=vstatus value='out'>Out</td></tr>");
		} else {
			out.println("<td><input type=radio name=vstatus value='in'>In<input type=radio name=vstatus value='out' checked>Out</td></tr>");
		}
		
		out.println("</table><br>"
				+ "<input type=submit value=Update name=btn>&nbsp;&nbsp;<input type=submit value=Delete name=btn></br>"
				+ "</form></html>");
	}

}
