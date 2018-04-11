package com.smartsecurity.view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smartsecurity.controller.VisitController;
import com.smartsecurity.model.Visit;

/**
 * Servlet implementation class VisitFinalEditDelete
 */
@WebServlet("/VisitFinalEditDelete")
public class VisitFinalEditDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VisitFinalEditDelete() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String btn = request.getParameter("btn");
		if (btn.equals("Update")) {
			
			Visit V = new Visit();
			V.setVisitTransactionId(request.getParameter("transactionid"));
			V.setVisitVisitorId(request.getParameter("vid"));
			V.setVisitRFID(request.getParameter("vrfid"));
			V.setVisitDepartmentId(request.getParameter("vdepartmentid"));
			V.setVisitPurpose(request.getParameter("vpurpose"));
			V.setVisitDate(request.getParameter("vdate"));
			V.setVisitCheckinTime(request.getParameter("vcheckin"));
			V.setVisitCheckoutTime(request.getParameter("vcheckout"));
			V.setVisitStatus(request.getParameter("vstatus"));
			
			boolean st = VisitController.EditRecord(V);
			
		} else if (btn.equals("Delete")) {
			boolean st = VisitController.DeleteRecord(Integer.parseInt(request.getParameter("transactionid")));
		}
		response.sendRedirect("VisitDisplayAll");
	}

}
