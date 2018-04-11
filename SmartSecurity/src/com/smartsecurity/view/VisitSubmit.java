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
 * Servlet implementation class VisitSubmit
 */
@WebServlet("/VisitSubmit")
public class VisitSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VisitSubmit() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html>");

		Visit V = new Visit();
		V.setVisitVisitorId(request.getParameter("vid"));
		V.setVisitRFID(request.getParameter("vrfid"));
		V.setVisitDepartmentId(request.getParameter("vdepartmentid"));
		V.setVisitPurpose(request.getParameter("vpurpose"));
		V.setVisitDate(request.getParameter("vdate"));
		V.setVisitCheckinTime(request.getParameter("vcheckin"));
		V.setVisitCheckoutTime(request.getParameter("vcheckout"));
		V.setVisitStatus(request.getParameter("vstatus"));

		boolean st = VisitController.AddNewRecord(V);
		
		if (st) {
			out.println("<b>Record Submitted</b>");
		} else {
			out.println("<b>Fail to Submit Record</b>");
		}
		out.println("</html>");
		out.flush();
	}

}
